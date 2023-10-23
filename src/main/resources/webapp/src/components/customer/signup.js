import React, { useState } from 'react';
import { useRecoilState } from 'recoil';
import axios from 'axios';
import { userState } from '../recoil/auth';

function  SignUp () {
  const [user, setUser] = useRecoilState(userState);
  const [formData, setFormData] = useState({
    id: '',
    password: '',
  });   

  const handleInputChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSignUp = async () => {
    try {
      const response = await axios.post('/api/signup', formData); // Replace with your backend API endpoint
      setUser(response.data); // Assuming your API returns user data on successful registration
    } catch (error) {
      console.error(error);
    }
    const adresshandle={
        click
    }
  };

  return (
    <div>
      <h2>Sign Up</h2>
      <input
        type="text"
        name="id"
        placeholder="id"
        value={formData.id}
        onChange={handleInputChange}
      />
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={formData.password}
        onChange={handleInputChange}
      />
      <input
        type="number"
        name="age"
        placeholder="age"
        value={formData.age}
        onChange={handleInputChange}
      />
      
    <input
        type="tesx"
        name="adress"
        placeholder="teail adress"
        value={formData.adress}
        onChange={handleInputChange}
      />
      <button>
      </button>
      <button onClick={handleSignUp}>Sign Up</button>
    </div>
  );
};

export default SignUp;
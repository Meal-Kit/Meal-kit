import React, { useState, useRef } from 'react';
import { useRecoilState } from 'recoil';
import axios from 'axios';
import { isAuthenticated } from '../../auth/auth';
import '../../style/login.scss';
import getAddress from '../../modul/AdressForm';


function SignUp() {
  const [user, setUser] = useRecoilState(isAuthenticated);
  const [formData, setFormData] = useState({
    id: '',
    password: '',
    age: '',
    address: '',
    postcode: '',
    roadAddress: '',
    jibunAddress: '',
    detailAddress: '',
    extraAddress: '',
  });
  const handleInputChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSignUp = async () => {
    try {
      const response = await axios.post('/api/signup', formData);
      setUser(response.data);
    } catch (error) {
      console.error(error);
    }
  };
  const handleDaumPostcode = async () => {
    try {
      const data = await getAddress();
      const roadAddr = data.roadAddress;

      // 주소 정보 업데이트
      setFormData({
        ...formData,
        postcode: data.zonecode,
        roadAddress: roadAddr,
        jibunAddress: data.jibunAddress,
        extraAddress: roadAddr ? `(${data.buildingName})` : '',
      });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className='signuppage'>
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
        type="text"
        name="e-mail"
        placeholder="e-mail"
        value={formData.email}
        onChange={handleInputChange}
      />
      <input
        type="number"
        name="age"
        placeholder="age"
        value={formData.age}
        onChange={handleInputChange}
      />
      {/* 주소*/}
      <input
        type="text"
        id="postcode"
        placeholder="우편번호"
        value={formData.postcode}
        onChange={handleInputChange}
      />
      {/* 주소찾기 버튼 */}
      <input
        type="button"
        onClick={handleDaumPostcode}
        value="우편번호 찾기"
      />
      <br />
      <input
        type="text"
        id="roadAddress"
        placeholder="도로명주소"
        value={formData.roadAddress}
        onChange={handleInputChange}
      />
      <input
        type="text"
        id="detailAddress"
        placeholder="상세주소"
        value={formData.detailAddress}
        onChange={handleInputChange}
      />
      <button onClick={handleSignUp}>Sign Up</button>
    </div>
  );
}

export default SignUp;
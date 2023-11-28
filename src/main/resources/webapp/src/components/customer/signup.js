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
        className='idbox'
        type="text"
        name="id"
        placeholder="아이디를 입력해주세요"
        value={formData.id}
        onChange={handleInputChange}
      />
      <input
        className='pwbox'
        type="password"
        name="password"
        placeholder="비밀번호를 입력해 주세요"
        value={formData.password}
        onChange={handleInputChange}
      />
      <input
      className='email'
        type="text"
        name="e-mail"
        placeholder="예:abc123@naver.com"
        value={formData.email}
        onChange={handleInputChange}
      />
      <input
        className='birth'
        type="birthmonth"
        name="age"
        placeholder="생년월일 예:991122"
        value={formData.age}
        onChange={handleInputChange}
      />
      <input
        className='phone'
        type="tel"
        name="phone"
        placeholder="전화번호"
        value={formData.phone}
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
        id="detail"
        placeholder="상세주소"
        value={formData.detail}
        onChange={handleInputChange}
      />
      <button onClick={handleSignUp}>Sign Up</button>
    </div>
  );
}

export default SignUp;
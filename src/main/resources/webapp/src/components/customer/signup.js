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
    birth: '',
    address: '',
    postcode: '',
    roadAddress: '',
    jibunAddress: '',
    detailAddress: '',
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
      <h1 >Sign Up</h1>
      <div className='need-section'>
      <span className='need'>*필수입력사항</span>
      </div>
      <hr/>

      <div className='section id'>
        <div className='exsection'>
        <label className='label id'>아이디
        <span className='needstar'>*</span>
        </label>
        </div>
      <input
        className='inputbox id'
        type="text"
        name="id"
        placeholder="id"
        value={formData.id}
        onChange={handleInputChange}
      />
      </div>

      <div className='section pw'>
        <div className='exsection'>
        <label className='label pw'>비밀번호
          <span className='needstar'>*</span>
        </label>
        </div>
      <input
        className='inputbox pw'
        type="password"
        name="password"
        placeholder="Password"
        value={formData.password}
        onChange={handleInputChange}
      />
      </div>
      <div className='section email'>
        <div className='exsection'>
        <label className='label email'>이메일
        <span className='needstar'>*</span></label>
        </div>
      <input
        className='inputbox id'
        type="text"
        name="e-mail"
        placeholder="e-mail"
        value={formData.email}
        onChange={handleInputChange}
      />
      </div>

        <div className='section birth'>
          <div className='exsection'>
          <label className='label birth'>생년월일
          <span className='needstar'>*</span>
          </label>
        </div>  
      <input
        className='inputbox birth'
        type="date"
        name="birth"
        value={formData.birth}
        onChange={handleInputChange}
      />
      </div>
      {/* 주소*/}
      <div  className='section adress'>
        <div className='exsection'>
      <label className='label adress'>주소
      <span className='needstar'>*</span>
      </label>
      </div>
      <input
        className='postnumber'
        type="text"
        id="postcode"
        placeholder="우편번호"
        value={formData.postcode}
        onChange={handleInputChange}
      />
      {/* 주소찾기 버튼 */}
      <input
        className='adressbtn'
        type="button"
        onClick={handleDaumPostcode}
        value="우편번호 찾기"
      />
      </div>
      <br></br>
      <input
        className='roadadress'
        type="text"
        id="roadAddress"
        placeholder="도로명주소"
        value={formData.roadAddress}
        onChange={handleInputChange}
      />
      <br/>
      <input
        className='detailadress'
        type="text"
        id="detailAddress"
        placeholder="상세주소"
        value={formData.detailAddress}
        onChange={handleInputChange}
      />
      <hr/>
    <div className='signupbtnsection'>
      <button className='signupbtn' onClick={handleSignUp}>Sign Up</button>
    </div>
    </div>
  );
}

export default SignUp;
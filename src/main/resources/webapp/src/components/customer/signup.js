import React, { useState, useRef } from 'react';
import { useRecoilState } from 'recoil';
import axios from 'axios';
import { isAuthenticated } from '../../auth/auth';
import '../../style/login.scss';
import getAddress from '../../modul/AdressForm';
import Button from '@mui/material/Button'
import '../../style/global.scss'

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
  const submitbtn ={
    height:'64px',
    textAlign: 'center'
  }


  return (
    <div className='signuppage'>
      <div className='global'>
      <a className='signuplabel'>Sign Up</a>
      <div className='need-section'>
      <span className='need'>
        <a className='needstar'>*</a>
        필수입력사항</span>
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
      <div className='same-section'>
        <Button className="same" style={submitbtn} variant="contained">
          <a className='samelabel' >중복확인</a></Button>
      </div>
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
        className='inputbox email'
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
        className='roadadress'
        type="text"
        id="roadAddress"
        placeholder="도로명주소(여길 클릭해주세요)"
        value={formData.roadAddress}
        onChange={handleInputChange}
        onClick={handleDaumPostcode}
      />
      </div>
      <br></br>
      <div className='secondline'>
      <input
        className='postnumber'
        type="text"
        id="postcode"
        placeholder="우편번호"
        value={formData.postcode}
        onChange={handleInputChange}
       
      />
      <input
        className='extraadress'
        type="text"
        id="extraadress"
        placeholder="추가주소"
        value={formData.extraAddress}
        onChange={handleInputChange}
       
      />
      </div>
      <br/>
      <input
        className='detailadress'
        type="text"
        id="Address"
        placeholder="상세주소"
        value={formData.detail}
        onChange={handleInputChange}
      />
      <hr/>
    <div className='signupbtnsection'>
      <Button className='signupbtn' size="large" variant="contained" onClick={handleSignUp}>
        <a className='labelsubmit'>Sign Up</a></Button>
    </div>
    </div>
    </div>
  );
}

export default SignUp;
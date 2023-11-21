import React, { useState } from 'react';
import { useRecoilState } from 'recoil';
import axios from 'axios';
import { Tokenstate } from '../../auth/auth';
import { useNavigate } from 'react-router-dom'; 
import '../../style/login.scss'

function Login () {
  const [token, setToken] = useRecoilState(Tokenstate);
  const [formData, setFormData] = useState({ id: '', pw: '' });
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      //백엔드 API 엔드포인트를 사용하도록 설정
      const response = await axios.post('/api/login', formData);

      // 로그인 성공 시 토큰을 Recoil 상태에 저장
      const { token } = response.data;
      setToken(token);
      
      // 성공하면 메인페이지 이동
      navigate('/')
    } catch (error) {
      
      // 로그인 실패 시 처리
    }
  };

  return (
    <div className="login">
      <h1>Login</h1>
      <input
        type="text"
        name="id"
        className='idbox'
        placeholder="아이디를 입력해주세요"
        value={formData.username}
        onChange={(e) => setFormData({ ...formData, id: e.target.value })}
      />
      <br/>
      <input
        type="password"
        name="password"
        className='pwbox'
        placeholder="비밀번호를 입력해주세요"
        value={formData.password}
        onChange={(e) => setFormData({ ...formData, password: e.target.value })}
      />
      <br/>
      <button className="btn"onClick={handleLogin}>로그인</button>
      <button className="btn" >
        <a className="signup"href='/signup'>회원가입</a>
        </button>
    </div>
  );
};

export default Login;
import React, { useState } from 'react';
import { useRecoilState } from 'recoil';
import axios from 'axios';
import { Tokenstate } from '../../auth/auth';
import { useNavigate } from 'react-router-dom'; 

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
      navigate('/home')
    } catch (error) {
      console.error(error);
      // 로그인 실패 시 처리
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input
        type="text"
        name="id"
        placeholder="id"
        value={formData.username}
        onChange={(e) => setFormData({ ...formData, id: e.target.value })}
      />
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={formData.password}
        onChange={(e) => setFormData({ ...formData, password: e.target.value })}
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
};

export default Login;
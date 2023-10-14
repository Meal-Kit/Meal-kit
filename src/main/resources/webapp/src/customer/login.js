import { useRecoilState } from "recoil";
import { LoginState } from "../recoil/Login.state";
import { useEffect } from "react";

function Login() {
    const token = window.location.href.split('?token=')[1];
    //토큰저장
    const  [isLoggedIn, setIsLoggedIn] = useRecoilState(LoginState);
    //login hook
   
    useEffect(() => {
        if (token) localStorage.setItem('customer', token)
        if (localStorage.getItem('customer')) setIsLoggedIn(true);
    }, []);
    return(
        
        <div>로그인페이지<br/>
	    	이메일 : <input type="text"/> <br/>
			비밀번호 : <input type="password"/> 
			<button >로그인</button>
        </div>
    )
}

export default Login;
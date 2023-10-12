import { Component } from "react";
import { useRecoilState } from "recoil";
import { LoginState } from "../recoil/Login.state";


class login extends Component{

    render(){
        return(
        <div>로그인페이지<br/>
	    	이메일 : <input type="text"/> <br/>
			비밀번호 : <input type="password"/> 
			<button >로그인</button>
        </div>
        
        );
    }
}
export default login
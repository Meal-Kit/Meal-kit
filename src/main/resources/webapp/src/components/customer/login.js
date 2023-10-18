import { useState } from "react"; 
import { Tokenstate, login } from "../../auth/auth";
import { useRecoilState } from "recoil";

function login(){
    const [id, setid] = useState("")
    const [pw, setpw] = useState("")
    const [token, settoken] = useRecoilState(Tokenstate)
    
    const idhandle = async (e) =>{
        setid({...values, [e.target.id]:e.target.value,});
    }
    const pwhandle = async (e) =>{
        setpw({...values, [e.target.pw]:e.target.value,});
    }
    const loginhandle= async () =>{
        try{
            const response = await axios.post('APILINk', {
                id,
                pw
            });
            const token = response.data.token;// 서버에 토큰을 받아 recoil에저장
            
            settoken(token);
        }catch(error){
            alert("아이디와 비밀번호를 확인해주세요", error)
        }
    }
        return(
    <div>
            <div>로그인페이지<br/>
                이메일 : <input id="id" onChange={idhandle} value={values.id} type="text"/> <br/>
                비밀번호 : <input id="pw" onChange={pwhandle} value={values.pw} type="password"/> 
                <button onclick={loginhandle}type="submit">로그인</button>
            </div>
    </div>
        );
    }
export default login
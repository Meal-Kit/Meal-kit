import { Component } from "react";
import { useRecoilState } from "recoil";
import { Tokenstate } from "../../auth/auth";


    
export default function Nav() {
    const[authToken, setToken] = useRecoilState(Tokenstate)
    const logouthandle = () =>{
        setToken(null);
    }
    return(
        <div>
            <div className="logo">Mealkit</div>
            <div className="serch box">
                <input type="box"></input>
            </div>
            <div className="guest">
                <div className="login">로그인</div>
            </div>
            <div className="user">
            <div className="home">배송지</div>
            <div className="cart">내정보</div>
            <div onclick={logouthandle} className="logout">로그아웃</div>
            </div>
        </div>

    );
    
} 

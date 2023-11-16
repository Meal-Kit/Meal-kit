import { Component } from "react";
import { useRecoilState, useRecoilValue } from "recoil";
import { Tokenstate } from "../../auth/auth";
import '../../style/Nav.scss';


    
export default function Nav() {
    //Recoil 상태를 수정하는데 사용
    const[authToken, setToken] = useRecoilState(Tokenstate)
    //Recoil 상태의 현재값을 반환
    const LoginState = useRecoilValue(Tokenstate)
    const logouthandle = () =>{
        setToken(null);
    }
    return(
        <div className="navbar">
            <div className="logo">Mealkit</div>
            <div className="search-box">
                <input className="box"type="box"placeholder="검색어를 입력해주세요."></input>
            </div>
            <div className="user-section">
                {LoginState?(
                    <div className="user">
                        <div className="navbarMenu">배송지</div>
                        <div className="navbarMenu">내정보</div>
                        <div className="navbarMenu">유저이름</div>
                        <div onclick={logouthandle} className="logout">로그아웃</div>
                    </div>
                ):(
                    <div className="guest">
                    <div className="navbarMenu">로그인</div>
                    </div>
            )}
            </div>
        </div>

    );
    
} 

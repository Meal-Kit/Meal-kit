import { Component} from "react";
import { useRecoilState, useRecoilValue } from "recoil";
import {Link} from 'react-router-dom';
import { Tokenstate } from "../../auth/auth";
import { GiHamburgerMenu } from "react-icons/gi";
import { FaSearch } from "react-icons/fa";
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
            {/* 카테고리 */}
            <div className="categorybox">
                <GiHamburgerMenu/>
                <div className="category">
                    카테고리
                    <ul className="subcategory-list">
                        <li>Subcategory 1</li>
                        <li>Subcategory 2</li>
                        <li>Subcategory 3</li>
                    </ul>
                </div>
            </div>
            {/* 검색창 */}
            <div className="search-box">
                <input className="box" type="box"placeholder="검색어를 입력해주세요."></input>
                <button className="faSearch">
                <FaSearch />
                </button>
            </div>
            {/* 유저영역 */}
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
                        <Link to='/login'className="navbarMenu" >로그인</Link></div>
            )}
            </div>
        </div>

    );
    
} 

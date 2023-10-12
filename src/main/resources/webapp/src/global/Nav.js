import { Component } from "react";



class Main extends Component {

    render(){
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
                <div className="logout">로그아웃</div>
                </div>
            </div>

        );
    }



}
export default Main;
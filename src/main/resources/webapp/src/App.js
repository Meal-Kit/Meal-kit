import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from "./components/main/main"
import Login from "./components/customer/login"
import SignUp from "./components/customer/signup"
import { RecoilRoot } from 'recoil';
import Nav from './components/global/Nav';
import Footer from './components/global/footer';

const App = () => {
  return(
      <div className='App'>
        <div className='App-content'>
        <RecoilRoot>
        <Nav/>
        <Routes>
          <Route  path="/"element={<Main/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<SignUp/>}/>
        </Routes>
        <Footer/>
        </RecoilRoot>
        </div>
      </div>
  );
}

export default App;

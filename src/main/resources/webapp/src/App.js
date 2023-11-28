import { BrowserRouter, Route, Routes } from 'react-router-dom';
<<<<<<< HEAD
import  Main  from "./main/main";
import Login from "./customer/login";
import Test from "./main/Test";
=======
import Main from "./components/main/main"
import Login from "./components/customer/login"
import SignUp from "./components/customer/signup"
>>>>>>> fd92e1591db9dc9dce416166e07e5cd5f1b88ed8
import { RecoilRoot } from 'recoil';
import Nav from './components/global/Nav';

const App = () => {
  return(
      <div className='App'>
        <RecoilRoot>
<<<<<<< HEAD
            <Routes>
              <Route  path="/"element={<Main/>}/>
              <Route path="/login" element={<Login/>}/>
              <Route path="/test" element={<Test/>}/>
            </Routes>
=======
        <Nav/>
        <Routes>
          <Route  path="/"element={<Main/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<SignUp/>}/>
        </Routes>
>>>>>>> fd92e1591db9dc9dce416166e07e5cd5f1b88ed8
        </RecoilRoot>
      </div>
  );
}

export default App;


import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from "./components/main/main"
import Login from "./components/customer/login"
import SignUp from "./components/customer/signup"
import { RecoilRoot } from 'recoil';

const App = () => {
  return(
    <BrowserRouter>
      <div className='App'>
        <RecoilRoot>
        <Routes>
          <Route  path="/"element={<Main/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<SignUp/>}/>
        </Routes>
        </RecoilRoot>
      </div>
      </BrowserRouter>
  );
}

export default App;

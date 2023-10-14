import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  Main  from "./main/main";
import Login from "./customer/login";
import Test from "./main/Test";
import { RecoilRoot } from 'recoil';

const App = () => {
  return(
      <div className='App'>
        <RecoilRoot>
            <Routes>
              <Route  path="/"element={<Main/>}/>
              <Route path="/login" element={<Login/>}/>
              <Route path="/test" element={<Test/>}/>
            </Routes>
        </RecoilRoot>
      </div>
  );
}

export default App;

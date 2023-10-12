
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  Main  from "./main/main";
import Login from "./customer/login";
import { RecoilRoot } from 'recoil';

const App = () => {
  return(
    <BrowserRouter>
      <div className='App'>
        <RecoilRoot>
        <Routes>
          <Route  path="/"element={<Main/>}/>
          <Route path="/login" element={<Login/>}/>
        </Routes>
        </RecoilRoot>
      </div>
      </BrowserRouter>
  );
}

export default App;

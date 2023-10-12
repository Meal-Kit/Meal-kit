import { atom } from 'recoil';
import { recoilPersist } from 'recoil-persist';

const { persistAtom } = recoilPersist;
//recoilPersist는 페이지가 변경되더라도 상태관리를 유지하기 위해 사용된다. 

export const LoginState = atom({
    key: 'loginState',
    default:false,
    effects_UNSTABLE: [persistAtom],
});
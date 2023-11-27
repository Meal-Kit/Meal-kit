import axios from "axios";
import { atom, selector } from "recoil"; 

/* Axios instance */
export const Auth = axios.create({
    baseUrl:'http://localhost:8080',
    headers:{
        'Content-Type': 'application/json',
    }
})
/*Token State*/
export const Tokenstate = atom({
    key:'Token',
    default: null
})

/*recoil selector로 JWT토큰 존재 유무 확인 */
export const isAuthenticated = selector({
    key: 'isAuthenticated',
    get: ({ get }) => {
        const token = get(Tokenstate);
        return !!token;
    },
});

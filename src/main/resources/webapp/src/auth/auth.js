import axios from "axios";
import { async } from "q";


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
/*regist State*/
export const registState = atom({
    key:'regist',
    default:{
        id:'',
        pw:'',
        confirpw:'',
        email:'',
        postnumber:'',
        detailadress:'',

    }
});

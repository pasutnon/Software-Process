import axios from 'axios'
import cookie from 'js-cookie'

export default axios.create({
    baseURL: "http://localhost:8081",
    timeout: 3000,
    headers: {
        'Authorization': 'Bearer ' + cookie.get('session')
    }
})
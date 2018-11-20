import axios from 'axios'
import cookie from 'js-cookie'

export default axios.create({
    baseURL: process.env.VUE_APP_API_URL,
    timeout: 3000,
    headers: {
        'Authorization': 'Bearer ' + cookie.get('session')
    }
})
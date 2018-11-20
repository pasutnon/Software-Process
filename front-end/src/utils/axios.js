import axios from 'axios'
import cookie from 'js-cookie'

const http = axios.create ({
  baseURL: process.env.VUE_APP_API_URL,
  timeout: 30000,
});

http.interceptors.request.use(
  function (config) {
    const token = cookie.get('session');
    if (token) config.headers.Authorization = `Bearer ${token}`;
    return config;
  },
  function (error) {
    return Promise.reject (error);
  }
);

export default http;
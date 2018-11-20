import cookies from 'js-cookie'
import axios from '../utils/axios'

export default async function auth({ next, router }) {
  axios.defaults.headers.common['Authorization'] = cookies.get('session')
  try {
    let {data} = await axios.get('users/me')
  }catch(err) {
    cookies.remove('session')
    cookies.remove('userId')
    return router.push({ name: 'user' });
  }
  return next();
}
import cookie from 'js-cookie'

export default {
    getUserId: () => {
        return cookie.get("userId")
    }
}
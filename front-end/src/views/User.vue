<template>
<div>
    <div class="text-xs-center" v-if="isloggedIn===false">
        <LoginHeader></LoginHeader>
        <b-container>
            <div v-if="errorMessage" class="alert alert-danger">{{errorMessage}}</div>
            <b-form-input type="text" placeholder="อีเมล / ชื่อผู้ใช่" v-model="username"></b-form-input>
            <b-form-input type="password" placeholder="รหัสผ่าน" v-model="password"></b-form-input>
            <b-row>
                <b-col cols="8"></b-col>
                <b-col cols="4"><router-link to="">ลืมรหัสผ่าน ?</router-link></b-col>
            </b-row>
            <b-row>
                <b-col cols="12"><v-btn color="deep-orange darken-2" class="button-login" dark @click="PageUser()">เข้าสู่ระบบ</v-btn></b-col>
                <b-col cols="12"><span>หรือ</span></b-col>
                <b-col cols="12">
                    <v-btn color="indigo" class="button-login" dark @click="loginWithFacebook()">
                        <v-icon size="24px">fab fa-facebook</v-icon>
                        &nbsp;&nbsp;&nbsp;เข้าสู่ระบบด้วย Facebook
                    </v-btn>
                </b-col>
            </b-row>
        </b-container>
    </div>
    <div class="" v-else>
        <AccoutHeader></AccoutHeader>
        <b-container>
            <b-list-group>
                <b-list-group-item>{{user.firstname || null}} {{user.lastname || null}}</b-list-group-item>
                <b-list-group-item href="#some-link">
                    ที่อยู่การจัดส่ง<v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon> 
                </b-list-group-item>
                <b-list-group-item href="#some-link">
                    การจ่ายเงิน <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
                </b-list-group-item>
                <div class="mb-3"></div>
                <b-list-group-item href="#some-link">
                    รายการที่สั่งซื้อทั้งหมด <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
                </b-list-group-item>
                <v-btn @click="logout()" color="deep-orange darken-2" style="width:auto" dark>ออกจากระบบ</v-btn>
            </b-list-group>
        </b-container>
    </div>
</div>
</template>

<script>
import cookies from 'js-cookie'
import { mapMutations, mapGetters } from "vuex";
import axios from '../utils/axios.js'
import LoginHeader from '../components/header/LoginHeader'
import AccoutHeader from '../components/header/AccoutHeader'
    export default {
        name: "user",
        components: {
            LoginHeader,
            AccoutHeader
        },
        data() {
            return {
                isloggedIn: false,
                errorMessage: '',
                user: {
                    firstname: '',
                    lastname: ''
                }
            }
        },
        sharedState: {

        },
        methods:{
            PageUser() {
                this.errorMessage = ''
                axios.post('/users/signin',{
                    username: this.username,
                    password: this.password
                })
                .then(async response => {
                    cookies.set('session', response.data.token)
                    cookies.set('userId', response.data.userId)
                    let {data: userData} = await axios.get(`/users/${response.data.userId}`)
                    this.isloggedIn = true
                    this.user = userData
                    console.log(this.user)
                })
                .catch(error => {
                    console.log(error)
                    this.errorMessage = 'ชื่อผู้ใช้ หรือ รหัสผ่าน ไม่ถูกต้อง'
                })
            },
            logout() {
                cookies.remove('session')
                cookies.remove('userId')
                this.isloggedIn = false
            },
            loginWithFacebook() {
                FB.login((result) => {
                    axios.get(`https://graph.facebook.com/v3.2/me?fields=name,first_name,last_name,email&access_token=${result.authResponse.accessToken}`)
                    .then( response => {
                        axios.post(`/users/signin/fb`, {
                            token: response.data.id,
                            email: response.data.email,
                            firstName: response.data.first_name,
                            lastName: response.data.last_name
                        })
                        .then( async response => {
                            cookies.set('session', response.data.token)
                            cookies.set('userId', response.data.userId)
                            let {data: userData} = await axios.get(`/users/${response.data.userId}`)
                            this.isloggedIn = true
                            this.user = userData
                            console.log(this.user)
                        })
                        .catch( error => {
                            this.errorMessage = 'มีผู้ใช้ Email address นี้แล้ว'
                        })
                    })
                    .catch( error => {
                        console.log(error)
                        this.errorMessage = 'ไม่สามารถเข้าสู่ระบบได้ กรุณาลองใหม่ภายหลัง'
                    })
                }, { scope: 'email' })
            }
        }
    }
</script>

<style>
.hr-1 {
  border: 2px solid orangered;
  padding: 0px;
  margin: 0px;
}
.button-login{
  width: 90%;
}
</style>

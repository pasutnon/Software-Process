<template>
<div>
    <div class="text-xs-center" v-if="user">
        <LoginHeader></LoginHeader>
        <b-container>
            <b-form-input type="text" placeholder="อีเมล / ชื่อผู้ใช่"></b-form-input>
            <b-form-input type="password" placeholder="รหัสผ่าน"></b-form-input>
            <b-row>
                <b-col cols="8"></b-col>
                <b-col cols="4"><router-link to="">ลืมรหัสผ่าน ?</router-link></b-col>
            </b-row>
            <b-row>
            <b-col cols="12"><v-btn color="deep-orange darken-2" class="button-login" dark @click="PageUser()">เข้าสู่ระบบ</v-btn></b-col>
            <b-col cols="12"><span>หรือ</span></b-col>
            <b-col cols="12"><v-btn color="indigo" class="button-login" dark><v-icon size="24px">fab fa-facebook</v-icon>&nbsp;&nbsp;&nbsp;เข้าสู่ระบบด้วย Facebook</v-btn></b-col>
            </b-row>
        </b-container>
    </div>
    <div class="text-xs-center" v-else>
        <AccoutHeader></AccoutHeader>
        <v-progress-linear class="hr-1" value=100
        color="#F5580C" height="3"></v-progress-linear>
    </div>
</div>
</template>

<script>
import LoginHeader from '../components/header/LoginHeader';
import AccoutHeader from '../components/header/AccoutHeader';
    export default {
        name: "user",
        components: {
            LoginHeader,
            AccoutHeader
        },
        data() {
            return {
                user: true
            }
        },
        methods:{
            PageUser(){
                this.user = false
            }
        }
    };
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

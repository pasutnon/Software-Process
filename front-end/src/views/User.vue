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
    <div class="" v-else>
        <AccoutHeader></AccoutHeader>
        <b-container>
            <b-list-group>
                <b-list-group-item>user</b-list-group-item>
                <b-list-group-item href="#some-link">
                    ที่อยู่การจัดส่ง<v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon> 
                </b-list-group-item>
                <b-list-group-item href="#some-link">
                    การจ่ายเงิน <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
                </b-list-group-item>
                <br/>
                <b-list-group-item href="#some-link">
                    รายการที่สั่งซื้อทั้งหมด <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
                </b-list-group-item>
                <v-btn color="deep-orange darken-2" style="width:auto" dark>ออกจากระบบ</v-btn>
            </b-list-group>
        </b-container>
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

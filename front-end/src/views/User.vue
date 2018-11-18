<template>
<div>
    <div class="text-xs-center" v-if="user">
        <v-toolbar color="while" card>
            <v-spacer></v-spacer>
            <router-link to="">มีบัญชีแล้วหรือยัง ?&nbsp;</router-link>
            <v-btn color="deep-orange darken-2" class="button-r" dark>ลงทะเบียน</v-btn>
            <v-spacer></v-spacer>
        </v-toolbar>
            <hr class="hr-1" />
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
        <v-toolbar color="while" card>
            <v-spacer></v-spacer>
            <h4 class="text-nav">บัญชีของคุณ</h4>
            <v-spacer></v-spacer>
        </v-toolbar>
            <hr class="hr-1" />
    </div>
</div>
</template>

<script>
export default {
    name: "user",
    components: {},
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
.button-r{
  width: 20%;
}
.text-nav{
    color: orangered;
}
</style>

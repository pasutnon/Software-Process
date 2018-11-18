<template>
<div class="text-xs-center">
    <v-toolbar>
    </v-toolbar>
<b-container>
    <b-form-input type="text" placeholder="อีเมล / ชื่อผู้ใช่"></b-form-input>
    <b-form-input type="password" placeholder="รหัสผ่าน"></b-form-input>
    <b-row>
        <b-col cols="8"></b-col>
        <b-col cols="4"><a href="#">ลืมรหัสผ่าน ?</a></b-col>
    </b-row>
    <b-row>
    <b-col cols="12"><v-btn color="deep-orange darken-2" dark>เข้าสู่ระบบ</v-btn></b-col>
    <b-col cols="12"><span>หรือ</span></b-col>
    <b-col cols="12"><v-btn color="indigo" dark><v-icon size="24px">fab fa-facebook</v-icon>&nbsp;&nbsp;&nbsp;เข้าสู่ระบบด้วย Facebook</v-btn></b-col>
    </b-row>
</b-container>
</div>
</template>

<script>
 export default {
        name: 'user',
        components: {
        }
    }
</script>

<style>
.v-btn {
    width: 90%;
  }
</style>

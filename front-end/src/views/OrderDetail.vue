<template>
<div>

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
                <v-btn color="deep-orange darken-2" style="width:auto" dark>ชำระเงินเดี๋ยวนี้</v-btn>
            </b-list-group>
        </b-container>
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

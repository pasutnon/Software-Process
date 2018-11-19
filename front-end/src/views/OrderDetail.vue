<template>
<div>

        <b-container>
            <b-list-group>
                <b-list-group-item href="#some-link">
                    ที่อยู่การจัดส่ง<v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon> 
                </b-list-group-item>
                <b-list-group-item href="#some-link">
                    การจ่ายเงิน <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
                </b-list-group-item>
                <br/>
                <b-list-group-item>
                    ราคาสินค้า <v-text color="#F5580C" style="float: right;">฿39</v-text>
                </b-list-group-item>
                <b-list-group-item>
                    ค่าจัดส่ง <v-text color="#F5580C" style="float: right;">฿39</v-text>
                </b-list-group-item>
                <br/>
                <b-list-group-item>
                    รวมทั้งสิ้น <v-text color="#F5580C" style="float: right;">฿39</v-text>
                </b-list-group-item>
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

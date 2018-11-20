<template>
<div>
    <OrderDetailHeader link="/cart"></OrderDetailHeader>
    <v-progress-linear class="hr-1" :indeterminate="true" v-if="loading1 || loading2"
    color="#F5580C" height="3"></v-progress-linear>
    <v-progress-linear class="hr-1" value=100 v-else
    color="#F5580C" height="3"></v-progress-linear>
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
    <button class="btn-block button-add"> 
        ชำระเงินเดี๋ยวนี้
    </button>
</div>
</template>

<script>
import OrderDetailHeader from '../components/header/OrderDetailHeader';
import { mapActions } from 'vuex'
import axios from "axios"
    export default {
        name: "OrderDetail",
        components: {
            OrderDetailHeader
        },
        data() {
            return {
                loading1:true,
                loading2:true
            }
        },
        methods:{
            ...mapActions(['setIsShowToolBar'])
        },
        mounted () {
            this.setIsShowToolBar(false)
        }
    };
</script>

<style>
.hr-1 {
  border: 2px solid orangered;
  padding: 0px;
  margin: 0px;
}
.btn-block{
  position: fixed;
  bottom: 0;
  margin-bottom: 0 !important;
  height: 40px;
}
.button-add {
    background-color: #F5580C; 
    color: white;
}
.button-add:hover {
    background-color: white;
    color: #F5580C;
}
</style>

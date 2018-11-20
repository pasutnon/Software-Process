<template>
<div>
     <OrderDetailHeader link="/cart"></OrderDetailHeader>

    <v-progress-linear class="hr-1" :indeterminate="true" v-if="loading1 || loading2"
    color="#F5580C" height="3"></v-progress-linear>
    <v-progress-linear class="hr-1" value=100 v-else
    color="#F5580C" height="3"></v-progress-linear>
    <b-container>
        <div>
        <v-layout row wrap style="test-align:center; margin:auto;">
                    <div v-for="(product) in cart" v-bind:key="product.ID">
                        <ProductImage :id="product.productId"/>
                        <div class="product_name">นมจืด ดัชมิลล์ 180 มล.</div>
                        <br>
                        <div>{{product.quantity}}</div><div class="product_price">x ฿39</div>
                    </div>
        </v-layout>
        </div>
        <b-list-group>
            <b-list-group-item href="#some-link">
                ที่อยู่การจัดส่ง<v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon> 
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
         <v-btn color="deep-orange darken-2" style="width:100" dark>ชำระเงินเดี๋ยวนี้</v-btn>
    </b-container>
</div>
</template>

<script>
import OrderDetailHeader from "../components/header/OrderDetailHeader";
import { mapActions } from "vuex";
import axios from "axios";
import ShowProducts from "../components/ShowProducts";
import ProductImage from "../components/ProductImage";

export default {
  name: "OrderDetail",
  components: {
    OrderDetailHeader
  },
  data() {
    return {
      loading1: true,
      loading2: true
    };
  },
  methods: {
    ...mapActions(["setIsShowToolBar"])
  },
  mounted() {
    this.setIsShowToolBar(false);
  }
};
</script>

<style>
.hr-1 {
  border: 2px solid orangered;
  padding: 0px;
  margin: 0px;
}
.button-login {
  width: 90%;
}
</style>


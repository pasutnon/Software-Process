<template>
<div>
    <OrderDetailHeader></OrderDetailHeader>
    <b-container>
        <v-list v-for="(product) in cart" v-bind:key="product.ID">
            <b-row>
                <b-col cols="6" class="text-xs-center">
                    <ProductImage :id="product.productId"/>
                </b-col>
                <b-col cols="6">
                    <div class="mb-3"></div>
                    <p>{{product.productName}}</p>
                    <p style="color:#F5580C;">{{product.quantity | formatNumber}} x ฿ {{product.price | formatNumber}}</p>
                </b-col>
            </b-row>
        </v-list>
        <b-list-group>
            <b-list-group-item href="#some-link">
                ที่อยู่การจัดส่ง<v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon> 
            </b-list-group-item>
<<<<<<< HEAD
            <br/>
=======
            <b-list-group-item href="#some-link">
                การจ่ายเงิน <v-icon color="#F5580C" style="float: right;">arrow_forward</v-icon>
            </b-list-group-item>
            <div class="mb-3"></div>
>>>>>>> b0ebfcfef2152ed5ae66e6c9fcbd76ca63c97cb7
            <b-list-group-item>
                รวมราคาสินค้า <v-text color="#F5580C" style="float: right;">฿ {{totalCartPrice | formatNumber}}</v-text>
            </b-list-group-item>
            <b-list-group-item>
                ค่าจัดส่ง <v-text color="#F5580C" style="float: right;">฿ {{DeliveryPrice | formatNumber}}</v-text>
            </b-list-group-item>
            <div class="mb-3"></div>
            <b-list-group-item>
                รวมทั้งสิ้น <v-text color="#F5580C" style="float: right;">฿ {{totalCartPrice+DeliveryPrice | formatNumber}}</v-text>
            </b-list-group-item>
        </b-list-group>
         <v-btn color="deep-orange darken-2" style="width:100" dark>ชำระเงินเดี๋ยวนี้</v-btn>
    </b-container>
<<<<<<< HEAD
=======
    <br/><br/>
    <button class="btn-block button-add"> 
        ชำระเงินเดี๋ยวนี้
    </button>
>>>>>>> b0ebfcfef2152ed5ae66e6c9fcbd76ca63c97cb7
</div>
</template>

<script>
<<<<<<< HEAD
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
=======
import OrderDetailHeader from '../components/header/OrderDetailHeader';
import ProductImage from "../components/ProductImage";
import { mapActions,mapGetters } from 'vuex'
import axios from "axios"
    export default {
        name: "OrderDetail",
        components: {
            OrderDetailHeader,
            ProductImage
        },
        data() {
            return {
                DeliveryPrice:40
            }
        },
        methods:{
            ...mapActions(['setIsShowToolBar'])
        },
        mounted () {
            this.setIsShowToolBar(false)
        },
        computed:{
            ...mapGetters([
            'totalItemInCart',
            'totalCartPrice',
            'cart'
            ])
        }
>>>>>>> b0ebfcfef2152ed5ae66e6c9fcbd76ca63c97cb7
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


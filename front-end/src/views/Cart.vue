<template>
  <div>
      <div>
          <v-toolbar color="white" height="50.00px" card>
              <v-spacer></v-spacer>
              <h4>รถเข็น</h4>
              <v-spacer></v-spacer>
          </v-toolbar>
          <v-progress-linear class="hr-1" value=100
                             color="#F5580C" height="3"></v-progress-linear>
      </div>
      <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
          <v-flex xs12 class="align-items-stretch" v-for="(product, index) in cart" v-bind:key="index">
              <v-card class="d-flex" style="height: 100%">
                <div class="align-self-center">
                    <b-row>
                        <b-col cols="4">
                          <router-link :to="`/product/detail/${product.productId}`">
                              <div class="text-xs-center">
                                <ProductImage :id="product.productId"/>
                              </div>
                          </router-link>
                        </b-col>
                            <b-col cols="8">
                                <div class="product_name">{{product.productName}}</div>
                                <div class="addProduct">
                                    <button @click="reduceProductInCart(product)">-</button>
                                        {{product.quantity}}
                                    <button @click="addProductInToCart(product)">+</button>
                                        <div class="product_price">฿ {{product.price | formatNumber}}</div>
                                </div>
                            </b-col>
                    </b-row>
                </div>
              </v-card>
          </v-flex>
    </v-layout>
  </v-container>


    <div>
        <span>
            <h2>รวม ฿ {{ totalCartPrice | formatNumber }}</h2>
            <h2>ชำระเงิน {{ totalItemInCart | formatNumber }}</h2>
        </span>

    </div>
    </div>
</template>

<script>
import HomeHeader from '../components/header/HomeHeader';
import { mapMutations, mapGetters } from "vuex";
import axios from "axios";
import ProductImage from "../components/ProductImage";
import numeral from "numeral";
import vue from "vue";
export default {
components: {
    ProductImage,
    HomeHeader,
  },
  // name: 'cart',
  data() {
    return {
    };
  },
  computed: {
    ...mapGetters(["totalItemInCart", "totalCartPrice", "cart"])
  },

  methods: {
    ...mapMutations([
      "addProductInToCart",
      "reduceProductInCart",
      "removeProductInCart"
    ])
  },
};
</script>
<style>
button{
    text-align: center;
    margin: 2px !important;
    width: 25px;
    height: 25px;
    color: white;
    background-color: #F5580C;
}
.hr-1 {
    border: 2px solid orangered;
    padding: 0px;
    margin: 0px;
}
</style>



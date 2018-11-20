<template>
  <div>
  <div>
        <HomeHeader></HomeHeader>
  </div>
      <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
          <v-flex xs6 class="align-items-stretch" v-for="(product, index) in cart" v-bind:key="index">
              <v-card class="d-flex" style="height: 100%">
                <div class="align-self-center">
                  <router-link :to="`/product/detail/${product.productId}`">
                    <ProductImage :id="product.productId"/>
                  </router-link>
                  <div class="product_name">{{product.productName}}</div>
                  <div class="product_price">฿{{product.price | formatNumber}}</div>
                  <div class="addProduct">
                  <button @click="reduceProductInCart(product)">-</button>
                  {{product.quantity}}
                  <button @click="addProductInToCart(product)">+</button>
                  <!-- <button @click="removeProductInCart(product)">remove</button> -->
                  </div>
                </div>
              </v-card>
          </v-flex>
    </v-layout>
  </v-container>


    <div>
        <span>
            <v-card style="color:F5580C;">รวมค่าสินค้า {{ totalCartPrice }} Baht</v-card>
            <h2>Total Products : {{ totalItemInCart }}</h2>
        </span>

    </div>
    <div class="col-7 text-right">
            <b-button variant="danger"></b-button>
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
    width: 50px;
    height: 25px;
    color: white;
    background-color:#F5580C; 

  }
</style>





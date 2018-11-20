<template>
<div class="mb-5">
  <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
          <v-flex xs6 class="align-items-stretch" v-if="products && products.length" v-for="(product, index) in products" :key="index">
              <v-card class="d-flex" style="height: 100%">
                <div class="align-self-center">
                  <router-link :to="`/product/detail/${product.productId}`">
                    <ProductImage :id="product.productId"/>
                  </router-link>
                  <div class="product_name">{{product.productName}}</div>
                  <div class="product_price">฿{{product.price | formatNumber}}</div>
                  <div class="addProduct">
                  <v-btn @click="addProductInCart(product)" color="#F5580C" >ใส่รถเข็น</v-btn>
                  </div>
                </div>
              </v-card>
          </v-flex>
    </v-layout>
  </v-container>
  </div>

</template>

<script>
import ProductImage from "./ProductImage";
import axios from "../utils/axios.js";
import numeral from "numeral";
import vue from "vue";
import { mapGetters, mapMutations } from "vuex";

export default {
  name: "ShowProducts",
  components: {
    ProductImage
  },
  data() {
    return {
      products: []
    };
  },
  created() {
    axios
      .get("/products")
      .then(response => (this.products = response.data));
  },
  computed: {
    ...mapGetters(['cart'])
  },
  methods: {
    ...mapMutations({
      addProductInCart: 'addProductInToCart'
    })
  }
};

vue.filter("formatNumber", function (value) {
  return numeral(value).format("0,0");
});
</script>

<style>
.product_name
{font-size: 100%;
margin-left: 5px;
text-align: left;
}
.product_price
{font-size: 100%;
text-align: left;
margin-left: 5px;
color:#F5580C;
}
.addProduct
{
  text-align: right;
}
</style>

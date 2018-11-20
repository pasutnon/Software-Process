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

                  <b-container>
                  <b-row>
                  <b-col cols>
                  <div class="product_name">{{product.productName}}</div>
                    <br>
                  <div class="product_price">฿{{product.price | formatNumber}}</div>
                  </b-col>
                  <b-col cols>
                  <div class="addProduct"><v-btn @click="addProductInCart(product)" color="#F5580C" ><img src="..\assets\Cart-White.svg"></v-btn></div>
                  </b-col>
                  </b-row>
                  </b-container>
             </div>
              </v-card>
          </v-flex>
    </v-layout>
  </v-container>
  </div>

</template>

<script>
import ProductImage from "./ProductImage";
import axios from "axios";
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
      .get("https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products")
      .then(response => (this.products = response.data));
  },
  computed: {
    ...mapGetters(["cart"])
  },
  methods: {
    ...mapMutations({
      addProductInCart: "addProductInToCart"
    })
  }
};

vue.filter("formatNumber", function(value) {
  return numeral(value).format("0,0");
});
</script>

<style>
.product_name {
  font-size: 100%;
  margin-left: 5%;
  text-align: left;
}
.product_price {
  font-size: 100%;
  text-align: left;
  margin-left: 5%;
  color: #f5580c;
}
.addProduct {
  text-align: right;
  margin-right: 5%;
}
</style>



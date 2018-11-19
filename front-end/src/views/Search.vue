<template>
<v-home style="text-align:center !important; magin:auto !important;">
  <div>
        <HomeHeader></HomeHeader>
        <br>
          <div class="searchform">
    <h4>Find By Name</h4>
    <div class="form-group">
      <input class="form-control" v-model="name" type="search" required>
    </div>
 
    <div class="btn-group">
      <v-btn @click="searchProducts()" color="#F5580C">Search</v-btn>
    </div>
 
  <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
          <v-flex xs6 v-if="products && products.length" v-for="product in products" :key="product" style="text-align:center; ">
            <div>
              <v-card>
                <ProductImage :id="product.productId"/>
                  <div>{{product.productName}}</div>
                  <div color="#F5580C">฿{{product.price | formatNumber}}</div>
                <v-btn @click="addProductInCart(product)" color="#F5580C">ใส่รถเข็น</v-btn>
              </v-card>
            </div>
          </v-flex>
    </v-layout>
  </v-container>
  </div>
        
  </div>
</v-home>
</template>

<script>
import HomeHeader from "../components/header/HomeHeader";
import ProductImage from "../components/ProductImage";
import axios from "axios";
import numeral from "numeral";
import vue from "vue";
import { mapGetters, mapMutations } from "vuex";

export default {
  components: {
    ProductImage,
    HomeHeader,
    name: "search-product"
    },
    data() {
      return {
        name: "",
        products: []
      };
    },
    methods: {
      /* eslint-disable no-console */
      searchProducts: function() {
        axios
          .get("https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products/name/containing/"+this.name)
          .then(response => {
            this.products = response.data; // JSON are parsed automatically.
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }
      /* eslint-enable no-console */
    }
  
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}

</style>

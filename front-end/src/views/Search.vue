<template>
<div>
  <div>
  <div class="hearder">
      <div class="searchform">
        <v-toolbar color="white" height="50.00px" card>
          <v-spacer></v-spacer>
            <input class="input"
            v-model="name"
            placeholder="  ค้นหาเลยไหม ?"
            @keyup.enter="searchProducts()"/>
            <v-spacer></v-spacer>
        </v-toolbar>
        <v-progress-linear class="hr-1" :indeterminate="true" v-if="loading"
        color="#F5580C" height="3"></v-progress-linear>
        <v-progress-linear class="hr-1" value=100 v-else
        color="#F5580C" height="3"></v-progress-linear>
      </div>
    </div>
  </div>
  <br/><br/>    
  <div class="mb-5">
    <v-container
      fluid
      grid-list-md
      >
      <v-layout row wrap>
            <v-flex xs6 v-if="products && products.length" v-for="product in products" :key="product" class="align-items-stretch">
              <v-card class="d-flex" style="height: 100%">
                <div class="align-self-center">
                  <router-link :to="`/product/detail/${product.productId}`">
                    <div class="text-xs-center">
                      <ProductImage :id="product.productId"/>
                    </div>
                  </router-link>
                    <div class="product_name">{{product.productName}}</div>
                    <div class="product_price">฿{{product.price | formatNumber}}</div>
                    <div class="addProduct">
                      <v-btn @click="addProductInCart(product)" color="#F5580C" ><img src="../assets/Cart-White.svg"></v-btn>
                    </div>
                </div>
              </v-card>
            </v-flex>
      </v-layout>
    </v-container>
  </div>
</div>
</template>

<script>
import HomeHeader from "../components/header/HomeHeader";
import ProductImage from "../components/ProductImage";
import axios from "axios";
import numeral from "numeral";
import vue from "vue";
import { mapActions,mapGetters, mapMutations } from "vuex";

export default {
  name: "search-product",
  components: {
    ProductImage,
    HomeHeader,
  },
  data() {
    return {
      name: "",
      products: [],
      loading:false
    };
  },
  mounted() {
    this.setIsShowToolBar(true)
  },
  methods: {
    ...mapActions(['setIsShowToolBar']),
    ...mapMutations({ addProductInCart: 'addProductInToCart' }),
    searchProducts: function() {
      this.loading = true
      axios
        .get(
          "https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products/name/containing/" +
            this.name
        )
        .then(response => {
          this.products = response.data; // JSON are parsed automatically.
          console.log(response.data);
          this.loading = false
        })
        .catch(e => {
          console.log(e);
          this.loading = false
        });
    }
  }
};
</script>
<style>
.hr-1 {
  padding: 0px;
  margin: 0px;
}
.input {	
	padding: 3px;
	border-radius: 9999em;
  box-shadow: 
  inset 0 0 0 2px #F5580C;
  color:#F5580C;
  font-size: 1.4em;
}
.hearder{
  position: fixed;
  top: 0;
  width: 100%;
  margin-top: 0 !important;
  z-index: 100;
}
</style>

<template>
<div>
  <div>
    <v-toolbar color="white" height="50.00px" card>
      <v-spacer></v-spacer>
        <v-text-field 
        flat
        solo-inverted
        label="ค้นหาเลยไหม ?" 
        v-model="name"
        hide-details
        @keyup.enter="searchProducts()"/>
      <v-spacer></v-spacer>
    </v-toolbar>
      <v-progress-linear class="hr-1" :indeterminate="true" v-if="loading"
      color="#F5580C" height="3"></v-progress-linear>
      <v-progress-linear class="hr-1" value=100 v-else
      color="#F5580C" height="3"></v-progress-linear>
  </div>
      <v-container
        fluid
        grid-list-md
        >
        <v-layout row wrap>
              <v-flex xs6 v-if="products && products.length" v-for="product in products" :key="product" style="text-align:center; ">
                <div>
                  <v-card>
                    <router-link :to="`/product/detail/${product.productId}`">
                      <ProductImage :id="product.productId"/>
                    </router-link>
                      <div>{{product.productName}}</div>
                      <div color="#F5580C">฿{{product.price | formatNumber}}</div>
                    <v-btn @click="addProductInCart(product)" color="#F5580C">ใส่รถเข็น</v-btn>
                  </v-card>
                </div>
              </v-flex>
        </v-layout>
      </v-container>
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
</style>

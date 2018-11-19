<template>
<div>
  <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
<<<<<<< HEAD
          <v-flex xs6 v-if="products && products.length" v-for="product in products" :key="product" style="text-align:center; ">
            <div>
              <v-card>
                <ProductImage :id="product.productId"/>
                  <div class="name">{{product.productName}}</div>
                  <div class="price">฿{{product.price | formatNumber}}</div>
                  <div class="addProduct">
                    <v-btn @click="addProductInCart(product)" color="#F5580C" >ใส่รถเข็น</v-btn>
                  </div>
=======
          <v-flex xs6 class="align-items-stretch" v-if="products && products.length" v-for="(product, index) in products" :key="index">
              <v-card class="d-flex" style="height: 100%">
                <div class="align-self-center">
                  <ProductImage :id="product.productId"/>
                  <div class="product_name">{{product.productName}}</div>
                  <div class="product_price">฿{{product.price | formatNumber}}</div>
                  <div class="addProduct">
                  <v-btn @click="addProductInCart(product)" color="#F5580C" >ใส่รถเข็น</v-btn>
                  </div>
                </div>
>>>>>>> 290906a034f0f2631c1a9d20c7d2febc1b0ec046
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

<<<<<<< HEAD
<style>
.name
{
  font-size: 100%;
  text-align: left;
  margin-left: 5%;
}
.price
{
  font-size: 100%;
  text-align: left;
  margin-left: 5%;
  color: #F5580C;
}
.addProduct
{
  text-align: right;
}
=======
>>>>>>> 290906a034f0f2631c1a9d20c7d2febc1b0ec046
</style>
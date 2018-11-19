<template>
<div>
  <v-container
          fluid
          grid-list-md
        >
    <v-layout row wrap>
          <v-flex xs6 v-if="products && products.length" v-for="product in products" :key="product" style="text-align:center; ">
            <div>
              <v-card>
                <ProductImage :id="product.productId"/>
                  <div class="name">{{product.productName}}</div>
                  <div class="price">฿{{product.price | formatNumber}}</div>
                  <div class="addProduct">
                    <v-btn @click="addProductInCart(product)" color="#F5580C" >ใส่รถเข็น</v-btn>
                  </div>
              </v-card>
            </div>
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

export default {
  name: "ShowProducts",
  components: {
    ProductImage
  },
  data() {
    return {
      products: [],
      cart: []
    };
  },

  created() {
    axios

      .get("https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products")
      .then(response => (this.products = response.data));
  },
  methods: {
    addProductInCart: function(product) {
      let localCart = localStorage.getItem("cart");

      if (localCart === null) {
        this.cart = [];
      } else {
        this.cart = JSON.parse(localCart);
      }

      let duplicateProductInCart = this.cart.find(eachItemInCart => {
        return product.productId === eachItemInCart.productId;
      });
      if (duplicateProductInCart !== undefined) {
        duplicateProductInCart.quantity += 1;
        // this.cart = cart
      } else {
        product.quantity = 1;
        this.cart.push(product);
      }
      this.saveCart();
      // this.cart = null
    },
    saveCart: function() {
      const parsed = JSON.stringify(this.cart);
      localStorage.setItem("cart", parsed);
    }
  }
};
vue.filter("formatNumber", function(value) {
  return numeral(value).format("0,0");
});
</script>


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
</style>
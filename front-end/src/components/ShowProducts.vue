<template>
<div>
  <ul v-if="products && products.length">
    <b-container>
      <b-row>
        <div v-for="product in products" :key="product">
          <v-flex xs6 sm6 offset-sm3 style="text-align:center; margin:auto !important;">
            <v-card>
              <ProductImage :id="product.productId"/>
              <v-card-title primary-title>
              <div>
                <h2 class="headline mb-0" >{{product.productName}}</h2>
                <h2 class="headline mb-0" color="#F5580C">฿{{product.price | formatNumber}}</h2>
              </div>
            </v-card-title>

            <v-card-actions>
              <v-btn @click="addProductInCart(product)" color="#F5580C">ใส่รถเข็น</v-btn>
            </v-card-actions>
            </v-card>
          </v-flex>
        </div>
      </ul>
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
  methods:{
        addProductInCart: function (product){
            let localCart = localStorage.getItem('cart')

            if(localCart === null) {
              this.cart = []
            } else {
              this.cart = JSON.parse(localCart)
            }

            let duplicateProductInCart = this.cart.find((eachItemInCart) => {
                return product.productId === eachItemInCart.productId
            })
            if(duplicateProductInCart !== undefined) {
                duplicateProductInCart.quantity += 1
                // this.cart = cart
            }else {
                product.quantity = 1
                this.cart.push(product)
            }
            this.saveCart();
            // this.cart = null
        },
        saveCart: function(){
            const parsed = JSON.stringify(this.cart);
            localStorage.setItem('cart', parsed);
        }
  }
};
vue.filter("formatNumber", function(value) {
  return numeral(value).format("0,0");
});
</script>


<style scoped>
</style>
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


<style scoped>
</style>
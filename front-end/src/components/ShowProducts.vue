<template>
    <div class="pb-5">
      <ul v-if="products && products.length">
        <div v-for="product in products" :key="product">
      <v-flex xs6 sm6 offset-sm3 style="text-align:center; margin:auto !important;">
      <v-card>
        <v-img
          src=""
          aspect-ratio="1"
        ></v-img>

        <v-card-title primary-title>
          <div>
            <h2 class="headline mb-0">{{product.productName}}</h2>
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
    <div class="pb-4"></div>
  </div>
</template>

<script>
import axios from "axios"
import numeral from "numeral"
import vue from "vue"
import { mapGetters, mapMutations } from 'vuex'

export default {
  name: "ShowProducts",
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
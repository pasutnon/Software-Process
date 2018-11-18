<template>
    <div>
        <img alt="Vue logo" src="../assets/logo.png"/>
        <li v-for="product in products" :key="product">
         {{ product.productName }},
         {{ product.skuNumber }},
         {{ product.price }},
         {{ product.stockQuantity }}
        </li>

    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "ShowProducts",
  data() {
    return {
      products: []
    };
  },

  created () {
    axios
      .get('https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products')
      .then(response => (this.products = response.data))
  }
};
</script>

<style scoped>

</style>
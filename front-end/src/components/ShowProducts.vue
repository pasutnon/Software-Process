<template>
    <div>
        <img alt="Vue logo" src="../assets/logo.png" width="50%"/>
         <ul v-if="products && products.length">
        <li v-for="product in products" :key="product">
         <p><strong>ProductName : {{product.productName}}</strong></p>
         <p>SKU Number : {{product.skuNumber}}</p>
         <p>Product Detail : {{product.productDetail}}</p>
         <p>Stock Quantity : {{product.stockQuantity}}</p>
          <button><img src="../assets/Cart-Orange.svg" height="47"/></button>
        </li>

  </ul>
    </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ShowProducts",
  data() {
    return {
      products: []
    };
  },

  created() {
    axios
      .get('https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products')
      .then(response => (this.products = response.data));
      
      
  }
};
</script>

<style scoped>
</style>
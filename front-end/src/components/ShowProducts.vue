<template>
    <div>
        <img alt="Vue logo" src="../assets/logo.png" width="50%"/>
         <ul v-if="products && products.length">
        <li v-for="product in products" :key="product">
         <p><strong>ProductName : {{product.productName}}</strong></p>
         <p>SKU Number : {{product.skuNumber}}</p>
         <p>Product Detail : {{product.productDetail}}</p>
         <p>Stock Quantity : {{product.stockQuantity}}</p>
          <button @click="addProductInCart(product)"><img src="../assets/Cart-Orange.svg" height="47"/></button>
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
      products: [],
      cart: []
    };
  },

  created() {
    axios
      .get('https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products')
      .then(response => (this.products = response.data));
  },
  methods:{
        addProductInCart: function (product){
            let jsonCart = localStorage.getItem('cart')
            if(!jsonCart) {
                this.saveCart()
                return
            }
            let cart = JSON.parse(jsonCart)
            let targetProduct = cart.find((cartProduct) => {
                return product.productId === cartProduct.productId
            })
            if(targetProduct) {
                targetProduct.quantity += 1
                this.cart = cart
            }else {
                product.quantity = 1
                this.cart.push(product)
            }
            this.saveCart();
        },
        saveCart: function(){
            const parsed = JSON.stringify(this.cart);
            localStorage.setItem('cart',parsed);
        }
  }
};
</script>

<style scoped>
</style>
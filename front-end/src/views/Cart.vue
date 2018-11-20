<template>
  <div>
    <h2>My cart</h2>
    <div v-for="(product , n) in cart" v-bind:key="product.ID">
        <p>
            <span>{{ n+1 }} {{ product.productName }} {{ product.price }} {{ product.quantity }}
                <v-btn @click="reduceProductInCart(product)">-</v-btn>
                <v-btn @click="addProductInToCart(product)">+</v-btn>
            </span>
            <v-btn @click="removeProductInCart(product)">remove</v-btn>
        </p>
        
    </div>
    <div>
        <span>
            <h2>Total Prices : {{ totalCartPrice }} Baht</h2>
            <h2>Total Products : {{ totalItemInCart }}</h2>
        </span>

    </div>
    </div>
</template>

<script>
import { mapMutations, mapGetters } from "vuex";

export default {
  // name: 'cart',
  data(){
    return {
    }        
  },
  computed:{
    ...mapGetters([
      'totalItemInCart',
      'totalCartPrice',
      'cart'
    ])
  },
  mounted(){
  },
  methods:{
    ...mapMutations([
      'addProductInToCart',
      'reduceProductInCart',
      'removeProductInCart',
    ])
  }
}
</script>



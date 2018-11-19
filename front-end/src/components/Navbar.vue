<template>
<nav>
  <v-bottom-nav
        :active.sync="menu"
        :value="true"
        absolute
        fixed app
        height="44px"
        color="#F4F4F4"
      >
        <v-btn value="/" color="#F5580C" flat to="/">
          <img src="../assets/Home-Orange.svg" height="40px"/>
        </v-btn>

        <v-btn value="/search" color="#F5580C" flat to="/search">
          <img src="../assets/Category-Orange.svg" height="40"/>
        </v-btn>
        
        <v-btn value="/cart" color="#F5580C" flat to="/cart" v-if="cart===0">
          <v-badge>
            <img src="../assets/Cart-Orange.svg" height="40"/>
          </v-badge>
        </v-btn>

        <v-btn value="/cart" color="#F5580C" flat to="/cart" v-else>
          <v-badge color="red">
            <span slot="badge">{{ totalItemInCart }}</span>
            <img src="../assets/Cart-Orange.svg" height="40"/>
          </v-badge>
        </v-btn>

        <v-btn value="/user" color="#F5580C" flat to="/user">
          <img src="../assets/User-Orange.svg" height="40"/>
        </v-btn>
  </v-bottom-nav>
</nav>
</template>

<script>
import { mapActions,mapGetters } from "vuex";
import { sumTotalItem } from '../utils/cart.js';

export default {
  data() {
    return {
      menu: ''
    };
  },
  computed:{
    ...mapGetters(['totalItemInCart']),
  },
  mounted() {
  },
  methods: {
    sumTotalItem,
  }
};
</script>

<style>
nav {
    position: fixed;
    bottom: 0;
    width: 100%;
    margin-bottom: 0 !important;
}
</style>
<template>
<nav>
  <v-bottom-nav
        :active.sync="menu"
        :value="true"
        absolute
        fixed app
      >
        <v-btn value="/" color="deep-orange darken-2" flat to="/">
          <img src="../assets/Home-Orange.svg" height="47"/>
        </v-btn>

        <v-btn value="/search" color="deep-orange darken-2" flat to="/search">
          <img src="../assets/Category-Orange.svg" height="47"/>
        </v-btn>

        <v-btn value="/cart" color="deep-orange darken-2" flat to="/cart">
        <v-badge color="red" v-if="cart===0">
          <img src="../assets/Cart-Orange.svg" height="47"/>
        </v-badge>
        <v-badge color="red" v-else>
          <span slot="badge">{{cart}}</span>
          <img src="../assets/Cart-Orange.svg" height="47"/>
        </v-badge>
        </v-btn>

        <v-btn value="/user" color="deep-orange darken-2" flat to="/user">
          <img src="../assets/User-Orange.svg" height="47"/>
        </v-btn>
  </v-bottom-nav>
</nav>
</template>

<script>
export default {
  data() {
    return {
      menu: '',
      cart: 2
    };
  },
  methods:{
    
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
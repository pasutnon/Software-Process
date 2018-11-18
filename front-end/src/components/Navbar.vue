<template>
<<<<<<< HEAD
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

      <v-btn value="/cart" color="#F5580C" flat to="/cart">
        <img src="../assets/Cart-Orange.svg" height="40"/>
      </v-btn>

      <v-btn value="/user" color="#F5580C" flat to="/user">
        <img src="../assets/User-Orange.svg" height="40"/>
      </v-btn>
</v-bottom-nav>
=======
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
>>>>>>> f9a7a74472e7286adb03066e800f2692145c54cd
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
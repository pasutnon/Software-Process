<template>
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
        <img src="../assets/Category-Orange.svg" height="40px"/>
      </v-btn>

      <v-btn value="/cart" color="#F5580C" flat to="/cart">
        <img src="../assets/Cart-Orange.svg" height="40px"/>
      </v-btn>

      <v-btn value="/user" color="#F5580C" flat to="/user">
        <img src="../assets/User-Orange.svg" height="40px"/>
      </v-btn>
</v-bottom-nav>
</template>

<script>
export default {
  data() {
    return {
      menu: ''
    };
  },
  methods:{
    
  }
};
</script>

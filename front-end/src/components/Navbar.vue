<template>
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
        <img src="../assets/Cart-Orange.svg" height="47"/>
      </v-btn>

      <v-btn value="/user" color="deep-orange darken-2" flat to="/user">
        <img src="../assets/User-Orange.svg" height="47"/>
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

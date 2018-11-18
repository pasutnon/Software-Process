<template>
<v-app>
      <Navbar></Navbar>
      <router-view></router-view>
</v-app>
</template>

<script>
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import ShowProducts from "./components/ShowProducts";

export default {
  name: "app",
  components: {
    ShowProducts,
    Navbar,
    Footer
  }
};
</script>
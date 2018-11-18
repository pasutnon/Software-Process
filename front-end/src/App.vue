<template>
<v-app>
<<<<<<< HEAD
    <div>
        <HomeHeader></HomeHeader>
    </div>
    <nav>
        <Navbar></Navbar>
    </nav>
    
        <router-view></router-view>
        <ShowProducts></ShowProducts>
=======
      <Navbar></Navbar>
      <router-view></router-view>
>>>>>>> f9a7a74472e7286adb03066e800f2692145c54cd
</v-app>
</template>

<script>
    import Navbar from './components/Navbar';
    import HomeHeader from './components/header/HomeHeader';

<<<<<<< HEAD
    export default {
        name: 'app',
        components: {
            HomeHeader,
            Navbar
        }
    }
</script>

<style>
nav {
  position: fixed;
  bottom: 0;
  width: 100%;
  margin-bottom: 0 !important;
}
</style>
=======
export default {
  name: "app",
  components: {
    ShowProducts,
    Navbar,
    Footer
  }
};
</script>
>>>>>>> f9a7a74472e7286adb03066e800f2692145c54cd

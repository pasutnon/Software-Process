<template>
<v-app>
    <div>
        <HomeHeader></HomeHeader>
    </div>
    <nav>
        <Navbar></Navbar>
    </nav>
    
        <router-view></router-view>
        <ShowProducts></ShowProducts>
</v-app>
</template>

<script>
    import Navbar from './components/Navbar';
    import HomeHeader from './components/header/HomeHeader';

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

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

    export default {
        name: 'app',
        components: {
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

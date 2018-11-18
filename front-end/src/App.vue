<template>
<v-app>
    <nav>
        <Navbar></Navbar>
    </nav>
        <router-view></router-view>
</v-app>
</template>

<script>
    import Navbar from './components/Navbar';
    import Footer from './components/Footer';
    import ShowProducts from './components/ShowProducts';

    export default {
        name: 'app',
        components: {
            ShowProducts,
            Navbar,
            Footer
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

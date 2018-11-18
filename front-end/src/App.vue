<template>
  <div id="app">
    <!-- <Navbar></Navbar>
    <ShowProducts></ShowProducts>

    <Footer></Footer> -->

    <router-view></router-view>
  </div>
</template>

<script>
    import Navbar from './components/Navbar';
    import Footer from './components/Footer';
    import ShowProducts from './components/ShowProducts';

    export default {
        name: 'app',
        components: {
        },
        data(){
            return {

            }        
        }
    }
</script>

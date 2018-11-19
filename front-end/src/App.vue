<template>
    <v-app>
        <Navbar v-show="getIsShowToolBar"></Navbar>
        <router-view></router-view>
    </v-app>
</template>

<script>
import Navbar from './components/Navbar';
import {mapGetters} from 'vuex'
    export default {
        name: 'app',
        components: {
            Navbar
        },
        computed: {
            ...mapGetters(['getIsShowToolBar'])
        },
        mounted() {
        },
        data() {
            return {
                test:false
            };
        }
    }
</script>

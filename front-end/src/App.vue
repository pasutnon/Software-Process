<template>
    <v-app>
        <Navbar v-show="getIsShowToolBar"></Navbar>
        <router-view></router-view>
    </v-app>
</template>

<script>
import Navbar from './components/Navbar';
import { mapGetters, mapMutations } from 'vuex'

export default {
  name: 'app',
  components: {
      Navbar
  },
  computed: {
    ...mapGetters(['getIsShowToolBar'])
  },
  mounted() {
    this.updateCartFromLocalStorage()
  },
  methods: {
    ...mapMutations(['updateCartFromLocalStorage'])
  },
  data() {
    return {
      test:false
    };
  }
}
</script>


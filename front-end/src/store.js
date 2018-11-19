import Vue from 'vue'
import Vuex from 'vuex'
import { Navbar } from './store/Navbar'
import { Cart } from './store/Cart'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    Navbar,
    Cart
  }
})

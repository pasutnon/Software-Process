import Vue from 'vue'
import Vuex from 'vuex'
import { Navbar } from './store/Navbar'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    Navbar
  }
})

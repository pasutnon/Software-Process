import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueSweetalert2 from 'vue-sweetalert2';

Vue.use(BootstrapVue);
Vue.config.productionTip = false
Vue.use(VueSweetalert2);

new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')

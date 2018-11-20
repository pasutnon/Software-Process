import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Payment from './views/Payment.vue'
import PaymentComplete from './views/PaymentComplete.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      component: function () {
        return import('./views/About.vue')
      }
    },
    {
      path: '/cart',
      name: 'cart',
      component: function () {
        return import('./views/Cart.vue')
      }
    },
    {
      path: '/user',
      name: 'user',
      component: function () {
        return import('./views/User.vue')
      }
    },
    {
      path: '/product/detail/:productID',
      name: 'productDetail',
      component: function () {
        return import('./views/ProductDetail')
      }
    },
    {
      path: '/ShowProducts',
      name: 'ShowProducts',
      component: function () {
        return import('./components/ShowProducts')
      }
    },
    {
      path: '/search',
      name: 'search',
      component: function () {
        return import('./views/Search.vue')
      }
    },
    {
      path: '/order/:orderId/payment',
      name: 'Payment',
      component: Payment
    },
    {
      path: '/shipmentform',
      name: 'ShipmentForm',
      component: function () { 
        return import('./views/ShipmentForm.vue')
      }
    },
    {
      path: '/order/:orderId/payment/complete',
      name: 'PaymentComplete',
      component: PaymentComplete
    },
    {
      path: '/orderDetail',
      name: 'OrderDetail',
      component: function () {
        return import('./views/OrderDetail.vue')
      }
    }
  ]
})

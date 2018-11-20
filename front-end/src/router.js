import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Payment from './views/Payment.vue'
import PaymentComplete from './views/PaymentComplete.vue'
import authMiddleware from './middlewares/auth'

Vue.use(Router)

const router = new Router({
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
      path: '/PaymentSuccess',
      name: 'PaymentSuccess',
      component: function () {
        return import('./views/PaymentSuccess.vue')
      }
    },
    {
      path: '/PaymentUnsuccess',
      name: 'PaymentUnsuccess',
      component: function () {
        return import('./views/PaymentUnsuccess.vue')
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
      path: '/order/:orderId/payment/omise/complete',
      name: 'PaymentComplete',
      component: PaymentComplete,
      meta: {
        middleware: [authMiddleware],
      },
    },
    {
      path: '/order/detail',
      name: 'OrderDetail',
      component: function () {
        return import('./views/OrderDetail.vue')
      },
      meta: {
        middleware: [authMiddleware],
      },
    },
    {
      path: '/shipmentform',
      name: 'shipmentform',
      component: function () {
        return import('./views/ShipmentForm.vue')
      },
      meta: {
        middleware: [authMiddleware],
      },
    }
  ]
})

// Creates a `nextMiddleware()` function which not only
// runs the default `next()` callback but also triggers
// the subsequent Middleware function.
function nextFactory(context, middleware, index) {
  const subsequentMiddleware = middleware[index];
  // If no subsequent Middleware exists,
  // the default `next()` callback is returned.
  if (!subsequentMiddleware) return context.next;

  return (...parameters) => {
    // Run the default Vue Router `next()` callback first.
    context.next(...parameters);
    // Then run the subsequent Middleware with a new
    // `nextMiddleware()` callback.
    const nextMiddleware = nextFactory(context, middleware, index + 1);
    subsequentMiddleware({ ...context, next: nextMiddleware });
  };
}

router.beforeEach((to, from, next) => {
  if (to.meta.middleware) {
    const middleware = Array.isArray(to.meta.middleware)
      ? to.meta.middleware
      : [to.meta.middleware];

    const context = {
      from,
      next,
      router,
      to,
    };
    const nextMiddleware = nextFactory(context, middleware, 1);

    return middleware[0]({ ...context, next: nextMiddleware });
  }

 return next();
});

export default router
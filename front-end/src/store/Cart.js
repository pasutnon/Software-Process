import cartUtils from '../utils/cart'

export const Cart = {
  state: {
    cart: []
  },
  actions: {
    
  },
  mutations: {
    updateCartFromLocalStorage: (state) => {
      const localCart = localStorage.getItem('cart')
      if (localCart !== null) {
        state.cart = JSON.parse(localCart)
      } else {
        state.cart = []
      }
    },
    addProductInToCart: (state, product) => {
      let matchProduct = state.cart.find((eachItemInCart) => {
        return product.productId === eachItemInCart.productId
      })
      if(matchProduct !== undefined) {
        matchProduct.quantity += 1
      } else {
        product.quantity = 1
        state.cart.push(product)
      }
      cartUtils.saveToLocalStorage(state.cart)
    },
    reduceProductInCart: (state, product) => {
      let matchProduct = state.cart.find((eachItemInCart) => {
        return product.productId === eachItemInCart.productId
      })
      if (matchProduct.quantity > 1) {
        matchProduct.quantity -= 1
      } else {
        state.cart.filter(item => item !== matchProduct)
      }
      cartUtils.saveToLocalStorage(state.cart)
    },
    removeProductInCart: (state, product) => {
      const matchIndex = state.cart.indexOf(product)
      state.cart.splice(matchIndex, 1)
      cartUtils.saveToLocalStorage(state.cart)
    }
  },
  getters: {
    cart: (state) => state.cart,
    totalItemInCart: (state) => cartUtils.sumTotalItem(state.cart),
    totalCartPrice: (state) => cartUtils.sumPrice(state.cart)
  }
}
  
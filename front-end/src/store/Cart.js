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
      const cart = cartUtils.renewCart(state.cart)
      let matchProduct = cart.find((eachItemInCart) => {
        return product.productId === eachItemInCart.productId
      })
      if(matchProduct !== undefined) {
        matchProduct.quantity += 1
      } else {
        product.quantity = 1
        cart.push(product)
      }
      state.cart = cart
      cartUtils.saveToLocalStorage(state.cart)
    },
    reduceProductInCart: (state, product) => {
      const cart = cartUtils.renewCart(state.cart)
      let matchProduct = cart.find((eachItemInCart) => {
        return product.productId === eachItemInCart.productId
      })
      if (matchProduct.quantity > 1) {
        matchProduct.quantity -= 1
      } else {
        const matchIndex = cart.indexOf(product)
        cart.splice(matchIndex, 1)
      }
      state.cart = cart
      cartUtils.saveToLocalStorage(state.cart)
    },
    removeProductInCart: (state, product) => {
      const cart = cartUtils.renewCart(state.cart)
      const matchIndex = state.cart.indexOf(product)
      cart.splice(matchIndex, 1)
      state.cart = cart
      cartUtils.saveToLocalStorage(state.cart)
    },
    resetCart: (state) => {
      state.cart = []
    }
  },
  getters: {
    cart: (state) => state.cart,
    totalItemInCart: (state) => cartUtils.sumTotalItem(state.cart),
    totalCartPrice: (state) => cartUtils.sumPrice(state.cart)
  }
}
  
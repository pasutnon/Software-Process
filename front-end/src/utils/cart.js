export default {
  saveToLocalStorage: (cart) => {
    localStorage.setItem('cart', JSON.stringify(cart))
  },
  sumTotalItem: (cart) => cart.reduce((sum, product) => sum + product.quantity, 0),
  sumPrice: (cart) => {
    return cart.reduce((sum, product) => sum + (product.price * product.quantity), 0)
  },
  renewCart: (cart) => JSON.parse(JSON.stringify(cart))
}
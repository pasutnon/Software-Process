const { Omise } = window
const PUBLIC_KEY = process.env.VUE_APP_PUB_OMISE

Omise.setPublicKey(PUBLIC_KEY)

export default {
  createCardToken: (cardInfo) => new Promise((resolve, reject) => {
    Omise.createToken('card', cardInfo, (statusCode, response) => {
      if (statusCode == 200) {
        resolve({statusCode, response})
      } else {
        reject({statusCode, response})
      }
    })
  })
}
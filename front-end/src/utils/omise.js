const { Omise } = window
const PUBLIC_KEY = 'pkey_test_5dz45mwox7px53uazab'

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
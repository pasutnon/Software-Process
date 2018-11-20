<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="container shadow-sm rounded bg-white mt-4">
      <div class="text-center">
        <h4>ชำระเงิน</h4>
        <div>
          <b-form>
            <div class="row">
              <div class="col-12">
                <b-form-group
                  label="ชื่อบนบัตร"
                  label-for="name-holder"
                >
                  <b-form-input
                    id="name-holder"
                    type="text"
                    v-model="form.cardNameHolder"
                    required
                  />
                </b-form-group>
              </div>
              <div class="col-12">
                <b-form-group
                  label="หมายเลขบัตรเครดิต"
                  label-for="credit-number"
                >
                  <b-form-input
                    id="credit-number"
                    type="number"
                    v-model="form.creditNumber"
                    required
                    placeholder="XXXX XXXX XXXX XXXX"
                  />
                </b-form-group>
              </div>
            </div>
            <div class="row">
              <div class="col-6">
                <b-form-group
                  label="หมายเลข CVV"
                  label-for="cvv-number"
                >
                  <b-form-input
                    id="cvv-number"
                    type="number"
                    v-model="form.cvvNumber"
                    required
                    placeholder="XXX"
                  />
                </b-form-group>
              </div>
              <div class="col-6">
                <b-form-group
                  label="วันหมดอายุ"
                  label-for="exprie-date"
                >
                  <b-form-input
                    id="exprie-date"
                    type="text"
                    v-model="form.expDate"
                    required
                    placeholder="mm/yy"
                  />
                </b-form-group>
              </div>
            </div>
            <div class="w-100 text-center" v-if="isSubmitted">
              <div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
            </div>
            <div class="row pt-3" v-else>
              <div class="col-6 text-right">
                <b-button variant="danger">ยกเลิก</b-button>
              </div>
              <div class="col-6 text-left">
                <b-button variant="success" :disabled="isSubmitted" v-on:click="processPayment">ดำเนินการต่อ</b-button>
              </div>
            </div>
          </b-form>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import HomeHeader from '../components/header/HomeHeader.vue'
  import OmiseUtils from '../utils/omise.js'
  import axios from '../utils/axios.js'
  import qs from 'qs'

  export default {
    data() {
      return {
        form: {
          creditNumber: '4242424242424242',
          expDate: '02/2020',
          cvvNumber: '111',
          cardNameHolder: 'Dogo',
        },
        isSubmitted: false
      }
    },
    components: {
      HomeHeader
    },
    methods: {
      processPayment: async function (element) {
        element.target.innerHTML = "กำลังดำเนินการ"
        this.isSubmitted = true
        const expMonth = this.form.expDate.substring(0, 2)
        const expYear = this.form.expDate.substring(3, 7)
        const cardInfo = {
          name: this.form.cardNameHolder,
          number: this.form.creditNumber,
          expiration_month: expMonth,
          expiration_year: expYear,
          security_code: this.form.cvvNumber,
        }
        const tokenResponse = await OmiseUtils.createCardToken(cardInfo)
        const cardToken = tokenResponse.response.id
        const chargeFormData = new FormData()
        chargeFormData.append('token', cardToken)
        try {
          const chargeResponse = await axios.post(
            `/payments/order/${this.$route.params.orderId}/omise`,
            chargeFormData,
            {
              headers: {
                'Content-Type': 'multipart/form-data'
              }
            }
          )
          window.location = chargeResponse.data.authorizedUrl
        } catch (err) {
          console.err(err)
        }
      }
    }
  }
</script>

<style>
.lds-ellipsis {
  display: inline-block;
  position: relative;
  width: 64px;
  height: 64px;
}
.lds-ellipsis div {
  position: absolute;
  top: 27px;
  width: 11px;
  height: 11px;
  border-radius: 50%;
  background: #f5580c;
  animation-timing-function: cubic-bezier(0, 1, 1, 0);
}
.lds-ellipsis div:nth-child(1) {
  left: 6px;
  animation: lds-ellipsis1 0.6s infinite;
}
.lds-ellipsis div:nth-child(2) {
  left: 6px;
  animation: lds-ellipsis2 0.6s infinite;
}
.lds-ellipsis div:nth-child(3) {
  left: 26px;
  animation: lds-ellipsis2 0.6s infinite;
}
.lds-ellipsis div:nth-child(4) {
  left: 45px;
  animation: lds-ellipsis3 0.6s infinite;
}
@keyframes lds-ellipsis1 {
  0% {
    transform: scale(0);
  }
  100% {
    transform: scale(1);
  }
}
@keyframes lds-ellipsis3 {
  0% {
    transform: scale(1);
  }
  100% {
    transform: scale(0);
  }
}
@keyframes lds-ellipsis2 {
  0% {
    transform: translate(0, 0);
  }
  100% {
    transform: translate(19px, 0);
  }
}
</style>

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
            <div class="row pt-3">
              <div class="col-6 text-right">
                <b-button variant="danger">ยกเลิก</b-button>
              </div>
              <div class="col-6 text-left">
                <b-button variant="success" v-on:click="processPayment">ดำเนินการต่อ</b-button>
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
        }
      }
    },
    components: {
      HomeHeader
    },
    methods: {
      processPayment: async function () {
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
            `/order/${this.$route.params.orderId}/payment`,
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
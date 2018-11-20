<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="container shadow-sm rounded bg-white mt-4">
      <div v-if="isWait" class="text-center">
        <div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
      </div>
      <div v-else class="text-center">
        <div v-if="isComplete">
          <p style="color:#F5580C; text-align:center; font-size:30px;">"การจ่ายเงินสำเร็จ"</p>
          <p style="color:#F5580C; text-align:center; font-size:20px;">เลขบิล : {{ $route.params.orderId }}</p>
        </div>
        <div v-else>
          <p style="color:#F5580C;  text-align:center; font-size:30px;">"การจ่ายเงินไม่สำเร็จ"</p>
        </div>
      </div>
    </div>
    <div @click="confirm()" class="fixed-nav btn-block button-add p-3 text-center" style="background-color: #f5580c; color: white; cursor: pointer;"> 
        ยืนยัน
    </div>
  </div>
</template>

<script>
import HomeHeader from '../components/header/HomeHeader.vue'
import axios from '../utils/axios.js'
import { mapActions,mapGetters, mapMutations } from "vuex";

export default {
  data() {
    return {
      isWait: true,
      isComplete: false,
    }
  },
  components: {
    HomeHeader,
  },
  async mounted() {
    this.setIsShowToolBar(false)
    try {
      const paymentResponse = await axios.get(`/payments/order/${this.$route.params.orderId}/omise`)
      this.isComplete = paymentResponse.data.status === "paid"
      this.isWait = false
      this.resetCart()
    } catch (err) {
      this.isComplete = false   
      this.isWait = false
      console.log(err)   
    }
  },
  methods: {
    ...mapMutations(['resetCart']),
    ...mapActions(['setIsShowToolBar']),
    confirm: function () {
      this.$router.push({ name: 'home' })
      this.resetCart()
    }
  }
}
</script>

<style>
.fixed-nav {
  position: fixed;
  bottom: 0;
  width: 100%;
  margin-bottom: 0 !important;
  z-index: 100;
}
.lds-ellipsis {
  display: inline-block;
  position: relative;
  width: 64px;
  height: 10px;
}
.lds-ellipsis div {
  position: absolute;
  top: 0px;
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

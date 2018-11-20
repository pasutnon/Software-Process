<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="container shadow-sm rounded bg-white mt-4">
      <div v-if="isWait">กำลังดึงข้อมูล</div>
      <div v-else>
        <div v-if="isComplete">ชำระเสร็จสิ้น</div>
        <div v-else>เกิดข้อผิดพลาด</div>
      </div>
    </div>
  </div>
</template>

<script>
import HomeHeader from '../components/header/HomeHeader.vue'
import axios from '../utils/axios.js'

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
    try {
      const paymentResponse = await axios.get(`/payments/order/${this.$route.params.orderId}/omise`)
      this.isComplete = paymentResponse.data.status === "paid"
      this.isWait = false
    } catch {
      this.isComplete = false   
      this.isWait = false   
    }
  },
  methods: {
  }
}
</script>

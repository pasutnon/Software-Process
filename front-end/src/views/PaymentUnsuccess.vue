<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="container shadow-sm rounded bg-white mt-4">
      <div v-if="isWait">กำลังดึงข้อมูล</div>
      <div v-else>
        <div v-if="isComplete"><p style="color:#F5580C;  text-align:center; font-size:20px;">ชำระล้มเหลว</p></div>
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
      isWait: false,
      isComplete: true,
    }
  },
  components: {
    HomeHeader,
  },
}
</script>

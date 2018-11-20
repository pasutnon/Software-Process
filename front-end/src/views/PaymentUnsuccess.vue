<template>
  <div>
    <GenericHeader header="การดำเนินการจ่ายเงิน"></GenericHeader>
    <div class="container shadow-sm rounded bg-white mt-4">
      <div v-if="isWait">กำลังดึงข้อมูล</div>
      <div v-else>
        <div v-if="isComplete"><p style="color:#F5580C;  text-align:center; font-size:20px;">"การจ่ายเงินไม่สำเร็จ"</p></div>
        <div v-else>เกิดข้อผิดพลาด</div>
      </div>
    </div>
    <router-link to="/">
      <button class="btn-block button-add"> 
          ตกลง
      </button>
    </router-link>
  </div>
</template>

<script>
import GenericHeader from '../components/header/GenericHeader.vue'
import { mapActions } from 'vuex'
import axios from '../utils/axios.js'

export default {
  data() {
    return {
      isWait: false,
      isComplete: true,
    }
  },
  components: {
    GenericHeader,
  }, mounted () {
    this.setIsShowToolBar(false)
  },
  methods:{
    ...mapActions(['setIsShowToolBar']),
  }
}
</script>
<style>
.btn-block{
  position: fixed;
  bottom: 0;
  margin-bottom: 0 !important;
  height: 40px;
}
.button-add {
    background-color: #F5580C; 
    color: white;
}
.button-add:hover {
    background-color: white;
    color: #F5580C;
}
</style>

<template>
<div style="text-align:center">
  <p></p>
  <v-text>สินค้าทั้งหมด</v-text>
  <p></p>
<!-- Card layout -->
   <v-layout>
    <v-flex xs6 sm6 offset-sm3 style="text-align:center; margin:auto !important;">
      <v-card>
        <v-img
          src="../../นมจืด ดัชมิลล์.png"
          aspect-ratio="1"
        ></v-img>

        <v-card-title primary-title>
          <div>
            <h2 class="headline mb-0">นมจืด ดัชมิลล์ 180 มล.</h2>
            <h2 class="headline mb-0" color="#F5580C">฿32</h2>
          </div>
        </v-card-title>

        <v-card-actions>
          <v-btn color="#F5580C">ใส่รถเข็น</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
  <!-- End Card layout -->
</div>
</template>
<script>
import HomeHeader from './components/header/HomeHeader';

export default {
  components: {
      HomeHeader
  }
};
</script>

<template>
<div style="text-align:center">
  <div>
        <HomeHeader></HomeHeader>
  </div>
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
  <ShowProducts></ShowProducts>
</div>
</template>

<script>
import HomeHeader from '../components/header/HomeHeader';
import ShowProducts from '../components/ShowProducts';

export default {
  components: {
    HomeHeader,
    ShowProducts
  },
  data() {
      return {
        card_text:
          "Lorem ipsum dolor sit amet, brute iriure accusata ne mea. Eos suavitate referrentur ad, te duo agam libris qualisque, utroque quaestio accommodare no qui. Et percipit laboramus usu, no invidunt verterem nominati mel. Dolorem ancillae an mei, ut putant invenire splendide mel, ea nec propriae adipisci. Ignota salutandi accusamus in sed, et per malis fuisset, qui id ludus appareat."
          ,
      };
    }
};
</script>

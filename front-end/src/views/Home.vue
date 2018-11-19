<template>
<v-home style="text-align:center !important; magin:auto !important;">
  <div>
        <HomeHeader></HomeHeader>
  </div>
  <p></p>
  <v-text>สินค้าทั้งหมด</v-text>
  <p></p>
  <ShowProducts> </ShowProducts>
</v-home>
</template>

<script>
import HomeHeader from '../components/header/HomeHeader';
import ShowProducts from '../components/ShowProducts';

export default {
    components: {
      HomeHeader,
      ShowProducts
    }
  }
</script>


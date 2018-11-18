<template>
  <div>
    <ProductDetailHeader link="/user"></ProductDetailHeader>
      <b-container>
        <div class="text-xs-center">
          <h5>รายละเอียดสินค้า</h5>
          <img src="../assets/นมจืด ดัชมิลล์.png" width="200" height="200"/>
        </div>
        <b-row>
          <b-col cols="8">test</b-col>
          <b-col cols="4">test</b-col>
        </b-row>
        <p>detail</p>
      </b-container>
      <button class="btn-block button-add">
        เพิ่มสินค้าลงตระกร้า
      </button>
  </div>
</template>
<script>
import ProductDetailHeader from '../components/header/ProductDetailHeader';
import { mapActions } from 'vuex'
  export default {
    components: {
      ProductDetailHeader
    },
    data () {
        return {
            productID: '',
            product:''
        }
    },
    mounted () {
    this.setIsShowToolBar(false)
    this.productID =
      this.$route.params.productID === undefined
        ? 0
        : this.$route.params.productID
    },
    methods:{
      ...mapActions(['setIsShowToolBar'])
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


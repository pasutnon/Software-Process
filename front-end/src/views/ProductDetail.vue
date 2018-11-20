<template>
  <div>
    <div class="hearder">
      <ProductDetailHeader></ProductDetailHeader>
      <v-progress-linear class="hr-1" :indeterminate="true" v-if="loading1 || loading2"
      color="#F5580C" height="3"></v-progress-linear>
      <v-progress-linear class="hr-1" value=100 v-else
      color="#F5580C" height="3"></v-progress-linear>
    </div>
    <br/><br/>
      <b-container>
        <b-row class="text-xs-center">
          <b-col cols="12">
            <h4>รายละเอียดสินค้า</h4>
          </b-col>
          <b-col cols="12">
            <div class="box">
              <img :src="`${productImage.path}`" width="auto" height="250"/>
            </div>
          </b-col>
        </b-row>
        <br/>
        <b-row>
          <b-col cols="8" class="headline">{{product.productName}}</b-col>
          <b-col cols="4" class="subheading text-bath">฿ {{product.price | formatNumber}}</b-col>
        </b-row>
        <br/>
        <p class="body-2">{{product.productDetail}}</p>
      </b-container>
      <button class="btn-block button-add" @click="addCart(product)"> 
        เพิ่มสินค้าลงตระกร้า
      </button>
  </div>
</template>
<script>
import ProductDetailHeader from '../components/header/ProductDetailHeader';
import { mapActions,mapMutations } from 'vuex'
import axios from "axios"
  export default {
    components: {
      ProductDetailHeader
    },
    data () {
        return {
            productID: '',
            product:'',
            productImage:'',
            loading1:true,
            loading2:true
        }
    },
    mounted () {
    this.setIsShowToolBar(false)
    this.productID =
      this.$route.params.productID === undefined
        ? 0
        : this.$route.params.productID
    this.getProductDetail()
    this.getProductImage()
    },
    methods:{
      ...mapActions(['setIsShowToolBar']),
      ...mapMutations({ addProductInCart: 'addProductInToCart' }),
      async getProductDetail(){
        const { data } = await axios.get(process.env.VUE_APP_DOGE_COMMERCE_SERVICE_URL+"/products/"+this.productID);
        this.product = data;
        this.loading1 = false;
      },
      async getProductImage(){
        const { data } = await axios.get(process.env.VUE_APP_DOGE_COMMERCE_SERVICE_URL+"/products/"+this.productID+"/images");
        this.productImage = data;
        this.loading2 = false;
      },
      addCart(product){
        this.addProductInCart(product)
        this.$swal('Add Product In Cart', 'Add '+product.productName , 'success');
      }
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
.text-bath{
  color:#F5580C
}
.box{
  background-color: white;
}
.hr-1 {
  padding: 0px;
  margin: 0px;
}
.hearder{
  position: fixed;
    top: 0;
    width: 100%;
    margin-top: 0 !important;
    z-index: 100;
}
</style>


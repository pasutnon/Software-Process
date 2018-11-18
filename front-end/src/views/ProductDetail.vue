<template>
<div>
<ProductDetailHeader link="eiei"></ProductDetailHeader>
<h1>Product Detail {{productID}}</h1>
</div>
</template>
<script>
import ProductDetailHeader from '../components/header/ProductDetailHeader';
  export default {
    components: {
      ProductDetailHeader
    },
    data () {
        return {
            productID: '',
        }
    },
    mounted () {
    this.productID =
      this.$route.params.productID === undefined
        ? 0
        : this.$route.params.productID
    }
  }
</script>

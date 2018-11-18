<template>
<div>
<h1>Product Detail {{productID}}</h1>
</div>
</template>
<script>
  export default {
    components: {
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

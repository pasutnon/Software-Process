<template>
        <img
          :src="path"
        width="70%"/>      

</template>

<script>
import axios from "axios"
import numeral from "numeral"

export default {
  name: "ProductImage",
  props:{
    id:String
  },
  data() {
    return {
      path: ""
    };
  },

  created() {
    axios
    .get("https://doge-commerce-back-end-grumpy-gecko.mybluemix.net/products/"+this.id+"/images")
    .then(response => {
        console.log(response.data)
        return this.path = response.data.path
    });
  },
  methods:{}
}
</script>


<style scoped>
</style>
<template>
        <img
          :src="path"
        width="70%"/>      

</template>

<script>
import axios from "../utils/axios.js"

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
    .get("/products/"+this.id+"/images")
    .then(response => {
        console.log(response.data)
        return this.path = response.data.path
    });
  },
  methods:{}
}
</script>
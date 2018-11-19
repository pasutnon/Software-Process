<template>
<v-home style="text-align:center !important; magin:auto !important;">
  <div>
        <HomeHeader></HomeHeader>
        <br>
          <div class="searchform">
    <h4>Find By Name</h4>
    <div class="form-group">
      <input type="text" class="form-control" id="name" required v-model="name" name="name">
    </div>
 
    <div class="btn-group">
      <button v-on:click="searchProduct" class="btn btn-success">Search</button>
    </div>
 
    <ul class="search-result">
      <li v-for="(product, index) in products" :key="index">
        <h6>{{product.productName}}</h6>
      </li>
    </ul>
  </div>
        
  </div>
</v-home>
</template>

<script>
import HomeHeader from "../components/header/HomeHeader";

export default {
  components: {
    HomeHeader
  }
};
</script>

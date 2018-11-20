<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-btn icon @click="$router.go(-1)">
            <v-icon color="#F5580C">arrow_back</v-icon>
        </v-btn>
        <v-spacer></v-spacer>
        <h4 class="text-nav">รายละเอียดสั่งซื้อสินค้า</h4>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon></v-icon>
        </v-btn>
    </v-toolbar>
    <v-progress-linear class="hr-1" value=100
    color="#F5580C" height="3"></v-progress-linear>
</div>
</template>
<script>
    export default {
        name: "OrderDetailHeader",
        data() {
            return {
            }
        }
    }
</script>
<style>
.text-nav{
    color: orangered;
}
</style>

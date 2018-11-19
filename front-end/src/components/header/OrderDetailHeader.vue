<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-btn icon :to="`${link}`" @click="setIsShowToolBar(true)">
            <v-icon color="#F5580C">arrow_back</v-icon>
        </v-btn>
        <v-spacer></v-spacer>
        <h4 class="text-nav">รายละเอียดสั่งซื้อสินค้า</h4>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon></v-icon>
        </v-btn>
    </v-toolbar>
</div>
</template>
<script>
import { mapActions } from 'vuex'
    export default {
        name: "OrderDetailHeader",
        props:{
            link:String
        },
        data() {
            return {
            }
        },
        methods:{
            ...mapActions(['setIsShowToolBar']),
        }
    }
</script>
<style>
.text-nav{
    color: orangered;
}
</style>

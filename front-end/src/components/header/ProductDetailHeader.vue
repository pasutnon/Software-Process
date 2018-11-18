<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-btn icon :to="`${link}`">
            <v-icon color="#F5580C">arrow_back</v-icon>
        </v-btn>
        <v-spacer></v-spacer>
        <img src="../../assets/logo.png" width="100"/>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon></v-icon>
        </v-btn>
    </v-toolbar>
    <v-toolbar id="orange-line" color="#F5580C" height="3.75px"></v-toolbar>
</div>
</template>
<script>
    export default {
        name: "ProductDetailHeader",
        props:{
            link:String
        },
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

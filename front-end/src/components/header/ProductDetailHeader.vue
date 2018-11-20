<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-btn icon  @click="$router.go(-1)">
            <v-icon color="#F5580C">arrow_back</v-icon>
        </v-btn>
        <v-spacer></v-spacer>
        <img src="../../assets/logo.png" width="100"/>
        <v-spacer></v-spacer>
        <v-btn icon>
            <v-icon></v-icon>
        </v-btn>
    </v-toolbar>
</div>
</template>
<script>
    export default {
        name: "ProductDetailHeader",
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

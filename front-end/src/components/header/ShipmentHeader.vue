<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-spacer></v-spacer>
        <h4 class="text-nav">ที่อยู่ของคุณ</h4>
        <v-spacer></v-spacer>
    </v-toolbar>
    <v-progress-linear class="hr-1" value=100
    color="#F5580C" height="3"></v-progress-linear>
</div>
</template>
<script>
    export default {
        name: "ShipmentHeader",
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

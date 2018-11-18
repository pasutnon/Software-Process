<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-spacer></v-spacer>
        <h4 class="text-nav">บัญชีของคุณ</h4>
        <v-spacer></v-spacer>
    </v-toolbar>
    <v-toolbar id="orange-line" color="#F5580C" height="3.75px"></v-toolbar>
</div>
</template>
<script>
    export default {
        name: "AccoutHeader",
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

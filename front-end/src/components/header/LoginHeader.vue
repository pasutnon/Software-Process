<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-spacer></v-spacer>
        <router-link to="">มีบัญชีแล้วหรือยัง ?&nbsp;</router-link>
        <v-btn color="deep-orange darken-2" class="button-r" dark>ลงทะเบียน</v-btn>
        <v-spacer></v-spacer>
    </v-toolbar>
    <v-progress-linear class="hr-1" value=100
    color="#F5580C" height="3"></v-progress-linear>
</div>
</template>
<script>
    export default {
        name: "LoginHeader",
        data() {
            return {
            }
        }
    }
</script>
<style>
.button-r{
  width: 20%;
}
</style>

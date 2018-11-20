<template>
<div>
    <v-toolbar color="white" height="50.00px" card>
        <v-spacer></v-spacer>
        <h4 class="text-nav">{{ header }}</h4>
        <v-spacer></v-spacer>
    </v-toolbar>
    <v-progress-linear class="hr-1" value=100
    color="#F5580C" height="3"></v-progress-linear>
</div>
</template>
<script>
export default {
    name: "GenericHeader",
    data() {
        return {
        }
    },
    props: ['header']
}
</script>
<style>
.text-nav{
    color: orangered;
}
</style>

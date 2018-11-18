<template>
    <div>
        <v-toolbar color="white" height="50.00px">
            <div style="text-align:center; margin:auto !important;">
                <img  v-bind:src="`${picture1}`" width="100"/>
            </div>
            <div>

            </div>
        </v-toolbar>
        <v-toolbar id="orange-line" color="#F5580C" height="3.75px">
        </v-toolbar>
    </div>
</template>

<script>
    export default {
        name: "HomeHeder",
        data() {
            return {
                picture1: '../assets/logo.png'
            }
        }
    }
</script>
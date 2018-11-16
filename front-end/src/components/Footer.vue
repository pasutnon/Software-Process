<template>
    <v-footer class="pa-3">
        <v-spacer></v-spacer>
        <h1>{{name}}</h1>
        <div>&copy; {{ new Date().getFullYear() }}</div>
    </v-footer>
</template>

<script>
    export default {
        name: "Footer",
        data() {
            return {
                name: 'Footer'
            }
        }
    }
</script>

<style scoped>


</style>
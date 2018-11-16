<template>
    <div>
        <h2>{{name}}</h2>
        <img alt="Vue logo" src="../assets/logo.png"/>
        <p>{{productName}} {{productPrice}}</p>

    </div>
</template>

<script>
    export default {
        name: "ShowProducts" ,
        data() {
            return {
                name: 'Productss',
                productName: 'AAA',
                productPrice: '900'
            }
        }
    }
</script>

<style scoped>

</style>
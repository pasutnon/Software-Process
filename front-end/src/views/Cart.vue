<template>
  <div>
    <h2>My cart</h2>
    <div v-for="(product , n) in cart">
        <p>
            <span>{{ n+1 }} {{ product.productName }} {{ product.price }} {{ product.quantity }}
                <v-btn @click="product.quantity += 1">+</v-btn>
            </span>
            <v-btn @click="removeProduct(n)">remove</v-btn>

            
            
        </p>
        <div>
            <span>
                <h2>Total Prices : {{ totalPrices }} Baht</h2>
                <h2>Total Products : {{ totalProducts }}</h2>

            </span>

        </div>
    </div>
    </div>
</template>

<script>

    export default {
        name: 'cart',
        data(){
            return {
                cart:[{
                    ID:59130500063
                    ,productName:"name"
                    ,price:500
                    ,quantity:1}]
            }        
        },
        computed:{
        totalProducts(){
            return this.cart.reduce((sum,product)=>{
                return sum + product.quantity
            } , 0)
        },
        totalPrices(){
            return this.cart.reduce((sum,product)=>{
                return sum + product.price
            } , 0)
        }
    },
    mounted(){
        if(localStorage.getItem('cart')){
            try {
                this.cart = JSON.parse(localStorage.getItem('cart'));
            } catch (ex) {
                localStorage.removeItem('cart');
            }
        }
    },
    method:{
        addProductInCart(product){
            let cart = JSON.parse(localStorage.getItem('cart'))
            let targetProduct = cart.filter((cartProduct) => {
                return product.ID === cartProduct.ID
            })
            if(targetProduct) {
                targetProduct.quantity += 1
            }else {
                product.quantity = 1
                this.cart.push(product)
            }
            this.saveCart();
        },
        removeProduct(product){
            this.cart.splice(product,1);
            this.saveCart();
        },
        saveCart(){
            const parsed = JSON.stringify(this.cart);
            localStorage.setItem('cart',parsed);
        }
    }
    }

</script>



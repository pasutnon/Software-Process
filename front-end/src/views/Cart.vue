<template>
  <div>
    <h2>My cart</h2>
    <div v-for="(product , n) in cart" v-bind:key="product.ID">
        <p>
            <span>{{ n+1 }} {{ product.productName }} {{ product.price }} {{ product.quantity }}
                <v-btn @click="addQuantity(product)">+</v-btn>
            </span>
            <v-btn @click="removeProduct(n)">remove</v-btn>
            

            
            
        </p>
        
    </div>
    <div>
        <span>
            <h2>Total Prices : {{ totalPrices }} Baht</h2>
            <h2>Total Products : {{ totalProducts }}</h2>

        </span>

    </div>
    </div>
</template>

<script>

    export default {
        name: 'cart',
        data(){
            return {
                cart:[{
                    }]
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
                return sum + (product.price*product.quantity)
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
    methods:{
        addProductInCart: function (product){
            product.quantity = 1;
            this.cart.push(product);            
            this.saveCart();
        },
        removeProduct: function (product){
            this.cart.splice(product,1);
            this.saveCart();
        },
        saveCart: function (){
            const parsed = JSON.stringify(this.cart);
            localStorage.setItem('cart',parsed);
        },
        addQuantity: function (product){
            product.quantity +=1;
            this.saveCart();
        },
        
    }
    }

</script>



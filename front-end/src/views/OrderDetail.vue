<template>
<div>
    <div class="hearder">
        <OrderDetailHeader></OrderDetailHeader>
    </div>
    <br/><br/>
    <b-container>
        <v-list v-for="(product) in cart" v-bind:key="product.ID">
            <b-row>
                <b-col cols="6" class="text-xs-center">
                    <ProductImage :id="product.productId"/>
                </b-col>
                <b-col cols="6">
                    <div class="mb-3"></div>
                    <p>{{product.productName}}</p>
                    <p style="color:#F5580C;">{{product.quantity | formatNumber}} x ฿ {{product.price | formatNumber}}</p>
                </b-col>
            </b-row>
        </v-list>
        <b-list-group class="mt-3">
            <b-list-group-item>
                รวมราคาสินค้า <v-text color="#F5580C" style="float: right;">฿ {{totalCartPrice | formatNumber}}</v-text>
            </b-list-group-item>
            <b-list-group-item>
                ค่าจัดส่ง <v-text color="#F5580C" style="float: right;">฿ {{DeliveryPrice | formatNumber}}</v-text>
            </b-list-group-item>
            <div class="mb-3"></div>
            <b-list-group-item>
                รวมทั้งสิ้น <v-text color="#F5580C" style="float: right;">฿ {{totalCartPrice+DeliveryPrice | formatNumber}}</v-text>
            </b-list-group-item>
        </b-list-group>
        <b-list-group class="pt-3">
            <b-list-group-item v-b-toggle.shipmentCollapse @click="isShipmentAddressCollapse = !isShipmentAddressCollapse">
                ข้อมูลการจัดส่ง <v-icon color="#F5580C" style="float: right; fon">{{ isShipmentAddressCollapse ? 'keyboard_arrow_down': 'keyboard_arrow_up' }}</v-icon>
            </b-list-group-item>
            <b-collapse id="shipmentCollapse">
                <b-list-group-item>
                    หมายเลขบัตร <div class="float-right"><input class="text-right" type="text" size="18" maxlength="16" placeholder="หมายเลขบัตร" v-model="card.number"></div>
                </b-list-group-item>
                <b-list-group-item>
                    CVV <div class="float-right"><input class="text-right" type="text" size="5" maxlength="3" placeholder="CVV" v-model="card.cvv"></div>
                </b-list-group-item>
            </b-collapse>
        </b-list-group>
        <b-list-group class="pt-3">
            <b-list-group-item v-b-toggle.creditCollapse @click="isCreditCollapse = !isCreditCollapse">
                ข้อมูลบัตร <v-icon color="#F5580C" style="float: right; fon">{{ isCreditCollapse ? 'keyboard_arrow_down': 'keyboard_arrow_up' }}</v-icon>
            </b-list-group-item>
            <b-collapse id="creditCollapse">
                <b-list-group-item>
                    หมายเลขบัตร <div class="float-right"><input class="text-right" type="text" size="18" maxlength="16" placeholder="หมายเลขบัตร" v-model="card.number"></div>
                </b-list-group-item>
                <b-list-group-item>
                    CVV <div class="float-right"><input class="text-right" type="text" size="5" maxlength="3" placeholder="CVV" v-model="card.cvv"></div>
                </b-list-group-item>
                <b-list-group-item>
                    วันหมดอายุ <div class="float-right"><input class="text-right" type="text" size="5" maxlength="2" placeholder="MM" v-model="card.exp.month"> / <input class="text-right" type="text" size="5" maxlength="4" placeholder="YYYY" v-model="card.exp.year"></div>
                </b-list-group-item>
                <b-list-group-item>
                    ชื่อบนบัตร <div class="float-right"><input class="text-right" type="text" size="30" placeholder="ชื่อผู้ถือบัตร" v-model="card.holder"></div>
                </b-list-group-item>
            </b-collapse>
        </b-list-group>
    </b-container>
    
    <button class="btn-block button-add p-3" style="background-color: #f5580c; color: white;"> 
        ชำระเงินเดี๋ยวนี้
    </button>
</div>
</template>

<script>
import OrderDetailHeader from '../components/header/OrderDetailHeader';
import ProductImage from "../components/ProductImage";
import { mapActions,mapGetters } from 'vuex'
import axios from "axios"
    export default {
        name: "OrderDetail",
        components: {
            OrderDetailHeader,
            ProductImage
        },
        data() {
            return {
                isCreditCollapse: true,
                isShipmentAddressCollapse: true,
                DeliveryPrice: 40,
                isSubmitted: false,
                card: {
                    number: '',
                    holder: '',
                    cvv: '',
                    exp: {
                        month: '',
                        year: '',
                    }
                }
            }
        },
        methods:{
            ...mapActions(['setIsShowToolBar']),
            processPayment: async function (element) {
                this.isSubmitted = true
                const cardInfo = {
                    name: this.card.holder,
                    number: this.card.number,
                    expiration_month: this.card.exp.month,
                    expiration_year: this.card.exp.year,
                    security_code: this.card.cvv,
                }
                const tokenResponse = await OmiseUtils.createCardToken(cardInfo)
                const cardToken = tokenResponse.response.id
                const chargeFormData = new FormData()
                chargeFormData.append('token', cardToken)
                try {
                    const chargeResponse = await axios.post(
                        `/payments/order/${this.$route.params.orderId}/omise`,
                        chargeFormData,
                        {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                )
                window.location = chargeResponse.data.authorizedUrl
                } catch (err) {
                    console.log(err)
                }
            }
        },
        mounted () {
            this.setIsShowToolBar(false)
        },
        computed:{
            ...mapGetters([
            'totalItemInCart',
            'totalCartPrice',
            'cart'
            ])
        }
    };

</script>

<style>
.hr-1 {
  border: 2px solid orangered;
  padding: 0px;
  margin: 0px;
}
.button-login {
  width: 90%;
}
.hearder{
  position: fixed;
    top: 0;
    width: 100%;
    margin-top: 0 !important;
    z-index: 100;
}
</style>


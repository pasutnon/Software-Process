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
                    ชื่อผู้รับสินค้า <div class="float-right"><input class="text-right" type="text" size="20" placeholder="ชื่อผู้รับสินค้า" v-model="shipment.name"></div>
                </b-list-group-item>
                <b-list-group-item>
                    อาคาร ถนน และอื่นๆ <div class="float-right"><input class="text-right" type="text" size="20" placeholder="อาคาร ถนน และอื่นๆ" v-model="shipment.address"></div>
                </b-list-group-item>
                <b-list-group-item>
                    จังหวัด <div class="float-right"><input class="text-right" type="text" size="20" placeholder="จังหวัด" v-model="shipment.province"></div>
                </b-list-group-item>
                <b-list-group-item>
                    อำเภอ/เขต <div class="float-right"><input class="text-right" type="text" size="20" placeholder="อำเภอ/เขต" v-model="shipment.state"></div>
                </b-list-group-item>
                <b-list-group-item>
                    แขวง <div class="float-right"><input class="text-right" type="text" size="20" placeholder="แขวง" v-model="shipment.district"></div>
                </b-list-group-item>
                <b-list-group-item>
                    รหัสไปรษณีย์ <div class="float-right"><input class="text-right" type="text" size="20" placeholder="รหัสไปรษณีย์" v-model="shipment.postcode"></div>
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
    <div class="mb-5"></div>
    <div class="fixed-nav btn-block button-add p-3 text-center " style="background-color: #f5580c; color: white; cursor: pointer;" @click="processCheckout()"> 
        <div v-if="isSubmitted">
            <div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
        </div>
        <div v-else>
            ชำระเงินเดี๋ยวนี้
        </div>
    </div>
</div>
</template>

<script>
import OrderDetailHeader from '../components/header/OrderDetailHeader';
import ProductImage from "../components/ProductImage";
import { mapActions,mapGetters } from 'vuex'
import OmiseUtils from '../utils/omise.js'
import axios from "../utils/axios.js"
import userUtils from '../utils/user.js'
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
                },
                shipment: {
                    name: '',
                    address: '',
                    district: '',
                    state: '',
                    province: '',
                    postcode: ''
                },
                orderId: null,
            }
        },
        methods:{
            ...mapActions(['setIsShowToolBar']),
            processPayment: async function (orderId) {
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
                try {
                    const chargeResponse = await axios.post(`/payments/order/${orderId}/omise`, {
                        token: cardToken
                    }
                )
                window.location = chargeResponse.data.authorizedUrl
                } catch (err) {
                    console.log(err)
                }
            },
            processOrder: async function () {
                const orderDetails = this.cart.map((item) => {
                        return {
                                productId: item.productId,
                        quantity: item.quantity,
                    }
                })
                const order = {
                        buyerId: userUtils.getUserId(),
                    orderDetails: orderDetails,
                    shipmentMethodId: '1',
                    shipmentAddress: this.shipment
                }
                const orderResponse = (await axios.post(`/orders/user/${userUtils.getUserId()}`, order)).data
                this.processPayment(orderResponse.id)
            },
            processCheckout: async function () {
                if (this.isSubmitted === false) {
                    this.isSubmitted = true
                    this.processOrder()
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
            ]),
        }
    };

</script>

<style>
.fixed-nav {
  position: fixed;
  bottom: 0;
  width: 100%;
  margin-bottom: 0 !important;
  z-index: 100;
}
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
.lds-ellipsis {
  display: inline-block;
  position: relative;
  width: 64px;
  height: 10px;
}
.lds-ellipsis div {
  position: absolute;
  top: 0px;
  width: 11px;
  height: 11px;
  border-radius: 50%;
  background: #fff;
  animation-timing-function: cubic-bezier(0, 1, 1, 0);
}
.lds-ellipsis div:nth-child(1) {
  left: 6px;
  animation: lds-ellipsis1 0.6s infinite;
}
.lds-ellipsis div:nth-child(2) {
  left: 6px;
  animation: lds-ellipsis2 0.6s infinite;
}
.lds-ellipsis div:nth-child(3) {
  left: 26px;
  animation: lds-ellipsis2 0.6s infinite;
}
.lds-ellipsis div:nth-child(4) {
  left: 45px;
  animation: lds-ellipsis3 0.6s infinite;
}
@keyframes lds-ellipsis1 {
  0% {
    transform: scale(0);
  }
  100% {
    transform: scale(1);
  }
}
@keyframes lds-ellipsis3 {
  0% {
    transform: scale(1);
  }
  100% {
    transform: scale(0);
  }
}
@keyframes lds-ellipsis2 {
  0% {
    transform: translate(0, 0);
  }
  100% {
    transform: translate(19px, 0);
  }
}
</style>


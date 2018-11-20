<template>
    <div>
        <v-top>
            <v-toolbar color="white" height="50.00px" card>
                <v-spacer></v-spacer>
                <h4 class="text-nav">ที่อยู่การจัดส่ง</h4>
                <v-spacer></v-spacer>
            </v-toolbar>
            <v-toolbar id="orange-line" color="#F5580C" height="3.75px">
            </v-toolbar>
        </v-top>
    </div>
</template>

<script>
export default {
  name: "ShipmentHeader"
};
</script>

<style>
v-top {
  float: initial;
}
.text-nav {
  color: orangered;
}
</style>
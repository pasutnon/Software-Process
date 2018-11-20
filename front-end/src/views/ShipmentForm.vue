<template>
 
  <div>

    <div>
      <ShipmentHeader />
    </div>

    <div>
        <li>{{name}}</li>
        <li>{{addresses}}</li>
        <li>{{district}}</li>
        <li>{{state}}</li>
        <li>{{postCode}}</li>
    </div>

    <div> 
        <v-dialog
        v-model="dialog"
        width="500"
        >

        <v-btn
        slot="activator"
        color="red"
        dark
        >
          เพิ่มที่อยู่
        </v-btn>
        
            <v-card>
              <v-container>
                <v-card-text>
                    <v-form ref="form">
                        <v-flex>
                            <v-text-field
                              v-model="name"
                              label="name"
                              placeholder="ชื่อผู้รับสินค้า"
                              solo
                            ></v-text-field>
                        </v-flex>

                        <v-flex>
                            <v-text-field
                              v-model="addresses"
                              label="addresses"
                              placeholder="อาคาร ถนน และอื่นๆ"
                              solo
                            ></v-text-field>
                        </v-flex>

                        <v-flex>
                          <v-select
                            :items="items"
                            v-model="state"
                            label="state"
                            placeholder="จังหวัด"
                            solo
                          ></v-select>
                        </v-flex>

                        <v-flex>
                            <v-text-field
                              v-model="district"
                              label="district"
                              placeholder="อำเภอ/เขต"
                              solo
                            ></v-text-field>
                        </v-flex>

                        <v-flex>
                            <v-text-field
                              v-model="postCode"
                              label="postCode"
                              placeholder="รหัสไปรษณีย์"
                              required
                              solo
                            ></v-text-field>
                        </v-flex>
                    </v-form>
                </v-card-text>

                <v-layout justify-center>
                  <v-btn
                  color="#F5580C"
                  @click="postPost();"
                  >
                    เพิ่มที่อยู่
                  </v-btn>   
                </v-layout>

            </v-container>
          </v-card>
        </v-dialog>
    </div>
  </div>
</template>

<style>
</style>

<script>
import ShipmentHeader from "../components/header/ShipmentHeader";
export default {
  name: "shipmentform",
  components: {
    ShipmentHeader
  },
  data() {
    return {
      dialog: false,
      address: {
        name: String,
        addresses: String,
        state: String,
        province: String,
        postCode: String,
        district: String
      },
      userId: String,
      items: [
        "กรุงเทพฯ",
        "กระบี่",
        "กาญจนบุรี",
        "กาฬสินธุ์",
        "กำแพงเพชร",
        "ขอนแก่น",
        "จันทบุรี",
        "ฉะเชิงเทรา",
        "ชลบุรี",
        "ชัยนาท",
        "ชัยภูมิ",
        "ชุมพร",
        "เชียงใหม่",
        "เชียงราย",
        "ตรัง",
        "ตราด",
        "ตาก",
        "นครนายก",
        "นครปฐม",
        "นครพนม",
        "นครราชสีมา",
        "นครศรีธรรมราช",
        "นครสวรรค์",
        "นนทบุรี",
        "นราธิวาส",
        "น่าน",
        "บึงกาฬ",
        "บุรีรัมย์",
        "ปทุมธานี",
        "ประจวบคีรีขันธ์",
        "ปราจีนบุรี",
        "ปัตตานี",
        "พระนครศรีอยุธยา",
        "พะเยา",
        "พังงา",
        "พัทลุง",
        "พิจิตร",
        "พิษณุโลก",
        "เพชรบุรี",
        "เพชรบูรณ์",
        "แพร่",
        "ภูเก็ต",
        "มหาสารคาม",
        "มุกดาหาร",
        "แม่ฮ่องสอน",
        "ยโสธร",
        "ยะลา",
        "ร้อยเอ็ด",
        "ระนอง",
        "ระยอง",
        "ราชบุรี",
        "ลพบุรี",
        "ลำปาง",
        "ลำพูน",
        "เลย",
        "ศรีสะเกษ",
        "สกลนคร",
        "สงขลา",
        "สตูล",
        "สมุทรปราการ",
        "สมุทรสงคราม",
        "สมุทรสาคร",
        "สระแก้ว",
        "สระบุรี",
        "สิงห์บุรี",
        "สุโขทัย",
        "สุพรรณบุรี",
        "สุราษฎร์ธานี",
        "สุรินทร์",
        "หนองคาย",
        "หนองบัวลำภู",
        "อ่างทอง",
        "อำนาจเจริญ",
        "อุดรธานี",
        "อุตรดิตถ์",
        "อุทัยธานี",
        "อุบลราชธานี"
      ]
    }
  },
  methods: {
    postPost() {
      axios
        .post("/addresses/user/" + userId, address)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    getAddress() {
      axios
        .get("/addresses/user/" + userId)
        .then(response => {
          this.address = response
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
}
</script>
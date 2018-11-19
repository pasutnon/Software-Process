<template>
 
  <div>
    <div>
      <ShipmentHeader />
    </div>

    <div>
        <v-flex xs10 offset-xs1>
          <v-card>
            <v-container>
              <v-card-text>
                  <v-form ref="form">
                      <v-flex xs12 sm6 md3>
                          <v-text-field
                            label="name"
                            placeholder="ชื่อผู้รับสินค้า"
                            solo
                          ></v-text-field>
                      </v-flex>

                      <v-flex xs12 sm6 md3>
                          <v-text-field
                            label="phoneNumber"
                            placeholder="เบอร์โทรศัพท์"
                            solo
                          ></v-text-field>
                      </v-flex>

                      <v-flex xs12 sm6 md3>
                          <v-text-field
                            label="addressDetail"
                            placeholder="อาคาร ถนน และอื่นๆ"
                            solo
                          ></v-text-field>
                      </v-flex>

                      <v-flex xs12 sm6 md3>
                        <v-select
                          :items="items"
                          label="state"
                          placeholder="จังหวัด"
                          solo
                        ></v-select>
                      </v-flex>

                      <v-flex xs12 sm6 md3>
                          <v-text-field
                            label="district"
                            placeholder="อำเภอ/เขต"
                            solo
                          ></v-text-field>
                      </v-flex>

                      <v-flex xs12 sm6 md3>
                          <v-text-field
                            label="postCode"
                            placeholder="รหัสไปรษณีย์"
                            solo
                          ></v-text-field>
                      </v-flex>
                
                      <v-btn
                        @click="submit"
                      >
                        submit
                      </v-btn>
                  </v-form>
              </v-card-text>                
          </v-container>
        </v-card>
      </v-flex>
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
    };
  }
};
</script>
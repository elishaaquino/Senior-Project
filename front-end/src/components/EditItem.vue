<template>
    <div class="edit-item">

        <!-- form -->
        <form 
            class="form1" 
            @submit.prevent="editItem"
        >

            <!-- error checking -->
            <p v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                <li v-for="(error, index) in errors" :key="index">{{ error }}</li>
                </ul>
            </p>

            <!-- required fields -->            
            <label for="item-name">Item Name</label>
            <input class="input-response field" id="item-name" v-model="itemName"/>

            <label for="price">Price</label>
            <input class="input-response field" id="price" v-model="price" type="number"/>

            <label for="quant">Quantity</label>
            <input class="input-response field" id="quant" v-model="quant"/>

            <label for="desc">Description</label>
            <textarea class="input-response field" id="desc" v-model="desc" rows="3"/>

            <!-- upload images -->
            <div class="img-upload-div">
                <label class="img-upload field"><input type="file" multiple="multiple" @change="onFileChange($event.target.files)"/>+ Add photo</label>
                <!-- <label class="img-upload-max" v-else><input type="file" disabled/>Max uploaded</label> -->
            </div>
            <div class="display-img">
                <img class="img-box" v-for="img in imgs" :key="img" :src="img"/>
            </div>

            <!-- optional information -->
            <strong>Extra Information (Optional)</strong>
            <label for="alergens">Allergens</label>
            <input class="input-response field" id="allergens" v-model="allergens"/>

            <label for="diet">Dietary Restrictions</label>
            <input class="input-response field" id="diet" v-model="diet"/>

            <button class="editItem">Edit Item</button>

            <b-button class="deleteItem" v-b-modal.modal-1>DELETE ITEM</b-button>
            <b-modal id="modal-1" title="Delete Item?" @ok="deleteItem" :ok-disabled="false">
                <p class="my-4">Are you sure you want to delete this item? This action cannot be undone.</p>
            </b-modal>

        </form>
    </div>
</template>

<script>
import http from "../http-common";
import ItemService from '../service/ItemService';

export default {
   name: "Edit-Item",
   data() {
       return {
           files: [],
           imgs: [],
           errors: [],
           itemName: '',
           price: '',
           quant: '',
           desc: '',
           allergens: '',
           diet: '',
       }
    },
    methods: {

        // upon submission
        editItem: function(e) {

            // checks if all required input fields are filled in
            if (this.itemName && this.price && this.quant && this.desc) {
                
                const formData = new FormData();

                for (let i = 0; i < this.files.length; i++) {
                    formData.append("photos", this.files[i]);
                }
                
                http.post("storage/uploadImages",formData).then(
                    resp => {
                        var photoURLS= [];

                        for (let i = 0; i < resp.data.length; i++) {
                            photoURLS.push(resp.data[i])
                        }

                        var userId = JSON.parse(localStorage.user)["id"];

                        var item = {
                            ownerId: userId, 
                            name: this.itemName, 
                            price: this.price, 
                            quantity: this.quant,
                            desc: this.desc,
                            extraInfo: {
                                allergens: this.allergens, 
                                dietaryRestric: this.diet
                            },
                            photos: photoURLS,
                            reviews:[]
                        }

                        return item;
                    }
                ).then(
                    resp => {
                        ItemService.editItem(this.$route.params.id, resp).then(this.$router.push('/edititemsuccess/' + this.$route.params.id));
                    }
                ); 
            }
            else {
                this.errors = [];

                if (!this.itemName) {
                    this.errors.push('Item name required');
                }

                if (!this.price) {
                    this.errors.push('Price of item required');
                }

                if (!this.quant) {
                    this.errors.push('Quantity of item required');
                }

                if (!this.desc) {
                    this.errors.push('Description required');
                }

                e.preventDefault();
            }
        },
        // adds uploaded images to list
        onFileChange(f) {

            for (let i = 0; i < f.length; i++) {

                    this.files.push(f[i]);

                    this.imgs.unshift( 
                   
                        URL.createObjectURL(f[i])
                    );
            }
        },
        getItemInfo() {
           ItemService.getItem(this.$route.params.id).then(resp => {
              let res = resp.data;
              this.itemName = res.name;
              this.price = res.price;
              this.quant = res.quantity;
              this.allergens = res.extraInfo.allergens;
              this.diet = res.extraInfo.dietaryRestric;
              this.desc = res.desc;
           });
        },
        deleteItem() {
            ItemService.deleteItem(this.$route.params.id).then(
                this.$router.push('/deleteitemsuccess/')
            )
        }
   },
   created() {
      this.getItemInfo();
   }
};
</script>

<style scoped>
.edit-item-header {
    text-align: center;
    padding: 5% 0% 1% 0%;
}

.form1 {
    display: flex;
    flex-direction: column;
    padding: 0% 30% 5% 30%;
}

.field {
    width: 100%;
    color: rgb(38, 50, 56);
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border: none;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-bottom: 50px;
    margin-bottom: 27px;
    font-family: 'Ubuntu', sans-serif;
}

.img-upload-div {
    padding: 3% 0% 5% 0%;
}

input[type="file"] {
    display: none;
}

.img-upload {
    text-align: center;
    border-radius: 2em;
    width: 100%;
    padding: 5%;
    cursor: pointer;
}

.img-upload-max {
    text-align: center;
    border: 1px solid #000000;
    border-radius: 2em;
    width: 100%;
    padding: 5%;
}

.img-upload:hover{
    background-color: grey;
}

.img-box {
    max-width:50%;
    max-height:50%;
}

.editItem {
    padding:1.5em .5em 1.5em .5em;
    margin:0 0.3em 0.3em 0;
    border-radius:2em;
    box-sizing: border-box;
    text-decoration:none;
    font-weight:300;
    color:#000000;
    background-color:#D25B3E;
    text-align:center;
    transition: all 0.2s;
    border: none;
    font-family: 'Archivo Black', sans-serif;
    color: white;
}

.deleteItem {
    padding:0.3em 1.2em;
    margin:2em 0.3em 0.3em 0;
    border-radius:2em;
    border: 2px solid #000000;
    box-sizing: border-box;
    text-decoration:none;
    font-weight:300;
    color:#000000;
    background-color:white;
    transition: all 0.2s;
    font-family: 'Archivo Black', sans-serif;
}

.edit-item-button:hover{
    background-color: grey;
}

</style>
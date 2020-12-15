<template>
    <div class="add-item">
        <strong><h2 class="add-item-header">Add item to store.</h2></strong>

        <!-- form -->
        <form 
            class="form1" 
            @submit.prevent="createNewItem"
        >

            <!-- error checking -->
            <p v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                <li v-for="(error, index) in errors" :key="index">{{ error }}</li>
                </ul>
            </p>

            <!-- required fields -->
            <strong>Required</strong>

            <label for="item-name">Item Name</label>
            <input class="input-response field" id="item-name" v-model="itemName"/>

            <label for="price">Price</label>
            <input class="input-response field" id="price" v-model="price" type="number"/>

            <label for="quant">Quanity</label>
            <input class="input-response field" id="quant" v-model="quant"/>

            <label for="desc">Description</label>
            <textarea class="input-response field" id="desc" v-model="desc" rows="3"/>

            <!-- upload images -->
            <div class="img-upload-div">
                <label class="img-upload field"><input type="file" multiple="multiple" @change="onFileChange($event.target.files)"/>+ Add photo</label>
                <!-- <label class="img-upload-max" v-else><input type="file" disabled/>Max uploaded</label> -->
            </div>
            <div class="display-img">
                <img class="img-box" v-for="img in imgs" :key="img.id" :src="img.url"/>
            </div>

            <!-- optional information -->
            <strong>Extra Information (Optional)</strong>
            <label for="alergens">Allergens</label>
            <input class="input-response field" id="allergens" v-model="allergens"/>

            <label for="diet">Dietary Restrictions</label>
            <input class="input-response field" id="diet" v-model="diet"/>

            <button class="add-item-button">+ Add Item</button>

        </form>
    </div>
</template>

<script>
import http from "../http-common";
import ItemService from '../service/ItemService';

export default {
   name: "Add-Item",
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
        createNewItem: function(e) {

            // checks if all required input fields are filled in
            if (this.itemName && this.price && this.quant && this.desc && this.files.length != 0) {
                
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
                            reviews: [null]
                        }

                        return item;
                    }
                ).then(
                    resp => {
                        ItemService.additem(resp).then(this.$router.push('/additemsuccess'))
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

                if (this.files.length == 0) {
                    this.errors.push('Photos required');
                }

                e.preventDefault();
            }
        },

        // adds uploaded images to list
        onFileChange(f) {

            for (let i = 0; i < f.length; i++) {

                    this.files.push(f[i]);

                    this.imgs.unshift( {
                        id: this.imgs.length + 1,
                        url: URL.createObjectURL(f[i])
                    });
            }
      }
   }
};
</script>

<style scoped>
.add-item-header {
    text-align: center;
    padding: 5% 0% 1% 0%;
}

.form1 {
    display: flex;
    flex-direction: column;
    padding: 0% 30% 30% 30%;
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

.add-item-button {
    padding:0.3em 1.2em;
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#ffffff;
    width: 45%;
    margin-top: 5%;
    margin-left: 27.5%;
    margin-right: 27.5%;
    cursor: pointer;
}

.add-item-button:hover{
    background-color: grey;
}

</style>

<template>
    <div class="add-item">
        <strong><h2 class="add-item-header">Add item to store.</h2></strong>
        <form 
            class="add-item_create-item" 
            @submit.prevent="createNewItem"
        >

            <p v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                <li v-for="(error, index) in errors" :key="index">{{ error }}</li>
                </ul>
            </p>

            <label for="item-name">Item Name</label>
            <input class="input-response" id="item-name" v-model="itemName"/>

            <label for="price">Price</label>
            <input class="input-response" id="price" type="number" v-model="price"/>

            <label for="desc">Description</label>
            <textarea class="input-response" id="desc" v-model="desc" rows="3"/>

            <div class="img-upload-div">
                <label class="img-upload" v-if="files.length < 4"><input type="file" multiple="multiple" @change="onFileChange($event.target.files)"/>+ Add photo (4 max)</label>
                <label class="img-upload-max" v-else><input type="file" disabled/>Max uploaded</label>
            </div>

            <div class="display-img">
                <img class="img-box" v-for="img in imgs" :key="img.id" :src="img.url"/>
            </div>

            <strong>Extra Information (Optional)</strong>
            <label for="alergens">Allergens</label>
            <input class="input-response" id="allergens" v-model="allergens"/>

            <label for="diet">Dietary Restrictions</label>
            <input class="input-response" id="diet" v-model="diet"/>

            <button class="add-item-button">+ Add Item</button>

        </form>
    </div>
</template>

<script>
import http from "../http-common";

export default {
   name: "Add-Item",
   data() {
       return {
           files: [],
           imgs: [],
           errors: [],
           itemName: '',
           price: '',
           desc: '',
           allergens: '',
           diet: ''
       }
   },
   methods: {
       createNewItem: function(e) {

           if (this.itemName && this.price && this.desc && this.files.length != 0) {
                console.log("Valid.");

                for (let i = 0; i < this.files.length; i++) {
                    const formData = new FormData();
                    formData.append("file", this.files[i]);
                    
                    http.post("storage/uploadImage",formData).then(resp => console.log(resp.data));
                }     
            }
            else {
                this.errors = [];

                if (!this.itemName) {
                    this.errors.push('Item name required');
                }

                if (!this.price) {
                    this.errors.push('Price of item required');
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
        onFileChange(f) {

            for (let i = 0; i < f.length; i++) {

                if (this.files.length < 4) {
                    this.files.push(f[i]);

                    this.imgs.unshift( {
                        id: this.imgs.length + 1,
                        url: URL.createObjectURL(f[i])
                    });
                }
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

.add-item_create-item {
    display: flex;
    flex-direction: column;
    padding: 0% 30% 30% 30%;
}

.input-response {
    border: 1px solid #000000;
    border-radius: 2em;
    height: 35px;
    margin-bottom: 10px;
}

.img-upload-div {
    padding: 3% 0% 5% 0%;
}

input[type="file"] {
    display: none;
}

.img-upload {
    text-align: center;
    border: 1px solid #000000;
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
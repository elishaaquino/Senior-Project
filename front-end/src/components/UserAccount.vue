<template>
   <div>
        <div class="profile-main">
            <div class="profile-header">
                <div class="container user-detail">
                    <div class="user-image">
                        <img :src="photo">
                        <div v-if="btn_id === 0">
                            <button class="selected" @click="set_SelectedButton(0)">Selling</button>
                            <button class="unselected" @click="set_SelectedButton(1)">Buying</button>
                        </div>
                        <div v-if="btn_id === 1">
                            <button class="unselected" @click="set_SelectedButton(0)">Selling</button>
                            <button class="selected" @click="set_SelectedButton(1)">Buying</button>
                        </div>
                        <div class="addButton">
                            <b-button class="addItem" href="../additem">+ Add Item</b-button>
                        </div>
                    </div>
                    <div class="user-data">
                        <h2>Welcome Back, <strong>{{userUsername}}</strong></h2>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div v-if="btn_id === 0">
                                <Item 
                                    v-for="item in sellingItems" 
                                    :key="item.id"
                                    :id="item.id"
                                    :itemName="item.name"
                                    :price=item.price
                                    :quantity="item.quantity"
                                    :photo="item.photos[0]"
                                    :sellerId="item.ownerId"/>
                            </div>
                            <div v-if="btn_id === 1">
                                <Item 
                                    v-for="item in buyingItems" 
                                    :key="item.id"
                                    :id="item.id"
                                    :itemName="item.name"
                                    :price=item.price
                                    :quantity="item.quantity"
                                    :photo="item.photos[0]"
                                    :sellerId="item.ownerId"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </div>
</template>

<script>
import Item from "./Item";
import ItemService from '../service/ItemService';

export default {
    name: 'userAccount',
    components: {Item},
        data () {
            return {
                userUsername: "",
                btn_id: 0,
                sellingItems: [],
                buyingItems: []
            }
        },
        methods: {
            set_SelectedButton(value){

                this.btn_id=value;

            },

            getItems() {

                var userId = JSON.parse(localStorage.user)["id"];
                
                ItemService.getItemUserAccount(userId).then(
                    response => {

                        for (let i = 0; i < response.data.length; i++) {
                            this.sellingItems.push(
                             response.data[i]
                             );
                        }
                    }
                );
            }
        },
        created() {
            this.userUsername = JSON.parse(localStorage.user)["username"];
            this.photo = JSON.parse(localStorage.user)["userImage"];
            var userId = JSON.parse(localStorage.user)["id"];

            this.getItems(userId);
        },
    };
</script>

<style scoped>
    .container {
        display: flex;
        align-items: center;
    }
    .row {
        position: relative;
        margin-top: 1rem;
        display: flex;
        flex-wrap: wrap;
    }
    button.selected {
        display: inline-block;
        padding: 0.35em 1.2em;
        margin: 0 0.3em 0.3em 0;
        border: none;
        font-weight:300;
        color:#ffffff;
        background-color:#000000;
        text-align:center;
        transition: all 0.2s;
    }
    button.selected:focus {
        color:#ffffff;
        background-color:#000000;
    }
    button.selected:hover {
        color:#ffffff;
        background-color:#000000;
    }
    button.unselected {
        display: inline-block;
        padding: 0.35em 1.2em;
        margin: 0 0.3em 0.3em 0;
        border: none;
        font-weight:300;
        color:#000000;
        background-color:#ffffff;
        text-align:center;
        transition: all 0.2s;
    }
    .addItem {
        padding:0.3em 1.2em;
        margin:0 0.3em 0.3em 0;
        border-radius:2em;
        box-sizing: border-box;
        text-decoration:none;
        font-weight:300;
        color:#000000;
        background-color:#ffffff;
        text-align:center;
        transition: all 0.2s;
        width: 65%;
    }
    .profile-main{
        margin: 0 auto;
    }
    .user-detail{
        position: relative;
        width: 75%;
        margin: 0 auto;
        height: 100%;
    }
    .user-image{
        float: left;
        position: relative;
        width: 30%;
    }
    .user-image img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        margin-top: 35px;
        padding-bottom: 1rem;
    }
    .user-data{
        float: left;
        width: 75%;
        padding-left: 27px;
        margin-top: 1rem;
    }
    .addButton {
        padding-top: 0.5rem;
    }
</style>

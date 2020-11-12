<template>
   <div>
        <div class="profile-main">
            <div class="profile-header">
                <div class="user-detail">
                    <div class="user-image">
                        <img src="../../public/images/profilePicture.jpg">
                        <a href="#selling" class="button1" @click="set_SelectedButton(0)">Selling</a>
                        <a href="#buying" class="button1" @click="set_SelectedButton(1)">Buying</a>
                        <br>
                        <b-button class="button3" href="additem">+ Add Item</b-button>
                    </div>
                    <div class="user-data">
                        <h2>Welcome Back,</h2>
                        <h2><strong>{{userUsername}}</strong></h2>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div v-if="btn_id === 0">
                                <Item 
                                    v-for="item in sellingItems" 
                                    :key="item.id"
                                    :itemName="item.itemName"
                                    :price="item.price"
                                    :quantity="item.quantity"/>
                            </div>
                            <div v-if="btn_id === 1">
                                <Item 
                                    v-for="item in buyingItems" 
                                    :key="item.id"
                                    :itemName="item.itemName"
                                    :price="item.price"
                                    :quantity="item.quantity"/>
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

export default {
    name: 'userAccount',
    components: {Item},
        data () {
            return {
                userUsername: "",
                btn_id: 0,
                sellingItems: [
                    { id: 1, itemName: "Brownies", price: "$12", quantity: "1 dozen"}, 
                    { id: 2, itemName: "Cookies", price: "$12", quantity: "1 dozen"},
                    { id: 3, itemName: "Lemon Bar", price: "$12", quantity: "1 dozen"},
                    { id: 4, itemName: "Brownies", price: "$12", quantity: "1 dozen"}
                ],
                buyingItems: [
                    { id: 5, itemName: "Fudge Brownies", price: "$12", quantity: "1 dozen"},
                    { id: 6, itemName: "Pizookie", price: "$12", quantity: "1"},
                    { id: 7, itemName: "Dulce de leche", price: "$12", quantity: "1 dozen"},
                    { id: 8, itemName: "Ube Cookies", price: "$12", quantity: "1 dozen"}
                ]
            }
        },
        methods: {
            set_SelectedButton(value){
                this.btn_id=value;
            }
        },
        created() {
            this.userUsername = this.$route.params.userUsername;
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
    a.button1 {
        display: inline-block;
        padding: 0.35em 1.2em;
        margin: 0 0.3em 0.3em 0;
        border-radius:0.12em;
        box-sizing: border-box;
        text-decoration:none;
        font-weight:300;
        color:#000000;
        text-align:center;
        transition: all 0.2s;
    }
    a.button1:focus {
        color:#ffffff;
        background-color:#000000;
    }
    a.button1:hover {
        color:#ffffff;
        background-color:#000000;
    }
    .button3 {
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
        width: 25%;
    }
    .user-image img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        margin-top: 35px;
        padding-bottom: 2rem;
    }
    .user-data{
        float: left;
        width: 75%;
        padding-left: 27px;
        margin-top: 8rem;
    }
</style>
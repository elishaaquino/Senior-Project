<template>
   <div>
        <div class="container profile-main">
            <div class="profile-header">

                <!-- user information -->
                <div class="row mt-5">
                    <div class="col-lg-2 user-image">
                        <img src="../../public/images/profilePicture.jpg">
                        <br>
                    </div>
                    <div class="col-lg-4 user-data">
                        <h2><strong>{{ seller }} </strong></h2>
                        <b-button class="button3 disabled" href="../additem">Contact Seller</b-button>
                    </div>
                    <div class="col-lg-6">
                        <p> Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque nisl eros, 
                            pulvinar facilisis justo mollis, auctor consequat urna. Morbi a bibendum metus. 
                            Donec scelerisque sollicitudin enim eu venenatis. Duis tincidunt laoreet ex, 
                            in pretium orci vestibulum eget.
                        </p>
                        <p>San Diego, CA</p>
                        <p>13 Items</p>
                    </div>
                </div>

                <!-- display items -->
                <div class="row mt-5">
                    <div class="col-lg-12">
                        <div v-if="btn_id === 0">
                            <Item 
                                v-for="item in sellingItems" 
                                :key="item.id"
                                :itemName="item.itemName"
                                :price="item.price"
                                :quantity="item.quantity"/>
                        </div>
                    </div>
                </div>

                <!-- reviews -->
                <div class="row mb-4 mt-5">
                    <div class="col-1"><strong>Reviews</strong></div>
                </div>
                <div>
                    <Review 
                        v-for="r in reviews"
                        :key="r.id"
                        :userName="r.username"
                        :date="r.date"
                        :content="r.content"
                        :imgUrl="r.img"
                    />
                </div>

            </div>
        </div>
   </div>
</template>

<script>
import Item from "./Item";
import Review from "./Review";

export default {
    name: 'storepage',
    components: {Item, Review},
        data () {
            return {
                seller: '',
                storename: '',
                btn_id: 0,
                sellingItems: [
                    { id: 1, itemName: "Brownies", price: "$12", quantity: "1 dozen"}, 
                    { id: 2, itemName: "Cookies", price: "$12", quantity: "1 dozen"},
                    { id: 3, itemName: "Lemon Bar", price: "$12", quantity: "1 dozen"},
                    { id: 4, itemName: "Brownies", price: "$12", quantity: "1 dozen"},
                    { id: 5, itemName: "Brownies", price: "$12", quantity: "1 dozen"},
                    { id: 6, itemName: "Brownies", price: "$12", quantity: "1 dozen"},
                    { id: 7, itemName: "Brownies", price: "$12", quantity: "1 dozen"}
                ],
                reviews: [
                    { id: 1, username: "Maggie Chang", date: "11/11/20", content: "Reliable!", img: "profilePicture.jpg" },
                    { id: 2, username: "Monica Andres", date: "11/12/20", content: "Great vegan options", img: "profilePicture.jpg" },
                    { id: 3, username: "Elisha Aquino", date: "11/14/20", content: "Responds quickly!", img: "profilePicture.jpg" }
                ]
            }
        },
        methods: {
            set_SelectedButton(value){
                this.btn_id=value;
            }
        },
        created() {
            this.seller = this.$route.params.seller_firstName + " " + this.$route.params.seller_lastName;
            this.storename = this.$route.params.storename;
        },
    };
</script>

<style scoped>
    .container {
        display: flex;
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
        width: 50%;
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
    }
    .user-image img{
        width: 80%;
        height: 80%;
        border-radius: 50%;
    }
</style>
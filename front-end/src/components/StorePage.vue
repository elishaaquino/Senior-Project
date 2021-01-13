<template>
   <div>
        <div class="container profile-main">
            <div class="profile-header">

                <!-- user information -->
                <div class="row mt-5">
                    <div class="col-lg-3 user-image">
                        <img :src="seller_photo">
                        <br>
                    </div>
                    <div class="col-lg-5 user-data">
                        <h2><strong> {{ store_name }} </strong></h2>
                        <b-button class="button3 disabled" href="">Contact Seller</b-button>
                    </div>
                    <div class="col-lg-4">
                        <strong>Contact Information</strong>
                        <strong><p>Phone: {{ phone }}</p></strong>
                        <strong><p>Email: {{ email }}</p></strong>
                        <strong><p>Instagram: {{ instagramHandle }}</p></strong>
                        <strong><p>Facebook: {{ facebookUrl }}</p></strong>
                        <p>{{ numItems }} items</p>
                    </div>
                </div>

                <!-- display items -->
                <div class="row mt-5">
                    <div class="col-lg-12">
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
                </div>

                <!-- reviews -->
                <div class="row mb-4 mt-5">
                    <div class="col"><strong>All Reviews</strong></div>
                </div>
                <div>
                    <Review 
                        v-for="r in reviews"
                        :key="r.id"
                        :userName="r.username"
                        :date="r.date"
                        :content="r.review"
                        :imgUrl="r.userImage"
                    />
                </div>

            </div>
        </div>
   </div>
</template>

<script>
import Item from "./Item";
import Review from "./Review";
import ItemService from '../service/ItemService';
import UserDataService from '../service/UserDataService';

export default {
    name: 'storepage',
    components: {Item, Review},
        data () {
            return {
                seller: '',
                sellerId: '',
                phone: '',
                email: '',
                instagramHandle: '',
                facebookUrl: '',
                storename: '',
                sellingItems: [],
                reviews: []
            }
        },
        methods: {
            getItems() {
                ItemService.getItemStorePage(this.sellerId).then(
                    resp => {
                        for (let i = 0; i < resp.data.length; i++) {
                            this.sellingItems.push(
                                resp.data[i]
                            );
                        }
                    }
                );
            },
            getUser() {
                UserDataService.getUser(this.sellerId).then(
                    resp => {
                        this.phone = resp.data["contact"]["phoneNumber"];
                        this.instagramHandle = resp.data["contact"]["instagramHandle"];
                        this.facebookUrl = resp.data["contact"]["facebookUrl"];
                        this.email = resp.data["contact"]["email"];
                        
                        this.reviews = resp.data["reviews"];
                    }
                )
            }
        },
        computed: {
            numItems() {
                return this.sellingItems.length;
            },
            seller_photo() {
                return this.$store.getters.seller_photo;
            },
            store_name() {
                return this.$store.getters.seller;
            }
        },
        created() {
            this.sellerId= this.$route.params.sellerId;

            this.getItems();
            this.getUser();
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
    img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        margin-top: 35px;
        padding-bottom: 1rem;
    }
</style>
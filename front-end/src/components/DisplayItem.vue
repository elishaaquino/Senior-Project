<template>
    <div class="container">

        <div class="row mt-5 mb-4">

            <!-- photos -->
            <div class="col-6 pl-0">
                <div class="gallery-row">
                    <div class="gallery-container">
                        <lightbox css="h-250 h-lg-400" :items="images" :cells="4"></lightbox>
                    </div>
                </div>
            </div>

            <!-- required item information -->
            <div class="item-details col-3 pl-0">
                <strong>{{itemName}}</strong>
                <p>{{price}}</p>
                <p>{{amount}}</p>
                <div @click="toaddstorepage(seller_firstName, seller_lastName)">
                    <router-link :to="{ name: 'storepage', params: { storename: seller_firstName+seller_lastName, sellerId: sellerId } }">
                        <div class="row mt-5 align-items-center">
                            <div class="usr-img col-3 pr-0">
                                <img src="../../public/images/profilePicture.jpg">
                            </div>
                            <div class="col pl-0">
                                <strong>Made by {{ seller_firstName }}</strong>
                            </div>
                        </div>
                    </router-link>
                </div>
                <div class="row mt-3 pl-3">
                    <b-button class="contact-button">Message Seller</b-button>
                </div>
            </div>

            <!-- extra information -->
            <div class="extra-info col-3">
                <strong>Extra Information</strong>
                <strong><p>Contains:</p></strong>
                <p>{{allergens}}</p>
                <strong><p>Dietary Restrictions:</p></strong>
                <p>{{diet}}</p>
            </div>
        </div>

        <!-- reviews -->
        <div class="row mb-4">
            <div class="col-1"><strong>Reviews</strong></div>
            <div class="col-3">
                <div @click="toaddreview(seller_firstName, itemName, id)">
                    <router-link :to="{ name: 'addreview', params: { id: id } }">
                        <b-button class="add-review-button">+ Add Review</b-button>
                    </router-link>
                </div>
            </div>
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
</template>

<script>
import Review from "./Review";
import ItemService from '../service/ItemService';
import UserDataService from '../service/UserDataService';

export default {
    name: "Display-Item",
    components: {
      Review
    },
    data: () => {
        return {
            id: '', //item id
            seller_firstName: '',
            seller_lastName: '',
            sellerId: '',
            itemName: '',
            price: '',
            amount: '',
            allergens: '',
            diet: '',
            images: [],
            reviews: []
        };
    },
    methods: {
        toaddreview(seller_firstName, itemName, id) {
            localStorage.setItem('sellerfirstname', seller_firstName);
            localStorage.setItem('itemname', itemName);
            this.$router.push('/addreview/' + id);
        },
        toaddstorepage(seller_firstName, seller_lastName) {
            localStorage.setItem('storename', seller_firstName + " " + seller_lastName);
        },
        getItemInfo() {
           ItemService.getItem(this.$route.params.id).then(resp => {
              let res = resp.data;
              this.id = res.id;
              this.sellerId = res.ownerId;
              this.itemName = res.name;
              this.price = res.price;
              this.amount = res.quantity;
              this.allergens = res.extraInfo.allergens;
              this.diet = res.extraInfo.dietaryRestric;
              this.images = res.photos;
              this.reviews = res.reviews;

              return res.ownerId;
           }).then(resp => {
              console.log(resp)
              UserDataService.getUser(resp).then(resp => {
                 let res = resp.data;
                 this.seller_firstName = res.firstName;
                 this.seller_lastName = res.lastName;
              })
           });
        }
    },
    created() {
        this.getItemInfo();
    }
};
</script>

<style>
.gallery-container {
  width: 100%;
}

.gallery-row {
  display: flex;
  align-items: center;
  justify-content: center;
}

.usr-img img{
    width: 40px;
    border-radius: 50%;
}

.contact-button {
    padding:0.3em 1.2em;
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#ffffff;
    color:black;
    width: 75%;
    cursor: pointer;
}

.add-review-button {
    padding:0.3em 1.2em;
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#ffffff;
    color:black;
    width: 75%;
    cursor: pointer;
}
</style>

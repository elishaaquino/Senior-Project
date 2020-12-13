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
                    <router-link :to="{ name: 'storepage', params: { storename: seller_firstName+seller_lastName } }">
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

export default {
    name: "Display-Item",
    components: {
    Review
    },
    data: () => {
        return {
            id: "5fd6721cccc4cb3796fc7227", //item id
            seller_firstName: "Monica",
            seller_lastName: "Andres",
            itemName: 'Oreo Brownies',
            price: '$12',
            amount: '12 pieces',
            allergens: "Peanuts, milk, eggs",
            diet: "Gluten-free",
            images: [
                "https://i2.wp.com/www.sugarspunrun.com/wp-content/uploads/2018/04/Easy-Oreo-Brownie-Recipe-1-of-1-3.jpg",
                "https://i2.wp.com/www.sugarspunrun.com/wp-content/uploads/2018/04/Easy-Oreo-Brownie-Recipe-1-of-1-7.jpg",
                "https://i2.wp.com/www.sugarspunrun.com/wp-content/uploads/2018/04/Easy-Oreo-Brownie-Recipe-1-of-1-10.jpg",
                "https://i2.wp.com/www.sugarspunrun.com/wp-content/uploads/2018/04/Easy-Oreo-Brownie-Recipe-1-of-1-5.jpg",
                "https://confessionsofabakingqueen.com/wp-content/uploads/2020/07/oreo-brownies-on-a-black-wire-rack-on-a-grey-surfac-1-of-1.jpg"
            ],
            reviews: [
                { id: 1, username: "Maggie Chang", date: "11/11/20", content: "Yummy!", img: "profilePicture.jpg" },
                { id: 2, username: "Monica Andres", date: "11/12/20", content: "I'm allergic :(", img: "profilePicture.jpg" },
                { id: 3, username: "Elisha Aquino", date: "11/14/20", content: "Delicious!", img: "profilePicture.jpg" }
            ]
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
        }
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

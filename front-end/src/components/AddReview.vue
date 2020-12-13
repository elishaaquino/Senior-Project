<template>

    <div class="add-item">
        <strong><h2 class="add-item-header">Add Review for {{ itemName }} made by {{ seller }}</h2></strong>

        <!-- form -->
        <form 
            class="form1" 
            @submit.prevent="addReview"
        >

            <!-- error checking -->
            <p v-if="errors.length">
                <b>Please correct the following error:</b>
                <ul>
                <li v-for="(error, index) in errors" :key="index">{{ error }}</li>
                </ul>
            </p>

            <!-- required fields -->
            <label for="review">Review</label>
            <textarea class="input-response-review field" id="review" v-model="review" rows="5"/>

            <b-button class="add-item-button" @click="addReview()">+ Add Review</b-button>

        </form>

    </div>

</template>

<script>
import http from "../http-common";

export default {
    name: "Add-Item",
    data() {

       return {
            errors: [],
            review: '',
            id: "",
            itemName: "",
            seller_firstName: ""
       }

    },
    created() {
        this.itemName = localStorage.itemname;
        this.seller = localStorage.sellerfirstname;
        this.id = this.$route.params.id;
    },
    methods: {
       
        // upon add review submission
       addReview: function(e) {

           // checks if all required input fields are filled in
           if (this.review) {
                let review = {"username": JSON.parse(localStorage.user)["username"], "review": this.review};
                let id = this.id;

                Promise.all([
                  this.addReviewToItem(id, review),
                  this.addReviewToUser(id)
                ]).then((resps) => console.log(resps)).then(this.$router.push('/addreviewsuccess'));
                //http.put('/users/addReview/'+id);
                //http.post("reviews", review).then(this.$router.push('/addreviewsuccess'));
                //http.put("/itemReviews/"+id, review);
            }
            else {
                this.errors = [];

                if (!this.review) {
                    this.errors.push('Review required');
                }

                e.preventDefault();
            }
        },
        addReviewToItem(id, review) {
          return http.put("/itemReviews/"+id, review);
        },
        addReviewToUser(id) {
          return http.put('/users/addReview/'+id);
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

.add-item-button {
    padding:0.3em 1.2em;
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#000000;
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

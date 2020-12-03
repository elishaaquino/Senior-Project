<template>

    <div class="add-item">
        <strong><h2 class="add-item-header">Add Review for {{ itemName }} by {{ seller }}.</h2></strong>

        <!-- form -->
        <form 
            class="form1" 
            @submit.prevent="createNewItem"
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

            <b-button class="add-item-button" href="addreviewsuccess">+ Add Review</b-button>

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
            itemName: "",
            seller: ""
       }
    },
    created() {
        this.itemName = this.$route.params.itemName;
        this.seller = this.$route.params.seller;
    },
    methods: {
       
        // upon submission
       createNewItem: function(e) {

           // checks if all required input fields are filled in
           if (this.review) {
               let review = {"username": "delishas", "review": this.review};
               http.post("reviews", review).then(resp => console.log(resp));
            }
            else {
                this.errors = [];

                if (!this.review) {
                    this.errors.push('Review required');
                }

                e.preventDefault();
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

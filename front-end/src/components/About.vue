<template>
  <div>
    <!-- Header -->
    <header id="header" class="header">
        <div class="header-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-container">
                            <h1>Hungry for home cooked food?</h1>
                            <b-form @submit.prevent="searchResults()">
                                <b-button  class="search-button" size="sm" @click="searchResults()"><b-icon icon="search" variant="danger"></b-icon></b-button>
                                <input class="search" type="text" placeholder="Search.." name="search" v-model="search"/>
                            </b-form>
                            <p class="p-heading p-large"><strong>Suggested: </strong>pasta, brownies, kimchi</p>
                        </div>
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of header-content -->
    </header> <!-- end of header -->
    <!-- end of header -->

    <!-- Team -->
    <div class="basic-2">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Popular Items</h2>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
            <div class="row">
                <div class="col-lg-12">

                    <!-- Popular Items -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="results/brownies"><img class="img-fluid" src="../../public/images/popular-Item1.png" alt="brownies"></a>
                        </div> <!-- end of image-wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                    <!-- popular-item -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="results/noodles"><img class="img-fluid" src="../../public/images/popular-Item2.png" alt="noodles"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-item -->

                    <!-- popular-item -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="results/bread"><img class="img-fluid" src="../../public/images/popular-Item3.png" alt="bread"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                    <!-- popular-items -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="results/curry"><img class="img-fluid" src="../../public/images/popular-Item4.png" alt="curry"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of basic-2 -->
    <!-- end of popular items -->

    <div id="whoWeAre" class="cards-2">
        <div class="container" style="max-width: 540px;">
            <div class="row">
                <div class="col-lg-12">
                    <!-- Card -->
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">WHO ARE WE?</h3>
                            <p>NearBites is a platform for community members to buy local homemade foods and sell their tasty creations. Whether you're looking for the perfect homemade gift or hoping to satisfy your cravings, NearBites builds a sense of community and trust amongst local homebakers and chefs.</p>
                        </div>
                    </div>
                    <!-- end of card -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of cards-2 -->
    <!-- end of whoWeAre -->

  </div>
</template>

<script>
export default {
  name: 'About',
  data() {
     return {
        search: ''
     }
  },
  methods: {
     searchResults() {
        if (this.search === '')
            this.search = 'f438fh89w2rji2gjr03gj8430gh30hg430';
        this.$router.push({ name: "results", params: {keyword:this.search}});
        this.$store.commit("isSearching", this.search);
     }
  }
}
</script>

<style lang="scss">
.header {
    background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.5)), url('../../public/images/header-background.jpg') center center no-repeat;
    background-size: cover;
    margin-left: none;
    margin-right: none;
    padding-left: none;
    padding-right: none;
    max-width: none;
}

.header .header-content {
	padding-top: 10rem;
	padding-bottom: 10rem;
	text-align: center;
}

.header h1 {
	margin-bottom: 1rem;
    color: #FCF5F3;
    font-family: "Anton";
}

.header .p-large {
	margin-top: .5rem;
    color: #B3A89B;
}

.cards-2 {
	padding-top: 2rem;	
    background-color: #ECEDEA;
}

.cards-2 .card {
	border: none;
}

.cards-2 .card-body {
	padding: 2rem 2rem 2rem 2rem;
	background-color:#ECEDEA;
}

.cards-2 h3 {
    font-family: "Anton";
}

.cards-2 p {
    font-family: 'Barlow Condensed', sans-serif;
}

.cards-2 .container {
	max-width: 540px;
}

.basic-2 {
    margin-top: 50px;
}

.basic-2 h2 {
    margin-bottom: 2rem;
    color: #000000;
    font-family: "Anton";
}

.basic-2 a {
    color: #EADFCD;
}

.basic-2 .popular-items {
	display: inline-block;
	max-width: 13rem;
	margin-right: 1.5rem;
	margin-bottom: 3.5rem;
	margin-left: 1.5rem;
}

/* Hover Animation */
.basic-2 .image-wrapper {
	margin-bottom: 1.5rem;
}

.basic-2 .image-wrapper img {
	margin: 0;
	transition: all 0.3s;
}

.basic-2 .image-wrapper:hover img {
	-moz-transform: scale(1.15);
	-webkit-transform: scale(1.15);
	transform: scale(1.15);
} 
/* end of hover animation */

.basic-2 .popular-items .p-large {
    margin-bottom: 0.25rem;
}

.search {
    display: inline-block;
    width: 300px;
    vertical-align: middle;
    border: 0px;
    border-radius: 0 .25rem .25rem 0;
    height: 3.5em;
    padding-left: 8px;
}

.search-button {
    vertical-align: middle;
    height: 4em;
    background-color: white;
    border: none;
    border-radius: .25rem 0 0 .25rem;
    padding-left: 25px;
}

</style>
<template>
  <div>
    <!-- Header -->
    <header id="header" class="header">
        <div class="header-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-container">
                            <h1>FEELING HUNGRY FOR</h1>
                            <h1>HOME COOKED FOOD?</h1>
                            <b-form @submit.prevent="searchResults()">
                              <input class="search" type="text" placeholder="Search.." name="search" 
                                 v-model="search"/>
                              <b-button  class="search-button" size="sm" @click="searchResults()"><b-icon icon="search"></b-icon></b-button>
                            </b-form>
                            <p class="p-heading p-large"><strong>Suggested: </strong>pasta, brownies, kimchi</p>
                        </div>
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of header-content -->
    </header> <!-- end of header -->
    <!-- end of header -->

    <div id="whoWeAre" class="cards-2">
        <div class="container" style="max-width: 540px;">
            <div class="row">
                <div class="col-lg-12">
                    <!-- Card -->
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">WHO ARE WE?</h3>
                            <p>Description of NearBites HERE! Shamalamadingdong for God so loved the world that He gave His only begotten son so that whoever believed in him shall have everlasting life.</p>
                        </div>
                    </div>
                    <!-- end of card -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of cards-2 -->
    <!-- end of whoWeAre -->

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
                            <a href="results"><img class="img-fluid" src="../../public/images/popular-Item1.png" alt="brownies"></a>
                        </div> <!-- end of image-wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                    <!-- popular-item -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="displayitem"><img class="img-fluid" src="../../public/images/popular-Item2.png" href="#users" alt="noodles"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-item -->

                    <!-- popular-item -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="users"><img class="img-fluid" src="../../public/images/popular-Item3.png" href="#users" alt="bread"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                    <!-- popular-items -->
                    <div class="popular-items">
                        <div class="image-wrapper">
                            <a href="users"><img class="img-fluid" src="../../public/images/popular-Item4.png" href="#users" alt="curry"></a>
                        </div> <!-- end of image wrapper -->
                    </div> <!-- end of popular-items -->
                    <!-- end of popular-items -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of basic-2 -->
    <!-- end of popular items -->
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
	padding-top: 8rem;
	padding-bottom: 2.125rem;
	text-align: center;
}

.header .text-container {
	margin-bottom: 3rem;
}

.header h1 {
	margin-bottom: 0.5rem;
	color: #fff;
}

.header .p-large {
	margin-bottom: 2rem;
	color: #dfe5ec;
}

.header .btn-solid-lg {
	margin-right: 0.5rem;
	margin-bottom: 1.25rem;
}

.cards-2 {
	padding-top: 2rem;	
	padding-bottom: 1.25rem;	
	background-color: #fbfbfb;
}

.cards-2 .section-title {
	margin-bottom: 0.5rem;
	text-align: center;
}

.cards-2 .card {
	margin-bottom: 1.25rem;
	border: none;
	background-color: transparent;
}

.cards-2 .card-body {
	padding: 2rem 2rem 2rem 2rem;
	border: 1px solid #ebe8e8;
	border-bottom-left-radius: 0.375rem;
	border-bottom-right-radius: 0.375rem;
	background-color: #fff;
}

.cards-2 h3 {
	margin-bottom: 0.75rem;
	text-align: center;
}

.cards-2 .container {
	max-width: 540px;
}

.basic-2 {
	background-color: #fbfbfb;
}

.basic-2 h2 {
	margin-bottom: 0.75rem;
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
	overflow: hidden;
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
   border: 1px solid #bdbdbd;
   border-top-left-radius: 0.25rem;
   border-bottom-left-radius: 0.25rem;
   height: 1.9em;
   padding-left: 8px;
}

.search-button {
   vertical-align: middle;
}

</style>
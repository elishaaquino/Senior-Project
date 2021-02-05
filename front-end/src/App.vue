<template>
  <div id = "app">
      <b-navbar class="navbar navbar-expand" :sticky="true">
         <router-link to="/" class="navbar-brand"><span class="text-danger">NearBites</span></router-link>

         <b-navbar-nav class="ml-auto">
            <b-nav-form  class="navsearch" v-if="this.$route.name !== 'about'" @submit.prevent="searchResults">
               <b-button type="submit" class="search-button"><b-icon icon="search" variant="danger" size="sm" class="my-2 my-sm-0"></b-icon></b-button>
               <b-form-input size="sm" class="mr-sm-2" type="text" v-model="search" placeholder="search"></b-form-input>
            </b-nav-form>

            <b-nav-item v-if="isLoggedIn" @click=profile()><span class="text-danger">PROFILE</span></b-nav-item>
            <b-nav-item v-if="isLoggedIn" @click="logOut()"><span class="text-danger">SIGN OUT</span></b-nav-item>
            
            <b-nav-item to="/signIn" v-else>Sign In</b-nav-item>
         </b-navbar-nav>
      </b-navbar>

      <div>
         <router-view />
      </div>

      <!-- Footer -->
      <mdb-footer color="stylish-color-dark" class="footer font-small pt-4 mt-4">
         <mdb-container class="text-center text-md-left">
            <mdb-row class="text-center text-md-left mt-3 pb-3">
            <mdb-col md="3" lg="3" xl="3" class="mx-auto mt-3">
               <h6 class="text-uppercase mb-4 font-weight-bold">NEARBITES</h6>
               <p>Here you can make and order fresh food made with love, from your community, for you.</p>
               <img src="https://img.icons8.com/metro/26/000000/like.png"/><img src="https://img.icons8.com/windows/32/000000/kawaii-bread-1.png"/>
            </mdb-col>
            <hr class="w-100 clearfix d-md-none" />
            <mdb-col md="2" lg="2" xl="2" class="mx-auto mt-3">
            </mdb-col>
            <hr class="w-100 clearfix d-md-none" />
            <mdb-col md="3" lg="2" xl="2" class="mx-auto mt-3">
               <h6 class="text-uppercase mb-4 font-weight-bold">Site links</h6>
               <p><a href="/">HOME </a></p>
               <p><a :href="accountname">YOUR ACCOUNT</a></p>
               <p><a href="#!">MESSAGES</a></p>
            </mdb-col>
            <hr class="w-100 clearfix d-md-none" />
            <mdb-col md="4" lg="3" xl="3" class="mx-auto mt-3">
               <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
               <p><i class=""><img src="https://img.icons8.com/material-sharp/24/000000/worldwide-location.png"/></i> San Luis Obispo, CA, US</p>
               <p><i class=""><img src="https://img.icons8.com/material-rounded/24/000000/cursor.png"/></i> Cal Poly Website</p>
            </mdb-col>
            </mdb-row>
            <hr />
            <mdb-row class="d-flex align-items-center">
            <mdb-col md="8" lg="8">
               <p class="text-center text-md-left grey-text">&copy; 2021 Copyright</p>
            </mdb-col>
            </mdb-row>
         </mdb-container>
      </mdb-footer>
      <!-- Footer -->
  </div>
</template>

<script>
import { mdbFooter, mdbContainer, mdbRow, mdbCol } from 'mdbvue';

export default {
   name: "app",
   data () {
      return {
         search: "",
         accountname: "/userAccount/",
      }
   },
   components: {
      mdbFooter,
      mdbContainer,
      mdbRow,
      mdbCol
    },
   computed: {
      isLoggedIn() {
         return this.$store.state.auth.status.loggedIn;
      },
      isSearching() {
         return this.$store.state.search;
      }
   },
   created: function () {
      this.accountname += JSON.parse(localStorage.user)["username"];
   },
   methods: {
      profile() {
         this.$router.push('/userAccount/' + JSON.parse(localStorage.user)["username"]);
      },
      logOut() {
         this.$store.dispatch('auth/logout');
         this.$router.push('/signin');
         sessionStorage.clear();
      },
      searchResults() {
         this.$store.commit("isSearching", this.search);
         if (this.search === '')
            this.search = 'f438fh89w2rji2gjr03gj8430gh30hg430';
         this.$router.push({ name: "about" });
         this.$router.push({ name: "results", params: {keyword:this.search}});
         this.search="";
      }
   }
}
</script>

<style lang="scss">
   .navbar {
      background: rgba(255,255,255,0.5);
      font-family: "Anton";
   }

   .navbar-brand {
      padding-left: 30px;
   }

   .nav-item {
      padding-right: 30px;
   }

   .search-button {
      background-color: white;
      height: 2em;
   }   

   a:link, a:visited {
      color: black;
      text-decoration: none;
   }

   a:hover, a:active {
   background-color: white;
   text-decoration: none;
   }

   .footer {
      background-color: #FCF5F3;
   }
</style>
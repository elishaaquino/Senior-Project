<template>
  <div id = "app">
      <b-navbar class="navbar navbar-expand" :sticky="true">
         <router-link to="/" class="navbar-brand"><span class="text-danger">NearBites</span></router-link>
         <div class="navbar-nav mr-auto">
            <li class="nav-item">
               <router-link to="/users" class="nav-link">USERS</router-link>
            </li>
         </div>

         <b-navbar-nav class="ml-auto">
            <b-nav-form class="navsearch" v-if="this.$route.name !== 'about'">
               <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="search"
                  @submit.prevent="searchResults()"></b-form-input>
               <b-button size="sm" class="my-2 my-sm-0" type="submit"
                  @click="searchResults()">Search</b-button>
            </b-nav-form>

            <b-nav-item v-if="isLoggedIn" @click=profile()><span class="text-danger">PROFILE</span></b-nav-item>
            <b-nav-item v-if="isLoggedIn" @click="logOut()"><span class="text-danger">SIGN OUT</span></b-nav-item>
            
            <b-nav-item to="/signIn" v-else>Sign In</b-nav-item>
         </b-navbar-nav>
      </b-navbar>

      <div>
         <router-view />
      </div>
  </div>
</template>

<script>
export default {
   name: "app",
   data () {
      return {
         search: ''
      }
   },
   computed: {
      isLoggedIn() {return this.$store.state.auth.status.loggedIn;}
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
         if (this.search === '')
            this.search = 'f438fh89w2rji2gjr03gj8430gh30hg430';
         this.$router.push({ name: "results", params: {keyword:this.search}});
      }
   }
}
</script>

<style lang="scss">
.sign-in {
   justify-content: right;
   flex: 1;
}

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

</style>
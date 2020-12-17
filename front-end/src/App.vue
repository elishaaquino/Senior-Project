<template>
  <div id = "app">
      <b-navbar class="navbar navbar-expand">
         <router-link to="/" class="navbar-brand">NearBites</router-link>
         <div class="navbar-nav mr-auto">
            <li class="nav-item">
            <router-link to="/users" class="nav-link">Users</router-link>
            </li>
         </div>

         <b-navbar-nav class="ml-auto">
            <b-nav-form v-if="this.$route.name !== 'about'">
               <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="search"
                  @submit.prevent="searchResults()"></b-form-input>
               <b-button size="sm" class="my-2 my-sm-0" type="submit"
                  @click="searchResults()">Search</b-button>
            </b-nav-form>

            <b-nav-item-dropdown right v-if="isLoggedIn">
               <template #button-content>
                  <em>User</em>
               </template>
               <b-dropdown-item @click=profile()>Profile</b-dropdown-item>
               <b-dropdown-item @click="logOut()">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
            
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
         this.$router.replace({ name: "results", params: {keyword:this.search}});
      }
   }
}
</script>

<style scoped>
.sign-in {
   justify-content: right;
   flex: 1;
}

.navbar {
   background: rgba(255,255,255);
}
</style>
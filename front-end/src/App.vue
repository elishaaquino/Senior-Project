<template>
  <div id = "app">
      <b-navbar class="navbar navbar-expand navbar-dark bg-dark">
         <router-link to="/" class="navbar-brand">NearBites</router-link>
         <div class="navbar-nav mr-auto">
            <li class="nav-item">
            <router-link to="/users" class="nav-link">Users</router-link>
            </li>
         </div>

         <b-navbar-nav class="ml-auto">
            <b-nav-form v-if="this.$route.name !== 'about'">
               <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
               <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
            </b-nav-form>

            <b-nav-item-dropdown right v-if="isLoggedIn">
               <template #button-content>
                  <em>User</em>
               </template>
               <b-dropdown-item href="#">Profile</b-dropdown-item>
               <b-dropdown-item href="#">Sign Out</b-dropdown-item>
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
   computed: {
      isLoggedIn: function() {return false}
   }
}
</script>

<style scoped>
.sign-in {
   justify-content: right;
   flex: 1;
}
</style>
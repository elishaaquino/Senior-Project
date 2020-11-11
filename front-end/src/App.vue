<template>
  <div id = "app">
      <nav class="navbar navbar-expand navbar-dark bg-dark">
         <router-link to="/" class="navbar-brand">NearBites</router-link>
         <div class="navbar-nav mr-auto">
            <li class="nav-item">
            <router-link to="/users" class="nav-link">Users</router-link>
            </li>
            <li class="nav-item">
            <router-link to="/" class="nav-link">Sign In</router-link>
            </li>
         </div>
      </nav>

      <div>
         <router-view />
      </div>
  </div>
</template>

<script>
export default {
   name: "app"
}
</script>

<style lang="scss">
</style>
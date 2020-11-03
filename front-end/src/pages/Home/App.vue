<template>
  <div class="container">
    <h3>All Users</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" v-bind:key="user.id">
            <td>{{user.id}}</td>
            <td>{{user.username}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import UserDataService from '../../service/UserDataService';
export default {
  name: "UsersList",
  data() {
    return {
      users: [],
      message: null,
    };
  },
  methods: {
    refreshUsers() {
      UserDataService.retrieveAllUsers() //HARDCODED
        .then(response => {
          this.users = response.data;
        });
    }
  },
  created() {
    this.refreshUsers();
  }
};
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
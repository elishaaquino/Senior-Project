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
      <S3ImageUpload />
    </div>
  </div>
</template>

<script>
import UserDataService from '../service/UserDataService';
import S3ImageUpload from './S3ImageUpload';
export default {
  name: 'UserList',
  components: {
     S3ImageUpload
  },
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

</style>
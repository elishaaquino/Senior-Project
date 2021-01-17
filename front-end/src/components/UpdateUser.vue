<template>
    <div class="update-user">
        <strong><h2 class="update-user-header">Edit Your Profile.</h2></strong>

        <!-- form -->
        <form 
            class="form1" 
            @submit.prevent="updateUser"
        >

            <label for="first-name">First Name</label>
            <input type="text" class="input-response field" id="first-name" v-model="firstName"/>

            <label for="last-name">Last Name</label>
            <input class="input-response field" id="last-name" v-model="lastName"/>

            <label for="phone-number">Phone Number</label>
            <input class="input-response field" id="phone-number" v-model="phoneNumber"/>

            <label for="email">Email</label>
            <input class="input-response field" id="email" v-model="email"/>

            <label for="insta-handle">Instagram Handle</label>
            <input class="input-response field" id="insta-handle" v-model="instaHandle"/>

            <label for="facebook-url">Facebook URL</label>
            <input class="input-response field" id="facebook-url" v-model="facebookUrl"/>

            <button class="updateProfile">Update Profile</button>

        </form>
    </div>
</template>

<script>
import UserDataService from '../service/UserDataService';

export default {
   name: "Edit-Item",
   data() {
       return {
           firstName: '',
           lastName: '',
           phoneNumber: '',
           email: '',
           instaHandle: '',
           facebookUrl: '',
       }
   },
   methods: {
        //upon submission
        updateUser: function() { 
            let resp = {
                id: JSON.parse(localStorage.user)["id"],
                firstName: this.firstName,
                lastName: this.lastName,
                contact: {
                    phoneNumber: this.phoneNumber,
                    email: this.email,
                    instagramHandle: this.instaHandle,
                    facebookUrl: this.facebookUrl
                }
            }
            UserDataService.updateUser(resp).then(this.$router.push('/userAccount/' + JSON.parse(localStorage.user)["username"]));
        },
        getUserInfo() {
            UserDataService.getUser(this.$route.params.id).then(resp => {
                let res = resp.data;
                this.firstName = res.firstName;
                this.lastName = res.lastName;
                this.phoneNumber = res.contact.phoneNumber;
                this.email = res.contact.email;
                this.instaHandle = res.contact.instagramHandle;
                this.facebookUrl = res.contact.facebookUrl; 
            });
        }
   },
   created() {
      this.getUserInfo();
   }
};
</script>

<style scoped>
.update-user-header {
    text-align: center;
    padding: 5% 0% 1% 0%;
}

.form1 {
    display: flex;
    flex-direction: column;
    padding: 0% 30% 5% 30%;
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

.updateProfile {
    padding:0.3em 1.2em;
    margin:0 0.3em 0.3em 0;
    border-radius:2em;
    box-sizing: border-box;
    text-decoration:none;
    font-weight:300;
    color:#000000;
    background-color:#D25B3E;
    text-align:center;
    transition: all 0.2s;
    border: none;
    font-family: 'Archivo Black', sans-serif;
    color: white;
}

</style>

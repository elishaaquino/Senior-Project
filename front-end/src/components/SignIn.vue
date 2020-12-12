<template>
   <div class="main">
    <p class="sign" align="center">Sign In</p>
    <b-form class="form1">
        <p class="fieldName">Username</p>
        <input class="field" name="username" type="text" align="center" placeholder="Username" v-model="username">
        <p class="fieldName">Password</p>
        <input class="field" type="password" align="center" placeholder="Password" v-model="password">

      <!-- the parameter after userAccount will be the userUsername parameter so that the user is taken to their user profile -->
      <b-button class="submit" @click="signIn()">Sign In</b-button>
      <div class="signup">
        <h6><strong>Don't have an account? </strong></h6> <a href="/signUp">Sign Up</a>
      </div>
    </b-form>
    </div>
</template>

<script>
import AuthService from '../service/AuthenticationService';

export default {
   name: "signIn",
   data() {
      return {
         username: '',
         password: ''
      }
   },
   methods: {
      signIn() { 
          var data = {username: this.username, password: this.password};
          
         AuthService.login(data)
            .then(this.$router.push('/userAccount/'+this.username));
      }
   }
}
</script>

<style scoped>
div.signup{
    margin-left: 20%;
    margin-top: 5%;
}
h6, a {
    display: inline;
}
.fieldName {
    padding-left: 3rem;
    margin-bottom: 0.25rem;
}
.main {
    background-color: #FFFFFF;
    width: 400px;
    height: 400px;
    margin: 7em auto;
    border-radius: 1.5em;
    box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.sign {
    padding-top: 40px;
    color: #000000;
    font-size: 23px;
}

.field {
    width: 76%;
    color: rgb(38, 50, 56);
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border: none;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-left: 46px;
    margin-bottom: 27px;
}

form.form1 {
    padding-top: 20px;
}

.un:focus, .pass:focus {
    border: 2px solid rgba(0, 0, 0, 0.18) !important;
}

.submit {
    padding:0.3em 1.2em;
    margin-left: 38%;
    border-radius:2em;
    box-sizing: border-box;
    text-decoration:none;
    font-weight:300;
    color:#000000;
    background-color:#ffffff;
    text-align:center;
    transition: all 0.2s;
    width: 25%;
}
</style>
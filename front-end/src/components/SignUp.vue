<template>
   <div class="main">
    <p class="sign" align="center">Sign Up</p>
    <form class="row justify-content-center form1">
        <p class="fieldName">Username <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="Username" v-model="username">

        <p class="fieldName">Password <span style="color: #FF0000;">*</span></p>
        <input class="field" type="password" align="center" placeholder="Password" v-model="password">

        <p class="fieldName">First Name <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="First Name" v-model="firstName">

        <p class="fieldName">Last Name <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="Last Name" v-model="lastName">

        <p class="fieldName">Email <span style="color: #FF0000;">*</span></p>
        <input class="field" type="email" align="center" placeholder="example@gmail.com" v-model="email">

        <p class="fieldName">Phone</p>
        <input class="field" type="text" align="center" placeholder="123-555-1234" v-model="number">

        <p class="fieldName">City</p>
        <input class="field" type="text" align="center" placeholder="City">

        <p class="fieldName">State</p>
        <select class="field" placeholder="State">
            <option value="None">Select State</option>
            <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="DC">District Of Columbia</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH">Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
        </select>

        <p class="fieldName">Instagram Handle</p>
        <input class="field" type="text" align="center" placeholder="@example" v-model="igHandle">

        <p class="fieldName">Facebook URL</p>
        <input class="field" type="text" align="center" placeholder="www.facebook.com/username/" v-model="fbUrl">
        
        <p class="fieldName">Profile Name</p>
        <input class="field" type="text" align="center" placeholder="Bake n Shake">

        <p class="fieldName">Profile Description</p>
        <textarea style="resize: none;" class="field" type="text" align="center" rows="5" placeholder="My store is centered around selling delicious brownies."></textarea>
         
         <div class="img-upload-div">
                <label class="img-upload field"><input type="file" @change="onFileChange($event.target.files)"/>+ Add profile picture</label>
         </div>
         <div class="display-img">
               <img class="img-box" :src="img"/>
         </div>

        <b-button class="submit" align="center" @click="signUp()">Sign up</b-button>
    </form>
    </div>
</template>

<script>
import http from "../http-common";

export default {
   name: "signUp",
   data() {
      return {
         username: '',
         password: '',
         firstName: '',
         lastName: '',
         email: '',
         number: '',
         igHandle: '',
         fbUrl: '',
         file: '',
         img: ''
      }
   },
   methods: {
      onFileChange(files) {
         this.file = files[0];
         this.img = URL.createObjectURL(files[0]);
         console.log(this.file)
      },
      signUp() {
         let userInfo = {
            username: this.username,
            password: this.password,
            firstName: this.firstName,
            lastName: this.lastName,
            contact: {
               phoneNumber: this.number,
               email: this.email,
               instagramHandle: this.igHandle,
               facebookUrl: this.fbUrl
            },
            imageUrl: ''
         }
         
         const formData = new FormData();
         formData.append("photos", this.file);
         http.post("storage/uploadImages",formData)
            .then(resp => userInfo.imageUrl = resp.data[0])
            .then(() => {
               this.$store.dispatch('auth/register', userInfo).then(
                  () => {
                     this.$store.dispatch('auth/login', {username: this.username, password: this.password}).then(
                        () => {
                           this.$router.push('/onboarding');
                           },
                        error => {
                     this.message =
                        (error.response && error.response.data) ||
                        error.message ||
                        error.toString();
                     }
               );
            },
            error => {
            this.message =
               (error.response && error.response.data) ||
               error.message ||
               error.toString();
            }
         )});
      }
   }
}
</script>

<style scoped>
.fieldName {
    padding-left: 0.25rem;
    margin-bottom: 0.25rem;
}

.main {
    background-color: #FFFFFF;
    width: 400px;
    margin: 3em auto;
    border-radius: 1.5em;
    box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
    display: flex;
    flex-direction: column;
}

.sign {
    padding-top: 40px;
    color: #000000;
    font-size: 23px;
}

.field {
    width: 80%;
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
    margin-bottom: 50px;
    margin-bottom: 27px;
}

form.form1 {
    padding-top: 40px;
    flex-direction: column;
    padding: 0% 0% 0% 18%;
    padding-bottom: 40px;
}

.un:focus, .pass:focus {
    border: 2px solid rgba(0, 0, 0, 0.18) !important;
}

.submit {
    padding:0.3em 1.2em;
    border-radius:2em;
    box-sizing: border-box;
    text-decoration:none;
    font-weight:300;
    color:#000000;
    background-color:#ffffff;
    text-align:center;
    transition: all 0.2s;
    width: 80%;
}

.img-upload-div {
    padding: 3% 0% 5% 0%;
}

input[type="file"] {
    display: none;
}

.img-upload {
    text-align: center;
    border-radius: 2em;
    width: 80%;
    cursor: pointer;
}

.img-upload:hover{
    background-color: grey;
}

.display-img {
    max-width:50%;
    max-height:50%;
    margin-bottom: 10px;
}
</style>
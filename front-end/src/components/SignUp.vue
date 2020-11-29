<template>
   <div class="main">
    <p class="sign" align="center">Sign Up</p>
    <form class="row justify-content-center form1">
        <p class="fieldName">Username <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="Username">

        <p class="fieldName">Password <span style="color: #FF0000;">*</span></p>
        <input class="field" type="password" align="center" placeholder="Password">

        <p class="fieldName">First Name <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="First Name">

        <p class="fieldName">Last Name <span style="color: #FF0000;">*</span></p>
        <input class="field" type="text" align="center" placeholder="Last Name">

        <p class="fieldName">Email <span style="color: #FF0000;">*</span></p>
        <input class="field" type="email" align="center" placeholder="example@gmail.com">

        <p class="fieldName">Phone</p>
        <input class="field" type="text" align="center" placeholder="123-555-1234">

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
        <input class="field" type="text" align="center" placeholder="@example">

        <p class="fieldName">Facebook URL</p>
        <input class="field" type="text" align="center" placeholder="www.facebook.com/username/">
        
        <p class="fieldName">Profile Name</p>
        <input class="field" type="text" align="center" placeholder="Bake n Shake">

        <p class="fieldName">Profile Description</p>
        <textarea style="resize: none;" class="field" type="text" align="center" rows="5" placeholder="My store is centered around selling delicious brownies."></textarea>

        <b-button class="submit" align="center">Sign up</b-button>
    </form>
    </div>
</template>

<script>
export default {
   name: "signUp"
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
    height: 1450px;
    margin: 3em auto;
    border-radius: 1.5em;
    box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
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
</style>
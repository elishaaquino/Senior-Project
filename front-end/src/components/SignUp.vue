<template>
   <div class="main">
    <p class="sign" align="center">Sign Up</p>
    <form class="row justify-content-center form1">
        <label><strong>Required</strong></label>
        <input class="field" type="text" align="center" placeholder="First Name">
        <input class="field" type="text" align="center" placeholder="Last Name">

        <input class="field" type="text" align="center" placeholder="City">
        <input class="field" type="text" align="center" placeholder="State">

        <label><strong>Contact</strong></label>
        <input class="field" type="email" align="center" placeholder="Email">
        <input class="field" type="text" align="center" placeholder="Phone">

        <label><strong>Social Media</strong></label>
        <input class="field" type="text" align="center" placeholder="Instagram Handle (Optional)">
        <input class="field" type="text" align="center" placeholder="Facebook URL (Optional)">

        <label><strong>Account Info</strong></label>
        <input class="field" type="text" align="center" placeholder="Username">
        <input class="field" type="password" align="center" placeholder="Password">
        <input class="field" type="text" align="center" placeholder="Store Name">
        <textarea class="field" type="text" align="center" rows="5" placeholder="Store Description"></textarea>
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
.main {
    background-color: #FFFFFF;
    width: 400px;
    height: 1250px;
    margin: 3em auto;
    border-radius: 1.5em;
    box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.sign {
    padding-top: 40px;
    color: #000000;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bold;
    font-size: 23px;
}

.field {
    width: 80%;
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
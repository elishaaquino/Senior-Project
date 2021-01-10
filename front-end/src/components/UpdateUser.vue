<template>
    <div class="update-user">
        <strong><h2 class="update-user-header">Edit Your Profile.</h2></strong>

        <!-- form -->
        <form 
            class="form1" 
        >

            <label for="first-name">First Name</label>
            <input type="text" class="input-response field" id="first-name" value=".domain.com"/>

            <label for="last-name">Last Name</label>
            <input class="input-response field" id="last-name" v-model="lastName"/>

            <label for="phone-number">Phone Number</label>
            <input class="input-response field" id="phone-number" v-model="phoneNumber"/>

            <label for="insta-handle">Instagram Handle</label>
            <input class="input-response field" id="insta-handle" v-model="instaHandle"/>

            <label for="facebook-url">Facebook URL</label>
            <input class="input-response field" id="facebook-url" v-model="facebookUrl"/>

            <button class="updateProfile">+ Update Profile</button>

        </form>
    </div>
</template>

<script>
</script>

<style scoped>
.update-user-header {
    text-align: center;
    padding: 5% 0% 1% 0%;
}

.form1 {
    display: flex;
    flex-direction: column;
    padding: 0% 30% 30% 30%;
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

.img-upload-div {
    padding: 3% 0% 5% 0%;
}

input[type="file"] {
    display: none;
}

.img-upload {
    text-align: center;
    border-radius: 2em;
    width: 100%;
    padding: 5%;
    cursor: pointer;
}

.img-upload-max {
    text-align: center;
    border: 1px solid #000000;
    border-radius: 2em;
    width: 100%;
    padding: 5%;
}

.img-upload:hover{
    background-color: grey;
}

.img-box {
    max-width:50%;
    max-height:50%;
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

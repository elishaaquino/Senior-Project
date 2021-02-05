<template>
    <div class="container">
            <div class="header row justify-content-md-center header-message">
                <h1><strong>Hooray! Your item has been added to your store.</strong></h1>
            </div>

            <div class="image row justify-content-md-center">
                <img src="https://img.icons8.com/ios-filled/100/000000/salt-bae.png"/>
            </div>

            <div class="row justify-content-md-center">
                <router-link class="back-button" :to="{ name: 'userAccount', params: { userUsername: username } }">Back to account page.</router-link>
            </div>
    </div>
</template>

<script>
export default {
    name: 'Add-Item_success',
    components: {},
        data () {
            return {
                username: ''
            }
        },
        created() {
            this.username = JSON.parse(localStorage.user)["username"];
        },
    };
</script>

<style scoped>
.header {
    padding:100px 0px 20px 50px;
}
.image {
    padding: 0px 50px 50px 50px;
}
.back-button {
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
.check {
    width: 15%;
    height: 15%;
    padding-top: 0.5em;
    padding-bottom: 1.5em;
}
</style>
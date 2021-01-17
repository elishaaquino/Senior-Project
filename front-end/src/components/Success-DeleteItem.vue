<template>
    <div class="container message">
            <div class="row justify-content-md-center header-message">
                <h1><strong>Your item has been permanently removed from your store.</strong></h1>
            </div>

            <div class="row justify-content-md-center">
                <img src="https://img.icons8.com/material-two-tone/96/000000/trash.png"/>
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
.message {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
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
.trash {
    width: 10%;
    height: auto;	
}

</style>
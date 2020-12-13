<template>
    <div class="container message">
            <div class="row justify-content-md-center header-message">
                <h1><strong>Hooray! Your review has been added.</strong></h1>
            </div>
            
            <div class="row justify-content-md-center">
                <div class="check">
                    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 130.2 130.2">
                        <circle class="path circle" fill="none" stroke="#73AF55" stroke-width="6" stroke-miterlimit="10" cx="65.1" cy="65.1" r="62.1"/>
                        <polyline class="path check" fill="none" stroke="#73AF55" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" points="100.2,40.2 51.5,88.8 29.8,67.5 "/>
                    </svg>
                </div>
            </div>
            
            <div class="row justify-content-md-center">
                <b-button class="back-button" href="/">Go home</b-button>
            </div>
    </div>
</template>

<script>
export default {
    name: "Add-Review-Success"
}
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
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#ffffff;
    color:black;
    width: 20%;
    cursor: pointer;
}
.check {
    width: 15%;
    height: 15%;
    padding-top: 0.5em;
    padding-bottom: 1.5em;
}
</style>
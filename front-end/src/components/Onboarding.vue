<template>
    <div>
        <div>
            <div id=wrapper><img id="image" src="https://images.squarespace-cdn.com/content/v1/5c5c3833840b161566b02a76/1573133725500-Y5PCN0V04I86HDAT8AT0/ke17ZwdGBToddI8pDm48kLkXF2pIyv_F2eUT9F60jBl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0iyqMbMesKd95J-X4EagrgU9L3Sa3U8cogeb0tjXbfawd0urKshkc5MgdBeJmALQKw/WBC_7095.jpg?format=2500w"/></div>
            <h1 id="text">Welcome to NearBites!</h1>
        </div>

    <!-- Services Section Start -->
        <section id="services" class="section">
        <div class="container" style="margin-bottom: 3rem;">
            <div class="section-header">          
                <center><h1 class="section-title" style="font-weight: bold;">What can you do?</h1></center>
                <br>
            </div>
            <div class="row">
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><h4>Buy Homemade Food</h4></center>
                <p>From sweet, to savory, and everything in between! Find something that you're craving.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><h4>Sell Your Homemade Food</h4></center>
                <p>Want to share your talents with community members? Share your homemade food with those around you!</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><h4>Write Reviews</h4></center>
                <p>Loving what you're eating? Leave a review to share with community members!</p>
                </div>
            </div>
            </div>
            <div class="row">
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><img src="https://img.icons8.com/ios/50/000000/bread.png"/></center>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><img src="https://img.icons8.com/ios/50/000000/shop.png"/></center>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-xs-12">
                <div>
                <center><img src="https://img.icons8.com/ios/50/000000/hand-with-pen.png"/></center>
                </div>
            </div>
            </div>
        </div>
        </section>
        <!-- Services Section End -->
        <div class="footer">
            <div class="row justify-content-md-center" style="margin-top: 3rem; margin-bottom: 8px; color:white;">
                <h2>Are you ready to get started?</h2>
            </div>
            <div class="row justify-content-md-center" style="margin-bottom: 3rem;">
                <router-link class="start-button" :to="{ name: 'about' }">Let's go!</router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Onboarding'
};
</script>

<style scoped>
div {
    overflow-x: hidden;
}
.start-button {
    padding:0.3em 1.2em;
    border: 2px solid #000000;
    border-radius:2em;
    background-color:#ffffff;
    color:black;
    width: 7.3%;
    cursor: pointer;
}
#wrapper {
    height: 20rem;
    overflow:hidden;
}
#image {
    top: 25; 
    left: 0; 
    min-width: 100%;
}
#text {
    z-index: 100;
    position: absolute;
    color: white;
    top: 13rem;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 60px;
}
#services {
    margin-top: 2rem;
}
.footer {
    background-color: #1a1a1a;
}
</style>
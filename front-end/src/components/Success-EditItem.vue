<template>
    <div class="container">
        <div class="header row justify-content-md-center header-message">
            <h1><strong>Your item has been edited.</strong></h1>
        </div>

        <div class="image row justify-content-md-center">
            <img src="https://img.icons8.com/windows/96/000000/edit--v3.png"/>
        </div>

        <div class="row justify-content-md-center">
            <router-link class="back-button" :to="{ name: 'displayitem', params: { id: id } }">Back to item page.</router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Add-Item_success',
    components: {},
        data () {
            return {
                username: '',
                id: ''
            }
        },
        created() {
            this.username = JSON.parse(localStorage.user)["username"];
            this.id = this.$route.params.id;
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
.trash {
    width: 10%;
    height: auto;	
}

</style>
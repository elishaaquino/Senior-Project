<template>
    <div class="container message">
            <div class="row justify-content-md-center header-message">
                <h1><strong>Hooray, you're review has been added.</strong></h1>
            </div>
            <div class="row justify-content-md-center">
                <button>Back to item page.</button>
            </div>
    </div>
</template>

<script>
export default {
    name: "Add-Item-Success"
}
</script>

<style scoped>
.message {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>
<template>
   <div>
      <h1>{{userUsername}}</h1>
   </div>
</template>

<script>
export default {
    name: 'userAccount',
        data () {
            return {
                userUsername: "poo"
            }
        },
        created() {
            this.userUsername = this.$route.params.userUsername;
        },
    };
</script>

<style scoped>
</style>
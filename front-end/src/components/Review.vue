<template>
    <div class="row review-card mb-4 align-items-center">

        <div class="col-1">
            <div class="usr-img">
                <img :src="require('@/assets/' + imgUrl + '')">
            </div>
        </div>

        <div class="col">
            <div class="content">
                {{ content }}
            </div>
            <div class="name">
                - {{ userName }}
            </div>
            <div class="date">
                {{ date }}
            </div>
        </div>

   </div>
</template>

<script>
export default {
    name: "Review",
    props: {
        userName: {
            type: String,
            required: true
        },
        date: {
            type: String,
            required: true
        },
        content: {
            type: String,
            required: true
        },
        imgUrl: {
            type: String,
            required: true
        }
  }
};
</script>

<style lang="scss" scoped>
    .usr-img img{
        width: 60px;
        border-radius: 50%;
    }
</style>
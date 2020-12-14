<template>
   <div class="item">
      <router-link :to="{ name: 'displayitem', params: { id: id } }">
      <div class="item-pic d-flex flex-column justify-space-between align-center">
         <img contain :src="photo" class="item-pic"/>
      </div>
      <div class="item-name">
         {{ itemName }}
      </div>
      <div class="item-info">
         ${{ price }} for {{ quantity }}
      </div>
      </router-link>
   </div>
</template>

<script>
export default {
  name: "Item",
  props: {
     id: {
      type: String,
      required: true
    },
    ownerId : {
      type: String,
      required: true
    },
    itemName: {
      type: String,
      required: true
    },
    price: {
      type: Number,
      required: true
    },
    quantity: {
      type: String,
      required: true
    },
    photo: {
       type: String,
       required: true
    }
  }
};
</script>

<style lang="scss" scoped>
.item {
   padding: 20px;
   background-color: white;
   border-radius: 5px;
   border: 1px solid #DFE3E8;
   box-sizing: border-box;
   cursor: pointer;
   transition: all 0.25s ease;
   &:hover {
      transform: scale(1.1, 1.1);
   }
   .item-name {
      color: black;
      font-weight: bold;
   }
   .item-info {
      color: black;
   }
   display: inline-block;
   width: 14rem;
	margin-right: 1.5rem;
	margin-bottom: 2.5rem;
	margin-left: 1.5rem;
   flex: 1 0 21%;
   .item-pic {
   max-width: 200px;
   max-height: 250px;
   }
}
</style>
<template>
   <div class="item">
      <div class="item-pic">
         <img :src="photo"/>
      </div>
      <div class="item-name">
         {{ itemName }}
      </div>
      <div class="item-info">
         ${{ price }} for {{ quantity }}
      </div>
   </div>
</template>

<script>
export default {
  name: "Item",
  props: {
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
      font-weight: bold;
   }
   display: inline-block;
   width: 14rem;
	margin-right: 1.5rem;
	margin-bottom: 2.5rem;
	margin-left: 1.5rem;
   flex: 1 0 21%;
}
</style>
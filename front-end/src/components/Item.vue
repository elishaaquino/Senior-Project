<template>
   <div class="item">
      <router-link :to="{ name: 'displayitem', params: { id: id} }">
         <div class="cards-list">
   
            <div class="card">
               <div class="card_image"> <img contain :src="photo" class="item-pic"/> </div>
               <div class="row">
                  <div class="col-4">
                     <div class="sellerImg"><img contain :src="sellerImg" class=""/></div>
                  </div>
                  <div class="col">
                     <div class="item-name">
                        {{ itemName }}
                     </div>
                     <div class="item-info">
                        ${{ price }} for {{ quantity }}

                     </div>
                     <div class="item-info">
                        By {{sellerName}}
                     </div>
                  </div>
               </div>
            </div>

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
    },
    sellerId: {
       type: String,
       required: true
    },
    sellerName: {
       type: String,
       required: true
    },
    sellerImg: {
       type: String,
       required: true
    }
  }
};
</script>

<style lang="scss" scoped>
.item {
   box-sizing: border-box;
   cursor: pointer;
   transition: all 0.25s ease;

   display: inline-block;
   width: 12rem;
	margin-right: 1.5rem;
	margin-bottom: 2.5rem;
	margin-left: 1.5rem;
   flex: 1 0 21%;

   .item-name {
      padding-top: 5px; 
      color: black;
      font-weight: bold;
      font-size: 14px;
   }

  .item-info {
      color: black;
      font-size: 13px;
   }

.cards-list {
  z-index: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.card {
  margin: 50px auto;
  width: 200px;
  height: 200px;
  border-radius: 60px;
  box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.25), 0px 0px 0px 0px rgba(0,0,0,0.22);
  cursor: pointer;
  transition: 0.1s;
}

.card .card_image {
  width: inherit;
  height: inherit;
  border-radius: 40px;
}

.card .card_image img {
  width: inherit;
  height: inherit;
  border-radius: 40px;
  object-fit: cover;
}

.card .sellerImg {
   padding: 10px;
  width: 50px;
  height: 50px;
  border-radius: 40px;
}

.card .sellerImg img {
  width: inherit;
  height: inherit;
  border-radius: 40px;
  object-fit: cover;
}

.card .card_title {
  text-align: center;
  border-radius: 0px 0px 40px 40px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 20px;
  margin-top: -80px;
  height: 40px;
}

.card:hover {
  transform: scale(0.9, 0.9);
  box-shadow: 60px rgba(0,0,0,0.25), 
    60px rgba(0,0,0,0.22);
}

@media all and (max-width: 500px) {
  .card-list {
    /* On small screens, we are no longer using row direction but column */
    flex-direction: column;
  }
}
}
</style>
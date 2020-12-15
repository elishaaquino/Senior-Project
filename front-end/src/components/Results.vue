<template>
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <Item 
               v-for="item in items" 
               :key="item.id"
               :id="item.id"
               :sellerId="item.sellerId"
               :itemName="item.itemName"
               :price="item.price"
               :quantity="item.quantity"
               :photo="item.photo"/>
         </div>
      </div>
   </div>
</template>

<script>
import Item from "./Item";
import ItemService from '../service/ItemService';

export default {
   name: "Results",
   components: {Item},
   data () {
      return {
         items: []
      }
   },
   methods: {
      getItems() {
         let keyword = this.$route.params.keyword;
         if (keyword === 'f438fh89w2rji2gjr03gj8430gh30hg430')
            ItemService.getAllItems().then(resp => {
               console.log(resp.data)
               resp.data.forEach(element => {
                  let item = {
                     id: element.id,
                     sellerId: element.ownerId,
                     itemName: element.name,
                     price: element.price,
                     quantity: element.quantity,
                     photo: element.photos[0]
                  }

                  this.items.push(item);
               });
            });
         else {
            ItemService.search(keyword).then(resp => {
               console.log(resp.data)
               resp.data.forEach(element => {
                  let item = {
                     id: element.id,
                     sellerId: element.ownerId,
                     itemName: element.name,
                     price: element.price,
                     quantity: element.quantity,
                     photo: element.photos[0]
                  }

                  this.items.push(item);
               });
            })
         }
      }
   },
   created() {
      this.getItems();
   }
}
</script>

<style scoped>
.container {
   display: flex;
   align-items: center;
}

.row {
   position: relative;
   margin-top: 50px;
   display: flex;
   flex-wrap: wrap;
}

</style>
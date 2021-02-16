<template>
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
               {{search}}
               <Item 
                  v-for="item in items" 
                  :key="item.id"
                  :id="item.id"
                  :sellerId="item.sellerId"
                  :itemName="item.itemName"
                  :price="item.price"
                  :quantity="item.quantity"
                  :photo="item.photo"
                  :sellerName="item.sellerName"
                  :sellerImg="item.sellerImg"/>
            <p v-if="items.length == 0"><strong>No results found :(</strong></p>
         </div>
      </div>
   </div>
</template>

<script>
import Item from "./Item";
import ItemService from '../service/ItemService';
import UserDataService from '../service/UserDataService';

export default {
   name: "Results",
   components: {Item},
   data () {
      return {
         items: [],
         keyword: "",
      }
   },
   methods: {
      getItems() {
         let keyword = this.$route.params.keyword;
         this.items = [];
         if (keyword === 'f438fh89w2rji2gjr03gj8430gh30hg430')
            ItemService.getAllItems().then(resp => {

               resp.data.forEach(element => {
                  let item = {
                     id: element.id,
                     sellerId: element.ownerId,
                     itemName: element.name,
                     price: element.price,
                     quantity: element.quantity,
                     photo: element.photos[0]
                  }

                  UserDataService.getUser(element.ownerId).then(resp => {
                     item.sellerName = resp.data.firstName + " " + resp.data.lastName;
                     item.sellerImg = resp.data.imageUrl;
                     this.items.push(item);
                  });
               });
            });
         else {
            ItemService.search(keyword).then(resp => {

               resp.data.forEach(element => {
                  let item = {
                     id: element.id,
                     sellerId: element.ownerId,
                     itemName: element.name,
                     price: element.price,
                     quantity: element.quantity,
                     photo: element.photos[0]
                  }

                  UserDataService.getUser(element.ownerId).then(resp => {
                     item.sellerName = resp.data.firstName + " " + resp.data.lastName;
                     item.sellerImg = resp.data.imageUrl;
                     this.items.push(item);
                  });

               });
            });
         }
      }
   },
   created() {
      this.keyword = this.$store.state.search;
   },
   computed: {
      search: function () {
         return this.getItems();
      }
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
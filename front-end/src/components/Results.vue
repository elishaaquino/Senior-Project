<template>
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <Item 
               v-for="item in items" 
               :key="item.id"
               :id="item.id"
               :itemName="item.itemName"
               :price="item.price"
               :quantity="item.quantity"/>
         </div>
      </div>
   </div>
</template>

<script>
import Item from "./Item";

export default {
   name: "Results",
   components: {Item},
   data () {
      return {
         items: [
            { id: "1", itemName: "Brownies", price: "$12", quantity: "1 dozen"}, 
            { id: "2", itemName: "Cookies", price: "$12", quantity: "1 dozen"},
            { id: "3", itemName: "Lemon Bar", price: "$12", quantity: "1 dozen"},
            { id: "4", itemName: "Brownies", price: "$12", quantity: "1 dozen"},
            { id: "5", itemName: "Fudge Brownies", price: "$12", quantity: "1 dozen"},
            { id: "6", itemName: "Pizookie", price: "$12", quantity: "1"},
            { id: "7", itemName: "Dulce de leche", price: "$12", quantity: "1 dozen"},
            { id: "8", itemName: "Ube Cookies", price: "$12", quantity: "1 dozen"},
         ]
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
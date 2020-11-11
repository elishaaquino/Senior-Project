<template>
   <div>
      <Item 
         v-for="item in items" 
         :key="item.id"
         :itemName="item.itemName"
         :price="item.price"
         :quantity="item.quantity"/>
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
            { id: 1, itemName: "Brownies", price: "$12", quantity: "1 dozen"}, 
            { id: 2, itemName: "Cookies", price: "$12", quantity: "1 dozen"},
            { id: 3, itemName: "Lemon Bar", price: "$12", quantity: "1 dozen"},
            { id: 4, itemName: "Brownies", price: "$12", quantity: "1 dozen"},
            { id: 5, itemName: "Fudge Brownies", price: "$12", quantity: "1 dozen"},
            { id: 6, itemName: "Pizookie", price: "$12", quantity: "1"},
            { id: 7, itemName: "Dulce de leche", price: "$12", quantity: "1 dozen"}
         ]
      }
   }
}
</script>

<style scoped>

</style>
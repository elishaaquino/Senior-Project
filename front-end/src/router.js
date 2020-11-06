import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
   mode: "history",
   routes: [
      {
         path: "/",
         alias: "/about",
         name: "about",
         component: () => import("./components/About")
      },
      {
         path: "/users",
         component: () => import("./components/UserList")
      }
   ]
});
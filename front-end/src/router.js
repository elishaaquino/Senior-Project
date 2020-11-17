import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
   mode: "history",
   routes: [
      {
         path: "/about",
         alias: "/",
         name: "about",
         component: () => import("./components/About")
      },
      {
         path: "/users",
         component: () => import("./components/UserList")
      },
      {
         path: "/results",
         component: () => import("./components/Results")
      },
      {
         path: "/userAccount",
         alias: "/userAccount",
         name: "userAccount",
         component: () => import("./components/UserAccount")
      },
      {
         path: "/additem",
         component: () => import("./components/AddItem")
      },
      {
         path: "/displayitem",
         component: () => import("./components/DisplayItem")
      }
   ]
});
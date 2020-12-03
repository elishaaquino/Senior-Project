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
         name: "results",
         component: () => import("./components/Results")
      },
      {
         path: "/userAccount/:userUsername",
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
      },
      {
         path: "/signIn",
         name: "signIn",
         component: () => import("./components/SignIn")
      },
      {
         path: "/signUp",
         name: "signUp",
         component: () => import("./components/SignUp")
      },
      {
         path: "/addreview",
         name: "addreview",
         component: () => import("./components/AddReview")
      },
      {
         path: "/store/:storename",
         name: "storepage",
         component: () => import("./components/StorePage")
      },
      {
         path: "/additemsuccess",
         name: "additemsuccess",
         component: () => import("./components/Success-AddItem")
      },
      {
         path: "/addreviewsuccess",
         name: "addreviewsuccess",
         component: () => import("./components/Success-AddReview")
      }
   ]
});
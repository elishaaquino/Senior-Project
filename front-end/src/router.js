import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export const router = new Router({
   mode: "history",
   routes: [
      {
         path: "/about",
         alias: "/",
         name: "about",
         component: () => import("./components/About")
      },
      {
         path: "/results/:keyword",
         name: "results",
         component: () => import("./components/Results")
      },
      {
         path: "/userAccount/:userUsername",
         name: "userAccount",
         component: () => import("./components/UserAccount")
      },
      {
         path: "/messages/:userUsername",
         name: "messages",
         component: () => import("./components/Messages")
      },
      {
         path: "/additem",
         component: () => import("./components/AddItem")
      },
      {
         path: "/editItem/:id",
         name: "editItem",
         component: () => import("./components/EditItem")
      },
      {
         path: "/displayitem/:id",
         name: "displayitem",
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
         path: "/updateUser/:id",
         name: "updateUser",
         component: () => import("./components/UpdateUser")
      },
      {
         path: "/addreview/:id",
         name: "addreview",
         component: () => import("./components/AddReview")
      },
      {
         path: "/store/:sellerId/:storename",
         name: "storepage",
         component: () => import("./components/StorePage")
      },
      {
         path: "/additemsuccess",
         name: "additemsuccess",
         component: () => import("./components/Success-AddItem")
      },
      {
         path: "/addreviewsuccess/:id",
         name: "addreviewsuccess",
         component: () => import("./components/Success-AddReview")
      },
      {
         path: "/deleteitemsuccess",
         name: "deleteitemsuccess",
         component: () => import("./components/Success-DeleteItem")
      },
      {
         path: "/edititemsuccess/:id",
         name: "edititemsuccess",
         component: () => import("./components/Success-EditItem")
      },
      {
         path: "/onboarding",
         name: "onboarding",
         component: () => import("./components/Onboarding")
      },
      {
         path:"/chat/:sellerId",
         name: "chat",
         component: () => import("./components/Chat")
      }
   ]
});

router.beforeEach((to, from, next) => {
   const publicPages = ['/signUp', '/signin', '/', '/displayitem'];
   const authRequired = !publicPages.includes(to.path) && 
      !(to.path).includes('/results') && !(to.path).includes('/displayitem')
      && !(to.path).includes('/store');
   const loggedIn = localStorage.getItem('user');

   // trying to access a restricted page + not logged in
   // redirect to login page
   if (authRequired && !loggedIn) {
     next('/signin');
   } else {
     next();
   }
 });
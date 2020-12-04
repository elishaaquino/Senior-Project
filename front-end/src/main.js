import Vue from 'vue';
import App from './App.vue';
import { router } from "./router";
import Lightbox from '@morioh/v-lightbox'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import '@morioh/v-lightbox/dist/lightbox.css';

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(Lightbox);

new Vue({
   router,
   render: h => h(App),
}).$mount('#app');
import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate'

import { auth } from './authModule';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    auth
  },
  plugins: [createPersistedState({
    storage: window.sessionStorage,
  })],
  state: {
    seller_photo: "",
    seller: ""
  },
  getters: {
    seller_photo: state => {
      return state.seller_photo
    },
    seller: state => {
      return state.seller
    }
  },
  mutations: {
    changeSellerPhoto (state, payload) {
      state.seller_photo = payload
    },
    changeSeller (state, payload) {
      state.seller = payload
    }
  },
  actions: {}
});
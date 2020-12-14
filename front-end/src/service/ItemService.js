import http from "../http-common";

class ItemService {

  additem(item) {    
    return http.post(`/items/additem`, item);
  }

  getItemUserAccount(ownerId) {
    return http.get(`/items/allItemsUserAccount?ownerId=` + ownerId);
  }

}

export default new ItemService();
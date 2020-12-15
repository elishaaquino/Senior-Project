import http from "../http-common";

class ItemService {

  additem(item) {    
    return http.post(`/items/additem`, item);
  }

  getItemUserAccount(ownerId) {
    return http.get(`/items/allItemsUserAccount?ownerId=` + ownerId);
  }

  getItemStorePage(sellerId) {
    return http.get(`/items/allItemsStorePage/` + sellerId)
  }
}

export default new ItemService();
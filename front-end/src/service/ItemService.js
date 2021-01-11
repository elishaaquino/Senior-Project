import http from "../http-common";

class ItemService {

  additem(item) {    
    return http.post(`/items/additem`, item);
  }

  getItemUserAccount(ownerId) {
    return http.get(`/items/allItemsUserAccount?ownerId=` + ownerId);
  }

  search(keyword) {
     return http.get('/items/search/' + keyword);
  }

  getAllItems() {
     return http.get('/items');
  }
  
  getItemStorePage(sellerId) {
    return http.get(`/items/allItemsStorePage/` + sellerId);
  }

  getItem(id) {
     return http.get('/items/' + id);
  }

  editItem(id, body) {
     return http.put('/items/' + id, body);
  }
}

export default new ItemService();
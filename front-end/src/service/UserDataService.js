import http from "../http-common";
class UserDataService {
  retrieveAllUsers() {
    return http.get(`/users/users`);
  }

  retrieveSellerID(id) {
    return http.get(`/users/sellerid` + id);
  }
}

export default new UserDataService();
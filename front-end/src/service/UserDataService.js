import http from "../http-common";
class UserDataService {
  retrieveAllUsers() {
    return http.get(`/users/users`);
  }

  getUser(id) {
     return http.get('/users/' + id);
  }

  updateUser(body) {
    return http.put('/users/updateUser', body);
 }
}

export default new UserDataService();

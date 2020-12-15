import http from "../http-common";
class UserDataService {
  retrieveAllUsers() {
    return http.get(`/users/users`);
  }

  getUser(id) {
     return http.get('/users/' + id);
  }
}

export default new UserDataService();

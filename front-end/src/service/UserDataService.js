import http from "../http-common";
class UserDataService {
  retrieveAllUsers() {
    return http.get(`/users`);
  }
}

export default new UserDataService();
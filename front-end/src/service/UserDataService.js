import axios from "axios";

const USER_API_URL = "http://localhost:8080";

class UserDataService {
  retrieveAllUsers() {
    return axios.get(`${USER_API_URL}/users`);
  }
}

export default new UserDataService();
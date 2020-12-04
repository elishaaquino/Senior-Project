import http from "../http-common";

class AuthenticationService {
  register(user) {
    return http.post(`/users/signup`, user);
  }

  login(user) {
     return http.post('users/signin', user)
      .then(resp => {
         if (resp.data.jwt) {
            localStorage.setItem('user', JSON.stringify(resp.data));
         }
         return resp.data;
      });
  }

  logout() {
     localStorage.removeItem('user');
  }
}

export default new AuthenticationService();
import http from "../http-common";

class ChatService {
   getMessages(senderId, recipientId) {    
      return http.get(`/messages/` + senderId + '/' + recipientId);
    }
}

export default new ChatService();
import http from "../http-common";

class ChatService {
   getMessages(senderId, recipientId) {    
      return http.get(`/messages/` + senderId + '/' + recipientId);
   }
   getMessagesBySenderId(senderId) {
      return http.get(`/messages/allMessagesSenderId/` + senderId);
   }
}

export default new ChatService();
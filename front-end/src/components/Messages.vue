<template>
    <div class="main">
        <h2 class="chats">Messages</h2>
        <table class="chats-2">
            <tr v-for="(msg, idx) in messages" :key="idx">
            <td><router-link :to="{ name: 'chat', params: { sellerId: msg.recipientId} }">{{msg.recipientName}}</router-link>
            <p>{{msg.content}}</p>
            </td>
            </tr>
        </table>
    </div>
</template>

<script>
import ChatService from '../service/ChatService';

export default {
  name: "chat",
  data() {
    return {
      currentUserId: "",
      currentUserName: "",
      messages: [],
      sellerPhoto: "",
    };
  },
  methods: {
    getMessagesBySenderId() {
       ChatService.getMessagesBySenderId(this.currentUserId).then(resp => {
            let msgs = [];
            
            (resp.data).forEach(element => {
                msgs.push(element);
            });
            
            this.messages = msgs;

            let messagesRemovedDuplicates = msgs.reduceRight(function (r, a) {
                    r.some(function (b) { return a.chatId === b.chatId; }) || r.push(a);
                    return r;
                }, []);

            this.messages = messagesRemovedDuplicates;
       })
    }
  },
  created() {
      this.currentUserName = JSON.parse(localStorage.user)["username"];
      this.currentUserId = JSON.parse(localStorage.user)["id"];
      this.getMessagesBySenderId();
  }
};
</script>

<style scoped>
.main {
    border-radius: 1.5em;
    box-shadow: 0px 11px 25px 2px rgba(0, 0, 0, 0.14);
    width: 35%;
    margin: 5em auto;
    padding-top: 0.25rem;
    padding-bottom: 1.5rem;
}
.chats{
    margin-left: 15%;
    margin-top: 5%;
}
.chats-2{
    margin-left: 15%;
    margin-top: 1%;
    line-height: 1.5rem;
    width: 70%;
}
table tr td {
    background-color: #FCF5F3;
    border-radius: 15px;
}
a {
    margin-left: 15px;
    color: black;
    font-size: 150%;
}
p {
    margin-left: 15px;
}
table {
    border-radius: 25px;
}
a:hover{
    text-decoration: none;
}
td {
    padding-top: 4%;
}
td:hover {
    background-color: #faf8f8;
}
</style>

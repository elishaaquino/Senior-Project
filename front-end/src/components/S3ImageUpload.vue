<template>
  <div class="large-12 medium-12 small-12 cell">
    <input type="file" @change="onFileChange($event.target.files)"/>
    <button @click="submitFile()">Upload</button>
  </div>
</template>

<script>
import http from "../http-common";
export default {
   data() {
      return {
         file: ''
      }
   },
   methods: {
      onFileChange(files) {
         this.file = files[0];
      },
      submitFile() {
         const formData = new FormData();
         formData.append("file", this.file);
         http.post("storage/uploadImage",formData);
      }
   }
}
</script>

<style lang="scss" scoped>

</style>
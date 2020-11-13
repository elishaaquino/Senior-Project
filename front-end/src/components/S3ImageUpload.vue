<template>
  <div class="large-12 medium-12 small-12 cell">
    <input type="file" multiple="multiple" @change="onFileChange($event.target.files)"/>
    <button @click="submitFile()">Upload</button>
  </div>
</template>

<script>
import http from "../http-common";
export default {
   data() {
      return {
         files: undefined,
         fileInfos: []
      }
   },
   methods: {
      onFileChange(files) {
         this.files = files;
         console.log(this.files);
      },
      submitFile() {
         for (let i = 0; i < this.files.length; i++) {
            const formData = new FormData();
            formData.append("file", this.files[i]);
            http.post("storage/uploadImage",formData).then(resp => console.log(resp.data));
         }         
      }
   }
}
</script>

<style lang="scss" scoped>

</style>
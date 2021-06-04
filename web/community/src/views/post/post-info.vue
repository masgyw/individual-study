<template>
  <div class="post-info">
    <el-row>
      <h1>{{postInfo.postTitle}}</h1>
    </el-row>
    <el-row>
      <h4>{{postInfo.createdTime}}</h4>
    </el-row>
    <el-row>
      <el-col :span="4"><el-button type="text" icon="el-icon-thumb">{{postInfo.likes}}</el-button></el-col>
      <el-col :span="4"><el-button type="text" icon="el-icon-view">{{postInfo.comments}}</el-button></el-col>
      <el-col :span="4"><el-button type="text" icon="el-icon-chat-dot-square">{{postInfo.reading}}</el-button></el-col>
    </el-row>
    <el-divider></el-divider>
    <el-row>
      <BaseMarkdown :md="postInfo.postContent"></BaseMarkdown>
    </el-row>
    <el-divider></el-divider>
    <comment-plane v-if="commentFlag" :postId="postId"></comment-plane>
  </div>
</template>

<script>
  import BaseMarkdown from '@/components/BaseMarkdown'
  import CommentPlane from '@/views/comment/comment-plane';

  export default {
    name: "PostInfo",
    components: {
      BaseMarkdown,
      CommentPlane
    },
    data() {
      return {
        postInfo: {},
        postId: '',
        commentFlag: false
      }
    },

    mounted() {
      this.postInfo = this.$store.getters.sessionData;
      this.postId = this.postInfo.uid;
      this.commentFlag = true;
    }
  }
</script>

<style lang="scss" scoped>
  .post-info {
    width: 80%;
    margin: 0 auto;
  }

  .comment-submit {
    margin-top: 1em;
  }
</style>
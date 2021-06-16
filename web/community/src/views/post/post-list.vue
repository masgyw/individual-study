<template>
  <div v-loading="isLoading">
    <el-row v-for="(item,idx) in datas" :key="idx" class="post-row">
      <el-card class="box-card">
        <el-row>
          <el-button type="text" @click="showInfo(item)">{{item.postTitle}}</el-button>
        </el-row>
        <el-row class="post-content">{{item.postResume}}</el-row>
        <el-row class="bottom">
          <el-col :span="12"><span>{{item.createdTime}}</span></el-col>
          <el-col :span="4">
            <el-button type="text" icon="el-icon-thumb">{{item.likes}}</el-button>
          </el-col>
          <el-col :span="4">
            <el-button type="text" icon="el-icon-view">{{item.comments}}</el-button>
          </el-col>
          <el-col :span="4">
            <el-button type="text" icon="el-icon-chat-dot-square">{{item.reading}}</el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-row>
    <el-row v-if="!isLoading && total > 20" class="load-more">
      <el-button type="text">加载更多</el-button>
    </el-row>
    <el-row v-if="!isLoading && total == 0">
      <span>No datas!</span>
    </el-row>
    <el-row v-if="isLoading">
      <i class="el-icon-loading"></i>
    </el-row>
  </div>
</template>
<script>
  import {
    mutationsName,
    getMutationType
  } from '@/store/mutation-types'
  import apiTypes from '@/api/base/api-types'

  export default {
    data() {
      return {
        datas: null,
        total: 0,
        page: 1,
        limit: 20,
        isLoading: true
      }
    },
    methods: {
      getDatas() {
        this.BASE_APIS.findByPage(apiTypes.POST, { page: this.page, limit: this.limit })
          .then(resp => {
            console.log(resp)
            this.datas = resp.data.records;
            this.total = resp.data.total;
            this.isLoading = false;
          })
      },
      showInfo(post) {
        console.log(post)
        this.$store.commit(getMutationType(mutationsName.SET_SESSION_DATA), post);
        this.$router.push({ path: "/post/info", params: post });
      }
    },
    created() {
      this.getDatas();
    }
  }
</script>
<style scoped lang="scss">
  .post-row {
    margin-bottom: 1em;
  }

  .clearfix:after {
    clear: both
  }

  .post-content {
    margin: 1em 0;
  }

  .load-more {
    text-align: center;
  }
</style>
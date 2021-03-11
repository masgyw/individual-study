<template>
  <div class="content-body">
    <el-row>
      <el-col :span="15" :offset="1">
        <post-list></post-list>
      </el-col>
      <el-col :span="6" :offset="1">
        <el-row class="card-row">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>用户排行榜</span>
              <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'用户 ' + o }}
            </div>
          </el-card>
        </el-row>
        <el-row class="card-row">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>热点榜</span>
              <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'帖子 ' + o }}
            </div>
          </el-card>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>

  import PostList from '@/views/post/post-list.vue'

  export default {
    components: {
      PostList,
    },
    data() {
      return {
      }
    },
    methods: {

    },
    created() {
    }
  }
</script>

<style lang="scss" scoped>
  .content-body {
    /* outline: 1px solid black; */
    height: 100vh;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .card-row {
    margin-bottom: 10px;
  }
</style>
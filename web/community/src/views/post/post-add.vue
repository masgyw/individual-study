<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="标题" key="1">
        <el-input type="text" v-model="form['postTitle']" @input="onInput" />
      </el-form-item>
      <el-form-item label="概要" key="2">
        <el-input type="text" v-model="form['postResume']" @input="onInput" />
      </el-form-item>
      <el-form-item label="内容" key="3">
        <mavon-editor ref="md" v-model="form['postContent']" @change="change" style="min-height: 600px" />
      </el-form-item>
      <el-form-item label="标签" key="4">
        Java / C
      </el-form-item>

      <el-form-item class="btn-group">
        <el-button type="primary" @click="doSubmit">提交</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>

  import { mavonEditor } from 'mavon-editor'
  import 'mavon-editor/dist/css/index.css'
  import apiTypes from '@/api/base/api-types'

  export default {
    name: "PostPage",
    components: {
      mavonEditor
    },
    data() {
      return {
        form: {},
        content: '', // 输入的markdown
        html: '',    // 及时转的html
      }
    },
    methods: {
      doSubmit(data) {
        console.log(this.form)
        let curUser = this.$store.getters.currentUser;
        this.form.createdBy = curUser.userName;
        this.form.createdById = curUser.uid || '-1';
        this.BASE_APIS.offer(apiTypes.POST, this.form).then(resp => {
          this.$router.push("/");
          this.$message({
            showClose: true,
            message: '发帖成功',
            type: 'success'
          });
        })
      },
      onCancel() {
        this.$message({
          message: 'cancel!',
          type: 'warning'
        })
      },
      onInput(e) {
        this.$forceUpdate();
      },
      // 所有操作都会被解析重新渲染
      change(value, render) {
        // render 为 markdown 解析后的结果[html]
        this.html = render;
      },
      // 提交
      submit() {
        console.log(this.content);
        console.log(this.html);
      }
    }
  }

</script>
<style lang="scss" scoped>
  .app-container {
    width: 100%;
  }
  .line {
    text-align: center;
  }
  .btn-group {
    text-align: right;
  }
</style>
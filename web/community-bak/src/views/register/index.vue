<template>
  <div>
    <el-card class="register-card">
    <el-row>
      <div class="title-container">注册</div>
    </el-row>
    <el-row>
      <el-col>
        <el-form :model="registryForm" :rules="rules" ref="registryForm" label-width="125px" class="registry-form">
          <el-form-item label="用户名" prop="userName">
            <el-input v-model="registryForm.userName"></el-input>
          </el-form-item>
          <el-form-item label="中文名" prop="userNameCn">
            <el-input v-model="registryForm.userNameCn"></el-input>
          </el-form-item>
          <el-form-item label="用户邮箱" prop="email">
            <el-input v-model="registryForm.email"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input v-model="registryForm.age"></el-input>
          </el-form-item>
          <el-form-item label="输入密码" prop="password">
            <el-input type="password" v-model="registryForm.password"></el-input>
          </el-form-item>
          <el-form-item label="再次输入密码" prop="secPassword">
            <el-input type="password" v-model="registryForm.secPassword"></el-input>
          </el-form-item>
          <el-form-item label="角色" prop="roleId">
            <el-select v-model="registryForm.roleId" placeholder="请选择角色">
              <el-option v-for="item in roleList" :key="item.roleId" :label="item.roleName" :value="item.roleId"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm('registryForm')">注册</el-button>
            <el-button type="primary" @click="resetForm('registryForm')">清空</el-button>
            <el-button type="text">
              <router-link to="/login">已有账号，马上登陆</router-link>
            </el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </el-card>
  </div>
</template>

<script>
  import apiTypes from '@/api/api-types'
  import * as LoginRequest from "@/api/user.js";

  export default {
    name: "Register",
    data() {
      return {
        roleList: [],
        registryForm: {
          userName: "",
          userNameCn: "",
          password: "",
          secPassword: "",
          age: "",
          roleId: ""
        },
        rules: {
          userName: [
            { required: true, message: "请输入用户名", trigger: "blur" },
            { min: 3, max: 8, message: "长度在 3 到 8 个字符", trigger: "blur" }
          ],
          region: [{ required: true, message: "请输入秘密", trigger: "blur" }],
          password: [{ required: true }],
          secPassword: [{ required: true }]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            LoginRequest.register(this.registryForm).then(resp => {
              this.$router.push("/login");
            });
          } else {
            console.log("error submit!!");
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      getRoleOptions() {
        this.BASE_APIS.findAll(apiTypes.ROLE)
          .then(resp => {
            this.roleList = resp.data;
          });
      },
    },
    created() {
      this.getRoleOptions();
    }
  };
</script>

<style lang="scss" scoped>
  .register-card {
    width: 50%;
    margin: 0 auto;
  }
  .title-container {
    color: black;
    text-align: center;
    font-size: 1.5em;
    font-weight: bold;
    line-height: 2em;
  }
</style>
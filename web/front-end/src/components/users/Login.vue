<template>
    <div class="login">
        <header1></header1>
        <div class="login_wrapper">
            <div class="animate form login_form">
                <section class="login_content">
                    <form>
                        <h1>管理员登录</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="请输入用户名" v-model.lazy="username" />
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="请输入密码" v-model.lazy="passwd" />
                        </div>
                        <div>
                            <a class="btn btn-default" @click="loginToIndex">登录</a>
                            <router-link class="btn btn-default" to="/register">注册</router-link>
                        </div>
                    </form>
                </section>
            </div>
        </div>
    </div>
</template>

<script>
    // 导入其他组件
    import Header1 from '@/components/header/Header'

    export default {
        components: {
            "header1": Header1
        },
        data() {
            return {
                "username": "",
                "passwd": ""
            }
        },
        methods: {
            loginToIndex: function () {
                // 1.获取用户名和密码
                var uname = this.username;
                var upasswd = this.passwd;
                var vx = this;
                // 2.发送ajax请求
                this.$axios({
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    method: "post",
                    url: "/sys-api/system/user/login",
                    data: {
                        "username": uname,
                        "passwd": upasswd
                    }
                }).then(function (resp) {
                    console.log("resp:" + resp);
                    var data = resp.data;
                    var isLogin = data.code == 200 ? true : false;
                    if (isLogin) {
                        vx.$router.push("/list/" + JSON.stringify(data.data));
                        // 组件间通信，发送方触发事件
                        /* vx.vus.$emit("userDataEvt", JSON.stringify(data)); */
                    } else {
                        vx.$router.go(0);

                        // Navigating to current location ("/login") is not allowed
                        // vx.$router.push("/login");
                    }
                }).catch(function (error) {
                    console.log("err:" + error);
                })
                // 3.获取返回数据

                // 4.判断如果登录 跳转 /user-list
            }
        },
        mounted() {
            console.log("挂载后...")
        }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
    .wrapper {}
</style>
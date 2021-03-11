<template>
    <div class="login">
        <div class="login_wrapper">
            <div class="animate form login_form">
                <section class="login_content">
                    <form>
                        <h1>注册</h1>
                        <p class="">{{errorMsg}}</p>
                        <div>
                            <label>登录名：</label>
                            <input type="text" class="form-control" placeholder="username"
                                v-model.lazy="user.username" />
                        </div>
                        <div>
                            <label>姓：</label>
                            <input type="text" class="form-control" placeholder="first name"
                                v-model.lazy="user.firstName" />
                        </div>
                        <div>
                            <label>名：</label>
                            <input type="text" class="form-control" placeholder="second name"
                                v-model.lazy="user.secondName" />
                        </div>
                        <div>
                            <label>密码：</label>
                            <input type="password" class="form-text" placeholder="once password"
                                v-model.lazy="passwd1" />
                        </div>
                        <div>
                            <label>确认密码：</label>
                            <input type="password" class="form-text" placeholder="second password"
                                v-model.lazy="passwd2" />
                        </div>
                        <div>
                            <label>年龄：</label>
                            <input type="text" class="form-control" placeholder="" v-model.lazy="user.age" />
                        </div>
                        <div>
                            <label>爱好：</label>
                            <input type="text" class="form-control" placeholder="" v-model.lazy="user.hobby" />
                        </div>
                        <div>
                            <a class="btn btn-default submit" @click="doRegister"
                                v-bind:style="{disabled: isEnable}">注册</a>
                        </div>
                    </form>
                </section>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {},
        data() {
            return {
                "isEnable": false,
                "user": {
                    "username": "",
                    "firstName": "",
                    "secondName": "",
                    "passwd": "",
                    "age": "",
                    "hobby": ""
                },
                "passwd1": "",
                "passwd2": "",
                "errorMsg": ""
            }
        },
        watch: {
            passwd2: function (data) {
                if (this.passwd2 == this.passwd1) {
                    this.user.passwd = this.passwd1;
                } else {
                    this.errorMsg = "两次密码输入不一致!";
                }
            }
        },
        methods: {
            doRegister: function () {
                var vx = this;
                this.$axios({
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    },
                    method: "post",
                    url: "/sys-api/system/user/register",
                    data: vx.user
                }).then(function (resp) {
                    var isRegistered = resp.data;
                    if (isRegistered) {
                        vx.$router.push("/login");
                    } else {
                        vx.$router.go(0);
                    }
                }).catch(function (error) {
                    console.log("error:" + error);
                })
            }
        },
        created() { },
        mounted() { }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
    .wrapper {}
</style>
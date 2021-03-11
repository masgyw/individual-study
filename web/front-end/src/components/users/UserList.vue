<template>
	<div class="wrapper">
		<div>
			<router-link class="btn btn-default" to="/login">登录</router-link>
			<router-link class="btn btn-default" to="/register">注册</router-link>
			<p>当前登录用户：{{currentUser.cnUserName}}</p>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>用户编号</th>
					<th>用户名</th>
					<th>用户年龄</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="user in usersData">
					<td>{{user.uid}}</td>
					<td>{{user.userName}}</td>
					<td>{{user.age}}</td>
					<td>
						<a class="btn btn-default" @click.stop="doWithChat(user.uid)">聊天</a>
						<!-- <router-link :to="'/chat/'+ currentUser.uid + '/' + user.uid">聊天</router-link> -->
						<a class="btn btn-default">其他</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>

<script>
	import VueEvent from '@/components/model/VueEvent.js';

	export default {
		name: "UserList",
		data() {
			return {
				"currentUser": {
					"uid": "",
					"username": "",
					"cnUserName": ""
				},
				"usersData": {}
			}
		},
		computed: {
		},
		methods: {
			queryUsers: function () {
				var vx = this;
				this.$axios({
					method: "get",
					url: "/sys-api/system/user/all",
					data: {

					}
				}).then(function (resp) {
					console.log("请求成功 data:" + resp.data);
					vx.usersData = resp.data;
				}).catch(function (error) {
					console.log("error:" + error);
				});
			},
			doWithChat: function(toUserId) {
				var chatData = {
					"fromUserId": this.currentUser.uid,
					"userName": this.currentUser.cnUserName,
					"toUserId": toUserId
				}
				console.log("need send msg>" + JSON.stringify(chatData));
				// 发送数据到聊天组件
				VueEvent.$emit("chatEvt", JSON.stringify(chatData));
				// VueEvent.$emit("chatEvt", "hello， 老二");
				// 跳转到聊天组件
				this.$router.push("/chat-room");
			}
		},
		mounted: function (el, bindings) {
			var user = JSON.parse(this.$route.params.userData);
			console.log("user :" + user);
			this.currentUser.cnUserName = user.firstName + user.secondName;
			this.currentUser.uid = user.uid;
			this.currentUser.username = user.username;

			// 接收方，绑定事件
			/* this.bus.$on("userDataEvt", function (data) {
				console.log("-------------" + data);
			}); */
			this.queryUsers(); // 查询数据
		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.wrapper {}
</style>
<template>
	<el-container>
		<el-aside width="20%" style="background-color: rgb(238, 241, 246)">
			<el-menu :default-openeds="['1']">
				<el-submenu index="1">
					<template slot="title">
						<i class="el-icon-message"></i>导航一
					</template>
					<el-menu-item>选项一</el-menu-item>
					<el-menu-item>选项二</el-menu-item>
				</el-submenu>
				<el-submenu index="2">
					<template slot="title">
						<i class="el-icon-menu"></i>导航二
					</template>
					<el-menu-item-group>
						<template slot="title">分组一</template>
						<el-menu-item index="2-1">选项1</el-menu-item>
						<el-menu-item index="2-2">选项2</el-menu-item>
					</el-menu-item-group>
					<el-menu-item-group title="分组2">
						<el-menu-item index="2-3">选项3</el-menu-item>
					</el-menu-item-group>
					<el-submenu index="2-4">
						<template slot="title">选项4</template>
						<el-menu-item index="2-4-1">选项4-1</el-menu-item>
					</el-submenu>
				</el-submenu>
				<el-submenu index="3">
					<template slot="title">
						<i class="el-icon-setting"></i>个人学习
					</template>

					<el-menu-item-group>
						<template slot="title">前端</template>
						<el-menu-item v-for="(biz, idx) in bussinessList" :key="idx" @click.native="showBiz(biz.key)"
							:index="'3' + idx">
							{{biz.value}}</el-menu-item>
					</el-menu-item-group>

				</el-submenu>
			</el-menu>
		</el-aside>

		<el-container>
			<el-header>
				<el-page-header @back="goBack" content="详情页面">
				</el-page-header>
			</el-header>
			<el-row>
				<el-breadcrumb separator="/">
					<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
					<el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
					<el-breadcrumb-item>活动列表</el-breadcrumb-item>
					<el-breadcrumb-item>活动详情</el-breadcrumb-item>
				</el-breadcrumb>
			</el-row>
			<!-- 主体 -->
			<el-main>
				<router-view />
				<!-- <el-row v-for="(item, index) in bussinessContent" :key="index" :gutter="12">
					<el-button @click="routeTo(item.name)" type="text" class="button">{{item.val}}</el-button>
				</el-row> -->
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	import { ROUTE_URLS } from "@/router/route-types.js";

	const itemsMap = {
		elementUI: [
			{ name: "base", val: "基础" },
			{ name: "base", val: "通知" },
			{ name: "base", val: "组件" }
		],
		vuex: [
			{ name: "base", val: "基础" },
		]
	};
	export default {
		name: "Dashboard",
		data() {
			return {
				// TODO: 动态数组，数组非响应式
				bussinessList: [
					{ key: "ELEMENT_UI_INDEX", value: "ElementUI" },
					{ key: "SASS_INDEX", value: "Sass" },
					{ key: "VUEX_INDEX", value: "Vuex" },
					{ key: "VUE_INDEX", value: "Vue API"},
					{ key: "ECMA_INDEX", value: "ECMA 6"}
				],
			};
		},

		methods: {
			showBiz(urlKey) {
				console.log(urlKey);
				this.$router.push(ROUTE_URLS[urlKey]);
      },
      goBack() {
        console.log("go back ...");
      }
		}
	};
</script>

<style lang="scss" scoped>
	.el-container {
		height: 768px;
		border: 1px solid #eee;
	}

	.el-header {
		background-color: #b3c0d1;
		color: #333;
		line-height: 60px;
	}

	.el-aside {
		color: #333;
	}

	.el-row {
		margin-bottom: 1em;
	}
</style>
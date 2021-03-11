<template>
	<div>
		<h2>Element UI 学习</h2>
		<hr>
		<h3>按钮</h3>
		<el-button type="success" plain>按钮</el-button>
		<h3>输入框</h3>
		<el-input v-model="input" placeholder="请输入内容" :disabled="true"></el-input>
		<h3>af-table-column</h3>
		<el-table :data="tableData">
			<af-table-column label="日期" prop="date"></af-table-column>
			<af-table-column label="姓名" prop="name"></af-table-column>
			<af-table-column label="地址" prop="address"></af-table-column>
			<!-- 自定义列 -->
			<af-table-column label="列3">
				<template slot-scope="scope">
					<div>自定义显示值31: {{ scope.row.field31 }}</div>
					<div>自定义显示值32: {{ scope.row.field32 }}</div>
				</template>
			</af-table-column>

			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button type="danger">删除</el-button>
				</template>
			</el-table-column>

		</el-table>
		<el-button @click="showItem">点击</el-button>
		<router-view />
	</div>
</template>

<script>

	export default {
		data() {
			const item = {
				date: '2016-05-02',
				name: '王小虎',
				address: '上海市普陀区金沙江路 1518 弄'
			};
			return {
				tableData: Array(20).fill(item),
				input: ''
			}
		},

		methods: {
			showItem() {
				this.$router.push('/views/element-ui/base-usage/demo-el-container')
			}
		}
	}
</script>

<style lang="scss" scoped>

</style>
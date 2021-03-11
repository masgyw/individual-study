import Vue from 'vue'
import Vuex from 'vuex'

// 常量定义 mutation
import * as types from './mutation-types'
// 实体
import entities from './modules/entities'
import session from './modules/session'

Vue.use(Vuex);

export default new Vuex.Store({
	// 模块
	modules: {
		session
	},

	// 唯一状态
	state: {
		name: "",
		count: 0,
		seq: 0,
		num: 0,
		todos: [
			{ id: 1, text: '...', done: true },
			{ id: 2, text: '...', done: false }
		]
	},

	// 像计算属性一样，getter 的返回值会根据它的依赖被缓存起来，且只有当它的依赖值发生了改变才会被重新计算
	getters: {
		doneTodos: state => {
			return state.todos.filter(todo => todo.done);
		},

		// Getter 也可以接受其他 getter 作为第二个参数
		doneTodosCount: (state, getters) => {
			return getters.doneTodos.length
		},

		// 可以通过让 getter 返回一个函数，来实现给 getter 传参
		getTodoById: (state) => (id) => {
			return state.todos.find(todo => todo.id === id)
		}
	},

	// 改变，更改 Vuex 的 store 中的状态的唯一方法是提交 mutation
	// 每个 mutation 都有一个字符串的 事件类型 (type) 和 一个 回调函数 (handler)
	// *** Mutation 必须是同步函数
	mutations: {
		// 回调函数就是我们实际进行状态更改的地方，并且它会接受 state 作为第一个参数
		increment(state) {
			state.count++;
		},
		// 传入额外的参数，即 mutation 的 载荷（payload）
		incrWithStep1(state, payload) {
			state.count += payload
		},
		incrWithStep2(state, payload) {
			state.count += payload.step
		},
		// 我们可以使用 ES2015 风格的计算属性命名功能来使用一个常量作为函数名
		[types.SOME_MUTATION](state) {
			state.count = 99
		}
	},

	/*
	Action 类似于 mutation，不同在于：
	1)Action 提交的是 mutation，而不是直接变更状态。
	2)Action 可以包含任意异步操作
	*** 异步操作
	*/
	actions: {
		// Action 函数接受一个与 store 实例具有相同方法和属性的 context 对象,不是 store 实例本身了
		increment(context) {
			context.commit('increment');
		},
		doSomething(context) {
			console.log("index.context");
		},
		// ES2015 的 参数解构 来简化代码
		increment({ commit }) {
			commit('increment')
		},
		// 调用异步 API 和分发多重 mutation
		/* checkout({ commit, state }, products) {
			// 把当前购物车的物品备份起来
			const savedCartItems = [...state.cart.added]
			// 发出结账请求，然后乐观地清空购物车
			commit(types.CHECKOUT_REQUEST)
			// 购物 API 接受一个成功回调和一个失败回调
			shop.buyProducts(
				products,
				// 成功操作
				() => commit(types.CHECKOUT_SUCCESS),
				// 失败操作
				() => commit(types.CHECKOUT_FAILURE, savedCartItems)
			)
		} */

	}

});
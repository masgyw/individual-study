import * as types from '../mutation-types';

const state = {
	count: 100,
	isActive: false,
	hasCard: false,
	cardNumber: ""
}

const getters = {
	getSessionCardNumber: (state) => {
		return state.cardNumber;
	},
	// 全局Getter 调用
	getCount(state, getters, rootState, rootGetters) {
		console.log(getters.getSessionCardNumber);
		console.log(rootState);
		console.log(rootGetters.doneTodos);
		return state.count;
	}
}

const mutations = {
	[types.START_SESSION] (state, session) {
		console.log(state)
	},
	[types.START_SESSION] (state, session) {
		console.log(state)
	},
	increment(state) {
		// 这里的state 对象是模块的局部状态
		state.count ++
	}
}

const actions = {
	doSomething(context) {
		console.log("session.context")
	},
	/*
	模块局部状态
	state: 当前state
	rootState: 根节点状态
	*/
	startSession({state, dispatch, commit, rootState, rootGetters}) {
		// 100 >> 0
		// console.log(state.count + ">>" + rootState.count);
		// console.log("rootGetters:" + rootGetters);
		// commit(types.START_SESSION);

		// dispatch('doSomething'); // session/doSomething
		// dispatch('doSomething', {root: true}); // doSomething

		// commit('increment'); // session/increment
		// commit('increment', {root: true}); // increment
	},
	// 注册全局 action
	someAction: {
		root: true,
		handler: function(context, payload) {
			console.log("session define global action")
		}
	}
}

export default {
	state,
	getters,
	mutations,
	actions
}
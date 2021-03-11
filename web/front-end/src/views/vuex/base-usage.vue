<template>
  <div>
    <h2>Vuex Store 学习教程</h2>
    <div>展示 计数：{{count}}</div>
    <div>doneTodosCount：{{doneTodosCount}}</div>
    <ol>
      <li>
        <button @click="updateStoreState">store.commit 触发状态变更</button>
      </li>
      <li>
        <button @click="updateStoreStateWithParam">store.commit 带参数触发状态变更</button>
      </li>
    </ol>
  </div>
</template>

<script>
// 辅助函数，当一个组件需要获取多个状态的时候，将这些状态都声明为计算属性会有些重复和冗余，辅助函数帮助我们生成计算属性
import { mapState } from "vuex";
// getters 映射
import { mapGetters } from "vuex";
// mutations 映射
import { mapMutations } from "vuex";

import { mapActions } from "vuex";

import * as types from "@/store/mutation-types.js";

export default {
  data() {
    return {};
  },

  computed: {
    localComputed() {
      /* ... */
    },
    doneTodosCount() {
      return this.$store.getters.doneTodosCount;
    },
    // 使用对象展开运算符将此对象混入到外部对象中
    ...mapState({
      // 箭头函数可使代码更简练
      count: state => state.count,
      // 传字符串参数 'count' 等同于 `state => state.count`
      countAlais: "count"
    }),

    // mapGetters 辅助函数仅仅是将 store 中的 getter 映射到局部计算属性
    // 使用对象展开运算符将 getter 混入 computed 对象中
    ...mapGetters([
      "doneTodosCount",
      "anotherGetter"
      // ...
    ]),
    // 对象形式，给getter属性取别名
    // ...mapGetters({
    //   // 把 `this.doneCount` 映射为 `this.$store.getters.doneTodosCount`
    //   doneCount: 'doneTodosCount'
    // })
    
  },
  // 当映射的计算属性的名称与 state 的子节点名称相同时,可以给 mapState 传一个字符串数组
  /*computed: mapState([
    // 映射 this.count 为 store.state.count
    'count'
  ])*/

  methods: {
    updateStoreState() {
      this.$store.getters.getTodoById(2);
      // 调用 store.mutations 定义的更新方法
      this.$store.commit("increment");
    },

    ...mapMutations([
      "increment", // 将 `this.increment()` 映射为 `this.$store.commit('increment')`

      // `mapMutations` 也支持载荷：
      "incrWithStep1" // 将 `this.incrementBy(amount)` 映射为 `this.$store.commit('incrementBy', amount)`
    ]),
    ...mapMutations({
      add: "increment" // 将 `this.add()` 映射为 `this.$store.commit('increment')`
    }),

    updateStoreStateWithParam() {
      this.$store.commit("incrWithStep1", 10);

      // 对象方式提交载荷,整个对象都作为载荷传给 mutation 函数
      this.$store.commit({
        type: "incrWithStep2",
        step: 10
      });

      this.$store.commit(types.SOME_MUTATION);
    },
    // action 通过分发来触发
    doAction() {
      this.$store.dispatch("increment");
	},
	...mapActions([
      "increment", // 将 `this.increment()` 映射为 `this.$store.dispatch('increment')`

      // `mapActions` 也支持载荷：
      // "incrementBy" // 将 `this.incrementBy(amount)` 映射为 `this.$store.dispatch('incrementBy', amount)`
    ]),
    ...mapActions({
      add: "increment" // 将 `this.add()` 映射为 `this.$store.dispatch('increment')`
    })
  },

  created() {
	  // 模块内定义全局action
	//   this.$store.dispatch("someAction");
	  // 调用模块内action
	  this.$store.dispatch("startSession");
  }
};
</script>

<style scoped>
</style>
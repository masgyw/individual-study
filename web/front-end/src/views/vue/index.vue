<template>
  <div>
    <h2>Vue 学习</h2>

    <ul>
      <li> 1.父子组件通信
        <base-button prop1="p1" prop2="p2" @confirm="doAlert">父子通信</base-button>
      </li>
    </ul>

    <hr />
    <router-view />
  </div>
</template>

<script>

  import BaseButton from "@/components/base-button.vue"

  export default {
    components: {
      BaseButton
    },

    methods: {
      doAlert() {
        alert("this son to parent")
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "../../assets/sass/base.scss";
  @import "../../assets/sass/senior.scss";
</style>
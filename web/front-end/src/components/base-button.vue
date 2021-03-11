<template>
  <div>
    <div>父组件传递参数：{{prop1}} <br/> {{prop2}}  </div>
    <el-button @click="clickBtn">这是一个按钮</el-button>
  </div>
</template>

<script>

export default {
  name: "BaseButton",

  data() {
    return {}
  },

  props: [
    "prop1",
    "prop2"
  ],

  methods: {
    clickBtn() {
      this.$message("参数列表：" + this.prop1 + ", " + this.prop2);
      this.$emit("confirm");
    }
  }


}

</script>

<style scoped>

</style>
<template>
  <div>
    <h2>ECMA Script6 学习教程</h2>

  </div>
</template>

<script>

  function timeout(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }

  async function asyncPrint(value, ms) {
    await timeout(ms);
    console.log(">>" + value);
  }

  asyncPrint("aaa", 3000);

  export default {
    data() {
      return {};
    },

    mounted() {
    },

    methods: {

    }
  };
</script>

<style scoped>
</style>
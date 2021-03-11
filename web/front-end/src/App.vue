<template>
	<div id="app">
		<router-view :key="key" />
	</div>
</template>

<script>
export default {
  name: "App",
  
  data() {

    return {

    }
  },

	// Vue 监听路由变化
	watch: {
    // 方式一
		$route(to, from) {
			console.log("App.vue log:" + to + ">" + from);
    },
    
    $route: {
      handler: function(val, oldVal) {
        console.log("App.vue handler:" + val);
      },
      // 深度观察监听
      deep: true
    },

    /*
    VueRouter 钩子方法
    1）beforeRouteEnter
    2) beforeRouteUpdate
    3) beforeRouteLeave
    */
  },

  computed: {
    key: function() {
      return this.$route.name + new Date();
    }
  },
  
  created() {
    let that = this;
    let screenWidth = window.screen.width;
    let screenHeight = window.screen.height;
    let store = this.$store;


  }
};
</script>

<style>
#app {
	font-family: "Avenir", Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
</style>

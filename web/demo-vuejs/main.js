var login = httpVueLoader("views/my-component.vue");

// 全局组件
// Vue.component('MyComp', httpVueLoader("views/my-component.vue"));

var app = new Vue({
    el: '#app',
    components: {
        'my-component': login
      },
    data() {
        return {
            message: '我是xxx'
        }
    },
    router: router // 路由配置
});
// 路由
// app.use(router);
// element-plus
// app.use(ElementPlus);

// app.use(httpVueLoader);



// app.mount('#app');
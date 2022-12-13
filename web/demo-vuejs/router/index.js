// 定义一些路由， 每个路由都需要映射到一个组件
const routerDict = [
    { path: "/", component: httpVueLoader('views/hello.vue') },
    { path: "/hello", component: httpVueLoader('views/hello.vue') },
];

// 创建路由表对象
var router = new VueRouter({
    // 内部提供了 history 模式的实现
    // history: VueRouter.createWebHashHistory(),
    // 路由表
    routes: routerDict
});

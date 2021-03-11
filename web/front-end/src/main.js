// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

// ElementUI 
import ElementUI from 'element-ui'
//避免后期打包样式不同，要放在import App from './App';之前
import 'element-ui/lib/theme-chalk/index.css' // 默认
// 自定义主题 https://element.eleme.cn/#/zh-CN/component/custom-theme
// import '../public/elementui-theme/index.css'
import AFTableColumn from 'af-table-column'
// 国际化
import locale from 'element-ui/lib/locale/lang/en' // lang i18n

import App from './App'
import axios from 'axios' // http plugin
import VueAxios from 'vue-axios'
import router from './router/index' // 路由
import store from './store/index' // 全局存储

import "../static/css/bootstrap-3.3.7.css";

// 所有静态资源文件加载
// import "./assets/js/jquery.js"
// import "./assets/js/json2.js"
// import "./assets/js/modernizr.min.js"
// import "./assets/js/bootstrap.min.js"
// import "./assets/js/bootsnav.js"
// import "./assets/js/jquery.sticky.js"
// import "./assets/js/jquery.easing.min.js"
// import "./assets/js/custom.js"
Vue.use(VueAxios, axios); // Http client

Vue.prototype.$axios = axios;
// axios.defaults.baseURL = '/ajaxurl/system/';
// axios.defaults.timeout=1000;
// 设置axios请求的token
axios.defaults.headers.common['token'] = 'f4c902c9ae5a2a9d8f84868ad064e706';
//设置POST请求头
// axios.defaults.headers.post["Content-type"] = "application/json";
Vue.config.productionTip = false

// 可以传入一个全局配置对象。
// 该对象目前支持 size 与 zIndex 字段。size 用于改变组件的默认尺寸，zIndex 设置弹框的初始 z-index（默认值：2000）
Vue.use(ElementUI, { locale })
// Vue.use(ElementUI, {locale})
Vue.use(AFTableColumn);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store, // ES6 语法，对象property简写（属性名=变量名）
  components: { App },
  // Vue 绝大多数情况下，推荐template 来创建HTML
  // template: '<App/>',
  // 需要javascript 完全编程能力，比template 更接近编译器
  render: h => h(App)
  /*
  ==> function (createElement) {return createElement(App)}
  */
})

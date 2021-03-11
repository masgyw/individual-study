# vue-frontend
vue front end for personal learn

# vue-frontend

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

# 安装http插件 axios

cnpm install axios --save
cnpm install vue-axios --save
cnpm install vuex --save

# 项目结构
- build # 可自定义打包脚本
- dist 打包后的输出目录
- mock
	- index.js
	- mock-server.js
	- table.js
- public  # 单页应用公共模板
	- index.html (模板)
	[webpack.dev.conf.js->plugins->HtmlWebpackPlugin()->template 指定]
- src # 项目源码
	
	- api 请求接口分组
	- assets 图片等媒体资源
	- components 项目内组件
	- icons 项目内矢量图标
	- layout 项目基础布局
	- router 项目路由定义
	- store vuex状态管理
	- styles 项目级样式
	- utils 项目级工具类
	- views 功能页面

	- main.js 项目入口文件
	- App.vue 应用根组件
	- permission.js 路由权限控制
	- settings.js 预设选项
- test 单元测试
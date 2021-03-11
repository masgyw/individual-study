import Vue from 'vue'
// import router from './router'
import VueRouter from 'vue-router'
import routesDict from './router-dict'
// Home
import Dashboard from '@/views/dashboard/routes'

import VuexRoutes from '@/views/vuex/routes'
import ElementUIRoutes from '@/views/element-ui/routes'
import SassRoutes from '@/views/sass/routes'
import ECMAPScript from '@/views/ecma-script/routes'
import VueRoutes from '@/views/vue/routes'

// window 前进、后退监听
/* var hrefArray = [];
router.beforeEach((to, from, next) => {
    
    sessionStorage.setItem("hrefArray", hrefArray);

    next();
}); */
Vue.use(VueRouter); // VueRouter

const childrenList = VuexRoutes.concat(ElementUIRoutes).concat(SassRoutes)
  .concat(VueRoutes).concat(ECMAPScript);

Dashboard.children = childrenList;
routesDict.push(Dashboard);

export default new VueRouter({
	routes: routesDict
})

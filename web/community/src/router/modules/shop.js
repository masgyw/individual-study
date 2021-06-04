import ShopLayout from '@/layout/shop'

const shopRouter = [
  {
    path: '/shop',
    component: ShopLayout,
    redirect: '/shop/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/shop/index.vue'),
        name: 'ShopIndex',
        meta: { title: '商城首页', icon: 'index', affix: true }
      },
      {
        path: 'goods',
        component: () => import('@/views/shop/goods.vue'),
        name: 'ShopGoods',
        meta: { title: '全部商品', icon: 'index', affix: true }
      },
      {
        path: 'goods/details',
        component: () => import('@/views/shop/goods-details.vue'),
        name: 'ShopGoodsDetails',
        meta: { title: '商品详情', icon: 'index', affix: true }
      },
      {
        path: 'about',
        component: () => import('@/views/shop/about.vue'),
        name: 'ShopAbout',
        meta: { title: '关于我们', icon: 'index', affix: true }
      },
      {
        path: 'order',
        component: () => import('@/views/shop/order.vue'),
        name: 'ShopOrder',
        meta: { title: '我的订单', icon: 'index', affix: true }
      },
      {
        path: 'confirmOrder',
        component: () => import('@/views/shop/confirm-order.vue'),
        name: 'ShopConfirmOrder',
        meta: { title: '确认订单', icon: 'index', affix: true }
      },
      {
        path: 'collect',
        component: () => import('@/views/shop/collect.vue'),
        name: 'ShopCollect',
        meta: { title: '我的收藏', icon: 'index', affix: true }
      },
      {
        path: 'shoppingCart',
        component: () => import('@/views/shop/shopping-cart.vue'),
        name: 'ShopShoppingCart',
        meta: { title: '购物车', icon: 'index', affix: true }
      },
    ]
  }
]
export default shopRouter
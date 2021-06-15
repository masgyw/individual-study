import AdminLayout from '@/layout/admin'

export const adminRouter = [
  {
    path: '/admin',
    component: AdminLayout,
    redirect: '/admin',
    children: [{
      path: '',
      name: 'Dashboard',
      component: () => import('@/views-admin/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'menu', auth: true }
    }]
  },
  {
    path: '/pms',
    component: AdminLayout,
    redirect: '/pms/product',
    name: 'pms',
    meta: { title: '商品', icon: 's-shop' },
    children: [{
      path: 'product',
      name: 'product',
      component: () => import('@/views-admin/pms/product/index'),
      meta: { title: '商品列表', icon: 's-shop' }
    },
    {
      path: 'addProduct',
      name: 'addProduct',
      component: () => import('@/views-admin/pms/product/add'),
      meta: { title: '添加商品', icon: 's-shop' }
    },
    {
      path: 'updateProduct',
      name: 'updateProduct',
      component: () => import('@/views-admin/pms/product/update'),
      meta: { title: '修改商品', icon: 's-shop' },
      hidden: true
    },
    {
      path: 'productCate',
      name: 'productCate',
      component: () => import('@/views-admin/pms/productCate/index'),
      meta: { title: '商品分类', icon: 's-shop' }
    },
    {
      path: 'addProductCate',
      name: 'addProductCate',
      component: () => import('@/views-admin/pms/productCate/add'),
      meta: { title: '添加商品分类' },
      hidden: true
    },
    {
      path: 'updateProductCate',
      name: 'updateProductCate',
      component: () => import('@/views-admin/pms/productCate/update'),
      meta: { title: '修改商品分类' },
      hidden: true
    },
    {
      path: 'productAttr',
      name: 'productAttr',
      component: () => import('@/views-admin/pms/productAttr/index'),
      meta: { title: '商品类型', icon: 's-shop' }
    },
    {
      path: 'productAttrList',
      name: 'productAttrList',
      component: () => import('@/views-admin/pms/productAttr/productAttrList'),
      meta: { title: '商品属性列表' },
      hidden: true
    },
    {
      path: 'addProductAttr',
      name: 'addProductAttr',
      component: () => import('@/views-admin/pms/productAttr/addProductAttr'),
      meta: { title: '添加商品属性' },
      hidden: true
    },
    {
      path: 'updateProductAttr',
      name: 'updateProductAttr',
      component: () => import('@/views-admin/pms/productAttr/updateProductAttr'),
      meta: { title: '修改商品属性' },
      hidden: true
    },
    {
      path: 'brand',
      name: 'brand',
      component: () => import('@/views-admin/pms/brand/index'),
      meta: { title: '品牌管理', icon: 's-shop' }
    },
    {
      path: 'addBrand',
      name: 'addBrand',
      component: () => import('@/views-admin/pms/brand/add'),
      meta: { title: '添加品牌' },
      hidden: true
    },
    {
      path: 'updateBrand',
      name: 'updateBrand',
      component: () => import('@/views-admin/pms/brand/update'),
      meta: { title: '编辑品牌' },
      hidden: true
    }
    ]
  },
  {
    path: '/oms',
    component: AdminLayout,
    redirect: '/oms/order',
    name: 'oms',
    meta: { title: '订单', icon: 's-order' },
    children: [
      {
        path: 'order',
        name: 'order',
        component: () => import('@/views-admin/oms/order/index'),
        meta: { title: '订单列表', icon: 's-order' }
      },
      {
        path: 'orderDetail',
        name: 'orderDetail',
        component: () => import('@/views-admin/oms/order/orderDetail'),
        meta: { title: '订单详情' },
        hidden: true
      },
      {
        path: 'deliverOrderList',
        name: 'deliverOrderList',
        component: () => import('@/views-admin/oms/order/deliverOrderList'),
        meta: { title: '发货列表' },
        hidden: true
      },
      {
        path: 'orderSetting',
        name: 'orderSetting',
        component: () => import('@/views-admin/oms/order/setting'),
        meta: { title: '订单设置', icon: 's-order' }
      },
      {
        path: 'returnApply',
        name: 'returnApply',
        component: () => import('@/views-admin/oms/apply/index'),
        meta: { title: '退货申请处理', icon: 's-order' }
      },
      {
        path: 'returnReason',
        name: 'returnReason',
        component: () => import('@/views-admin/oms/apply/reason'),
        meta: { title: '退货原因设置', icon: 's-order' }
      },
      {
        path: 'returnApplyDetail',
        name: 'returnApplyDetail',
        component: () => import('@/views-admin/oms/apply/applyDetail'),
        meta: { title: '退货原因详情' },
        hidden: true
      }
    ]
  },
  {
    path: '/sms',
    component: AdminLayout,
    redirect: '/sms/coupon',
    name: 'sms',
    meta: { title: '营销', icon: 's-cooperation' },
    children: [
      {
        path: 'flash',
        name: 'flash',
        component: () => import('@/views-admin/sms/flash/index'),
        meta: { title: '秒杀活动列表', icon: 's-cooperation' }
      },
      {
        path: 'flashSession',
        name: 'flashSession',
        component: () => import('@/views-admin/sms/flash/sessionList'),
        meta: { title: '秒杀时间段列表' },
        hidden: true
      },
      {
        path: 'selectSession',
        name: 'selectSession',
        component: () => import('@/views-admin/sms/flash/selectSessionList'),
        meta: { title: '秒杀时间段选择' },
        hidden: true
      },
      {
        path: 'flashProductRelation',
        name: 'flashProductRelation',
        component: () => import('@/views-admin/sms/flash/productRelationList'),
        meta: { title: '秒杀商品列表' },
        hidden: true
      },
      {
        path: 'coupon',
        name: 'coupon',
        component: () => import('@/views-admin/sms/coupon/index'),
        meta: { title: '优惠券列表', icon: 's-cooperation' }
      },
      {
        path: 'addCoupon',
        name: 'addCoupon',
        component: () => import('@/views-admin/sms/coupon/add'),
        meta: { title: '添加优惠券' },
        hidden: true
      },
      {
        path: 'updateCoupon',
        name: 'updateCoupon',
        component: () => import('@/views-admin/sms/coupon/update'),
        meta: { title: '修改优惠券' },
        hidden: true
      },
      {
        path: 'couponHistory',
        name: 'couponHistory',
        component: () => import('@/views-admin/sms/coupon/history'),
        meta: { title: '优惠券领取详情' },
        hidden: true
      },
      {
        path: 'brand',
        name: 'homeBrand',
        component: () => import('@/views-admin/sms/brand/index'),
        meta: { title: '品牌推荐', icon: 's-cooperation' }
      },
      {
        path: 'new',
        name: 'homeNew',
        component: () => import('@/views-admin/sms/new/index'),
        meta: { title: '新品推荐', icon: 's-cooperation' }
      },
      {
        path: 'hot',
        name: 'homeHot',
        component: () => import('@/views-admin/sms/hot/index'),
        meta: { title: '人气推荐', icon: 's-cooperation' }
      },
      {
        path: 'subject',
        name: 'homeSubject',
        component: () => import('@/views-admin/sms/subject/index'),
        meta: { title: '专题推荐', icon: 's-cooperation' }
      },
      {
        path: 'advertise',
        name: 'homeAdvertise',
        component: () => import('@/views-admin/sms/advertise/index'),
        meta: { title: '广告列表', icon: 's-cooperation' }
      },
      {
        path: 'addAdvertise',
        name: 'addHomeAdvertise',
        component: () => import('@/views-admin/sms/advertise/add'),
        meta: { title: '添加广告' },
        hidden: true
      },
      {
        path: 'updateAdvertise',
        name: 'updateHomeAdvertise',
        component: () => import('@/views-admin/sms/advertise/update'),
        meta: { title: '编辑广告' },
        hidden: true
      }
    ]
  },
  {
    path: '/ums',
    component: AdminLayout,
    redirect: '/ums/admin',
    name: 'ums',
    meta: { title: '权限', icon: 'setting' },
    children: [
      {
        path: 'admin',
        name: 'admin',
        component: () => import('@/views-admin/ums/admin/index'),
        meta: { title: '用户列表', icon: 'setting' }
      },
      {
        path: 'role',
        name: 'role',
        component: () => import('@/views-admin/ums/role/index'),
        meta: { title: '角色列表', icon: 'setting' }
      },
      {
        path: 'allocMenu',
        name: 'allocMenu',
        component: () => import('@/views-admin/ums/role/allocMenu'),
        meta: { title: '分配菜单' },
        hidden: true
      },
      {
        path: 'allocResource',
        name: 'allocResource',
        component: () => import('@/views-admin/ums/role/allocResource'),
        meta: { title: '分配资源' },
        hidden: true
      },
      {
        path: 'menu',
        name: 'menu',
        component: () => import('@/views-admin/ums/menu/index'),
        meta: { title: '菜单列表', icon: 'setting' }
      },
      {
        path: 'addMenu',
        name: 'addMenu',
        component: () => import('@/views-admin/ums/menu/add'),
        meta: { title: '添加菜单' },
        hidden: true
      },
      {
        path: 'updateMenu',
        name: 'updateMenu',
        component: () => import('@/views-admin/ums/menu/update'),
        meta: { title: '修改菜单' },
        hidden: true
      },
      {
        path: 'resource',
        name: 'resource',
        component: () => import('@/views-admin/ums/resource/index'),
        meta: { title: '资源列表', icon: 'setting' }
      },
      {
        path: 'resourceCategory',
        name: 'resourceCategory',
        component: () => import('@/views-admin/ums/resource/categoryList'),
        meta: { title: '资源分类' },
        hidden: true
      }
    ]
  },
  { path: '*', redirect: '/404', hidden: true }
]

export default adminRouter

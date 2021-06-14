import AdminLayout from '@/layout/admin'

const adminRouter = [
  {
    path: '/admin',
    component: AdminLayout,
    redirect: '/admin/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/admin/index'),
      meta: { title: 'Dashboard', icon: 'menu', auth: true }
    }]
  },
  {
    path: '/user',
    component: AdminLayout,
    redirect: '/user/index',
    name: 'UserManage',
    meta: { title: '用户管理', icon: 'user', auth: true },
    children: [
      {
        path: 'index',
        name: 'UserIndex',
        component: () => import('@/views/admin/mng-user/user/index'),
        meta: { title: '账号管理', icon: 'user' }
      },
      {
        path: 'role',
        name: 'UserRole',
        component: () => import('@/views/admin/mng-user/role/index'),
        meta: { title: '角色管理', icon: 'user' }
      },
      {
        path: 'auth',
        name: 'UserAuth',
        component: () => import('@/views/admin/mng-user/auth/index'),
        meta: { title: '权限管理', icon: 'user' }
      },
    ]
  },
  {
    path: '/sysmanage',
    component: AdminLayout,
    redirect: '/sysmanage/log',
    name: 'SysManage',
    meta: { title: '系统管理', icon: 'setting' },
    children: [
      {
        path: 'file',
        name: 'FileManage',
        component: () => import('@/views/admin/mng-system/file/index'),
        meta: { title: '文件管理', icon: 'files' }
      },
      {
        path: 'log',
        name: 'LogManage',
        component: () => import('@/views/admin/mng-system/log/index'),
        meta: { title: '日志管理', icon: 'document' }
      }
    ]
  },
  {
    path: '/product',
    component: AdminLayout,
    redirect: '/product/info',
    name: 'ProductManage',
    meta: { title: '商品管理', icon: 's-shop' },
    children: [
      {
        path: 'info',
        name: 'InfoManage',
        component: () => import('@/views/admin/mng-product/product-info/index'),
        meta: { title: '商品信息', icon: 's-shop' }
      },
      {
        path: 'category',
        name: 'CategoryManage',
        component: () => import('@/views/admin/mng-product/category/index'),
        meta: { title: '分类信息', icon: 's-shop' }
      },
      {
        path: 'pic',
        name: 'PicManage',
        component: () => import('@/views/admin/mng-product/pic/index'),
        meta: { title: '图片信息', icon: 's-shop' }
      }
    ]
  },
  {
    path: '/oms',
    component: AdminLayout,
    redirect: '/oms/index',
    name: 'Order',
    meta: { title: '订单管理', icon: 'setting' },
    children: [
      {
        path: 'index',
        name: 'order',
        component: () => import('@/views/oms/order/index'),
        meta: { title: 'order', icon: 'warning' }
      }
    ]
  },
]

export default adminRouter

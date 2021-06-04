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
  // {
  //   path: '/sysconfig',
  //   component: AdminLayout,
  //   redirect: '/sysconfig/index',
  //   name: 'SysConfig',
  //   meta: { title: '系统设置', icon: 'setting' },
  //   children: [
  //     {
  //       // path: 'tree',
  //       // name: 'Tree',
  //       // component: () => import('@/views/admin/tree/index'),
  //       // meta: { title: 'Tree', icon: 'warning' }
  //     }
  //   ]
  // },
  // {
  //   path: '/nested',
  //   component: AdminLayout,
  //   redirect: '/nested/menu1',
  //   name: 'Nested',
  //   meta: {
  //     title: 'Nested',
  //     icon: 'warning'
  //   },
  //   children: [
  //     {
  //       path: 'menu1',
  //       component: () => import('@/views/admin/nested/menu1/index'), // Parent router-view
  //       name: 'Menu1',
  //       meta: { title: 'Menu1' },
  //       children: [
  //         {
  //           path: 'menu1-1',
  //           component: () => import('@/views/admin/nested/menu1/menu1-1'),
  //           name: 'Menu1-1',
  //           meta: { title: 'Menu1-1' }
  //         },
  //         {
  //           path: 'menu1-2',
  //           component: () => import('@/views/admin/nested/menu1/menu1-2'),
  //           name: 'Menu1-2',
  //           meta: { title: 'Menu1-2' },
  //           children: [
  //             {
  //               path: 'menu1-2-1',
  //               component: () => import('@/views/admin/nested/menu1/menu1-2/menu1-2-1'),
  //               name: 'Menu1-2-1',
  //               meta: { title: 'Menu1-2-1' }
  //             },
  //             {
  //               path: 'menu1-2-2',
  //               component: () => import('@/views/admin/nested/menu1/menu1-2/menu1-2-2'),
  //               name: 'Menu1-2-2',
  //               meta: { title: 'Menu1-2-2' }
  //             }
  //           ]
  //         },
  //         {
  //           path: 'menu1-3',
  //           component: () => import('@/views/admin/nested/menu1/menu1-3'),
  //           name: 'Menu1-3',
  //           meta: { title: 'Menu1-3' }
  //         }
  //       ]
  //     },
  //     {
  //       path: 'menu2',
  //       component: () => import('@/views/admin/nested/menu2/index'),
  //       meta: { title: 'menu2' }
  //     }
  //   ]
  // }
]

export default adminRouter

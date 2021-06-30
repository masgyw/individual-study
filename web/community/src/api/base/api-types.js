const apiTypes = {
  // rest about
  // POST: '/dev/rest/post',
  POST: '/rest/post',
  COMMENT: '/rest/comment',
  REPLY: '/rest/reply',

  // ums_*：会员模块相关
  USER: '/system/user',
  LOG: '/system/log',
  ROLE: '/system/role',
  FILE_INFO: '/system/fileInfo',
  UMS_ADMIN: '/system/admin',
  UMS_ROLE: '/system/role',
  UMS_MENU: '/system/menu',
  UMS_RESOURCE: '/system/resource',
  UMS_RESOUCE_CATE: '/system/resourceCategory',

  // pms_*：商品模块相关
  PRODUCT_INFO: '/product/info',
  PRODUCT_ATTR: '/product/attr',
  PRODUCT_CATEGORY: '/product/category',
  PRODUCT_BRAND: '/product/brand',
  PRODUCT_SKU: '/product/sku',
  
  // oms_*：订单管理模块相关
  // cms_*：内容管理模块相关
  // sms_*：营销模块相关
}

// mock user api
apiTypes.UMS_ADMIN = '/dev/user'

export default apiTypes;
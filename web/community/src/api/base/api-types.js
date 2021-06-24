const apiTypes = {
  // rest about
  // POST: '/dev/rest/post',
  POST: '/rest/post',
  COMMENT: '/rest/comment',
  REPLY: '/rest/reply',

  // system about
  USER: '/system/user',
  LOG: '/system/log',
  ROLE: '/system/role',
  FILE_INFO: '/system/fileInfo',
  UMS_ADMIN: '/system/admin',

  // product about
  PRODUCT_INFO: '/product/info',
  PRODUCT_ATTR: '/product/attr',
  PRODUCT_CATEGORY: '/product/category',
  PRODUCT_BRAND: '/product/brand',
  PRODUCT_SKU: '/product/sku',
  
}

// mock user api
apiTypes.USER = '/dev/user'

export default apiTypes;
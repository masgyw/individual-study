const apiTypes = {
  // rest about
  // POST: '/dev/rest/post',
  POST: '/rest/post',
  COMMENT: '/rest/comment',
  REPLY: '/rest/reply',

  // ums_*：会员模块相关
  USER: '/ums/user',
  LOG: '/ums/log',
  ROLE: '/ums/role',
  FILE_INFO: '/ums/fileInfo',
  UMS_ADMIN: '/ums/admin',
  UMS_ROLE: '/ums/role',
  UMS_MENU: '/ums/menu',
  UMS_RESOURCE: '/ums/resource',
  UMS_RESOUCE_CATE: '/ums/resourceCategory',
  UMS_MEMBER_LEVEL: '/ums/memberLevel',

  // pms_*：商品模块相关
  PMS_INFO: '/pms/info',
  PMS_ATTR: '/pms/attr',
  PMS_ATTR_CATE: '/pms/attrCate',
  PMS_CATEGORY: '/pms/category',
  PMS_BRAND: '/pms/brand',
  PMS_SKU: '/pms/sku',
  
  // oms_*：订单管理模块相关
  // cms_*：内容管理模块相关
  CMS_SUBJECT: '/cms/subject',
  CMS_PREFRENCE_AREA: '/cms/prefrenceArea',
  // sms_*：营销模块相关
}

// mock user api
// apiTypes.UMS_ADMIN = '/dev/user'

export default apiTypes;
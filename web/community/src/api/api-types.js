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

  // product about
  PRODUCT: '/product',
  
}

// mock user api
apiTypes.USER = '/dev/user'

export default apiTypes;
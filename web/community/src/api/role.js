import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class RoleApi extends BaseApi {

  constructor() {
    super(apiTypes.UMS_ROLE);
  }

 listMenuByRole(roleId) {
    return request({
      url: this.src + '/listMenu/'+roleId,
      method: 'get'
    })
  }
  
 listResourceByRole(roleId) {
    return request({
      url: this.src + '/listResource/'+roleId,
      method: 'get'
    })
  }
  
 allocMenu(data) {
    return request({
      url: this.src + '/allocMenu',
      method: 'post',
      data:data
    })
  }

 allocResource(data) {
    return request({
      url: this.src + '/allocResource',
      method: 'post',
      data:data
    })
  }
}

export function createRole(data) {
  return request({
    url: this.src + '/create',
    method: 'post',
    data: data
  })
}

export function updateRole(id, data) {
  return request({
    url: this.src + '/update/' + id,
    method: 'post',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: this.src + '/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteRole(data) {
  return request({
    url:this.src + '/delete',
    method:'post',
    data:data
  })
}

export function fetchAllRoleList() {
  return request({
    url: this.src + '/listAll',
    method: 'get'
  })
}

let logger = LoggerFactory.getLogger(apiTypes.UMS_ROLE)
let roleApi = new RoleApi();

export {
  roleApi
}
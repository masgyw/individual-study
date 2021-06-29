import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class AdminApi extends BaseApi {

  constructor() {
    super(apiTypes.UMS_ADMIN);
  }

  login({ username, password }) {
    return request({
      url: this.src + '/login',
      method: 'post',
      data: {
        username,
        password
      }
    })
  }

  getInfo() {
    return request({
      url: this.src + '/info',
      method: 'get',
    })
  }

  logout() {
    return request({
      url: this.src + '/logout',
      method: 'post'
    })
  }

  allocRole(data) {
    return request({
      url: this.src + '/allocRole',
      method: 'post',
      data: data
    })
  }

  // ---old
  createAdmin(data) {
    return request({
      url: this.src + '/register',
      method: 'post',
      data: data
    })
  }

  updateAdmin(id, data) {
    return request({
      url: this.src + '/update/' + id,
      method: 'post',
      data: data
    })
  }

  updateStatus(id, params) {
    return request({
      url: this.src + '/updateStatus/' + id,
      method: 'post',
      params: params
    })
  }

  deleteAdmin(id) {
    return request({
      url: this.src + '/delete/' + id,
      method: 'post'
    })
  }

  getRoleByAdmin(id) {
    return request({
      url: this.src + '/role/' + id,
      method: 'get'
    })
  }

}

let logger = LoggerFactory.getLogger(apiTypes.UMS_ADMIN)
let adminApi = new AdminApi();

export {
  adminApi
}

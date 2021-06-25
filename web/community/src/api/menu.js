import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class MenuApi extends BaseApi {

  constructor() {
    super(apiTypes.UMS_MENU);
  }

  fetchTreeList() {
    return request({
      url: this.src + '/treeList',
      method: 'get'
    })
  }

  deleteMenu(id) {
    return request({
      url: '/delete/' + id,
      method: 'post'
    })
  }
  
  createMenu(data) {
    return request({
      url: '/create',
      method: 'post',
      data: data
    })
  }
  
  updateMenu(id, data) {
    return request({
      url: '/update/' + id,
      method: 'post',
      data: data
    })
  }
  
  getMenu(id) {
    return request({
      url: '/' + id,
      method: 'get',
    })
  }
  
  updateHidden(id, params) {
    return request({
      url: '/updateHidden/' + id,
      method: 'post',
      params: params
    })
  }
}

let logger = LoggerFactory.getLogger(apiTypes.UMS_MENU)
let menuApi = new MenuApi();

export {
  menuApi
}
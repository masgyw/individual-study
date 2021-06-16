import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class BrandApi extends BaseApi {

  constructor() {
    super(apiTypes.PRODUCT_BRAND);
  }

  createBrand(data) {
    return request({
      url: '/brand/create',
      method: 'post',
      data: data
    })
  }
  updateShowStatus(data) {
    return request({
      url: '/brand/update/showStatus',
      method: 'post',
      data: data
    })
  }

  updateFactoryStatus(data) {
    return request({
      url: '/brand/update/factoryStatus',
      method: 'post',
      data: data
    })
  }

  deleteBrand(id) {
    return request({
      url: '/brand/delete/' + id,
      method: 'get',
    })
  }

  getBrand(id) {
    return request({
      url: '/brand/' + id,
      method: 'get',
    })
  }

  updateBrand(id, data) {
    return request({
      url: '/brand/update/' + id,
      method: 'post',
      data: data
    })
  }
}

let logger = LoggerFactory.getLogger(apiTypes.PRODUCT_BRAND)
let brandApi = new BrandApi();

export {
  brandApi
}


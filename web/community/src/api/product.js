import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class ProductApi extends BaseApi {

  constructor() {
    super(apiTypes.PMS_INFO);
  }

  batchUpdate(params) {
    return request({
      url: this.src + '/batch',
      method: 'post',
      data: params
    });
  }

  fetchSimpleList(params) {
    return request({
      url: '/simpleList',
      method: 'get',
      params: params
    })
  }
}

let logger = LoggerFactory.getLogger(apiTypes.PMS_INFO)
let productApi = new ProductApi();

export {
  productApi
}
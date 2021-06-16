import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class ProductApi extends BaseApi {

  constructor() {
    super(apiTypes.PRODUCT_INFO);
  }

  fetchSimpleList(params) {
    return request({
      url: '/simpleList',
      method: 'get',
      params: params
    })
  }

  updateDeleteStatus(params) {
    return request({
      url: '/update/deleteStatus',
      method: 'post',
      params: params
    })
  }

  updateNewStatus(params) {
    return request({
      url: '/update/newStatus',
      method: 'post',
      params: params
    })
  }

  updateRecommendStatus(params) {
    return request({
      url: '/update/recommendStatus',
      method: 'post',
      params: params
    })
  }

  updatePublishStatus(params) {
    return request({
      url: '/update/publishStatus',
      method: 'post',
      params: params
    })
  }

  createProduct(data) {
    return request({
      url: '/create',
      method: 'post',
      data: data
    })
  }

  updateProduct(id, data) {
    return request({
      url: '/update/' + id,
      method: 'post',
      data: data
    })
  }

  getProduct(id) {
    return request({
      url: '/updateInfo/' + id,
      method: 'get',
    })
  }
}

let logger = LoggerFactory.getLogger(apiTypes.PRODUCT_INFO)
let productApi = new ProductApi();

export {
  productApi
}
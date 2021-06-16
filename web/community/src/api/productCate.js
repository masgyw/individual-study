import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger"
import BaseApi from './base/BaseApi'

class ProductCateApi extends BaseApi {
  constructor() {
    super(apiTypes.PRODUCT_CATEGORY);
  }

  // deleteProductCate(id) {
  //   return request({
  //     url: '/delete/' + id,
  //     method: 'post'
  //   })
  // }

  // createProductCate(data) {
  //   return request({
  //     url: '/create',
  //     method: 'post',
  //     data: data
  //   })
  // }

  // updateProductCate(id, data) {
  //   return request({
  //     url: '/update/' + id,
  //     method: 'post',
  //     data: data
  //   })
  // }

  // getProductCate(id) {
  //   return request({
  //     url: '/' + id,
  //     method: 'get',
  //   })
  // }

  // updateShowStatus(data) {
  //   return request({
  //     url: '/update/showStatus',
  //     method: 'post',
  //     data: data
  //   })
  // }

  // updateNavStatus(data) {
  //   return request({
  //     url: '/update/navStatus',
  //     method: 'post',
  //     data: data
  //   })
  // }

  getWithChildren() {
    return request({
      url: this.src + '/children',
      method: 'get'
    })
  }

}

let logger = LoggerFactory.getLogger(apiTypes.PRODUCT_CATEGORY)
let productCateApi = new ProductCateApi();

export {
  productCateApi
}


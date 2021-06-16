import request from '@/utils/request'
import BaseApi from './base/BaseApi'
import LoggerFactory from "./base/logger"
import apiTypes from './base/api-types'

class ProductAttrApi extends BaseApi {

  constructor() {
    super(apiTypes.PRODUCT_ATTR);
  }
  
  deleteProductAttr(data) {
    return request({
      url:'/delete',
      method:'post',
      data:data
    })
  }
  
  createProductAttr(data) {
    return request({
      url:'/create',
      method:'post',
      data:data
    })
  }
  
  updateProductAttr(id,data) {
    return request({
      url:'/update/'+id,
      method:'post',
      data:data
    })
  }
  getProductAttr(id) {
    return request({
      url:'/'+id,
      method:'get'
    })
  }
  
  getProductAttrInfo(productCategoryId) {
    return request({
      url:'/attrInfo/'+productCategoryId,
      method:'get'
    })
  }
}

let logger = LoggerFactory.getLogger(apiTypes.PRODUCT_ATTR)
let productAttrApi = new ProductAttrApi();

export {
  productAttrApi
}

import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class ProductAttrCateApi extends BaseApi {

  constructor() {
    super(apiTypes.PMS_ATTR_CATE);
  }
  
}

let logger = LoggerFactory.getLogger(apiTypes.PMS_ATTR_CATE)
let productAttrCateApi = new ProductAttrCateApi();

export {
  productAttrCateApi
}

export function fetchList(params) {
  return request({
    url:'/productAttribute/category/list',
    method:'get',
    params:params
  })
}

export function createProductAttrCate(data) {
  return request({
    url:'/productAttribute/category/create',
    method:'post',
    data:data
  })
}

export function deleteProductAttrCate(id) {
  return request({
    url:'/productAttribute/category/delete/'+id,
    method:'get'
  })
}

export function updateProductAttrCate(id,data) {
  return request({
    url:'/productAttribute/category/update/'+id,
    method:'post',
    data:data
  })
}
export function fetchListWithAttr() {
  return request({
    url:'/productAttribute/category/list/withAttr',
    method:'get'
  })
}

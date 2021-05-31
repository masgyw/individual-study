import request from '@/utils/request'
import apiTypes from './api-types'

// 轮播图数据
export function carousel(data) {
  return request({
    url: apiTypes.PRODUCT + '/carousel',
    method: 'GET',
    data: data
  });
}
// 促销商品
export function promo(params) {
  return request({
    url: apiTypes.PRODUCT + '/product/promo',
    method: 'POST',
    data: params
  });
}

export function hot(params) {
  return request({
    url: apiTypes.PRODUCT + '/product/hot',
    method: 'POST',
    data: params
  });
}
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
export function promo(data) {
  return request({
    url: apiTypes.PRODUCT + '/info/promo',
    method: 'POST',
    data
  });
}

export function hot(params) {
  return request({
    url: apiTypes.PRODUCT + '/info/hot',
    method: 'POST',
    data: params
  });
}

export function add(data) {
  return request({
    url: apiTypes.PRODUCT + '/info',
    method: 'POST',
    data: JSON.stringify(data),
    header: {
      'Content-Type': 'application/json'
    }
  });
}
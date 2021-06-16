import request from '@/utils/request'
import apiTypes from './base/api-types'


export function login(data) {
  return request({
    url: apiTypes.USER + '/login',
    method: 'POST',
    data: data
  });
}

export function getInfo(token) {
  return request({
    url: apiTypes.USER + '/token',
    method: 'GET',
    params: { token }
  })
}

export function logout(token) {
  return request({
    url: apiTypes.USER + '/logout',
    method: 'POST',
    data: {token : token}
  })
}

export function register(data) {
  return request({
    url: apiTypes.USER + '/register',
    method: 'POST',
    data: data,
    headers: { "Content-Type": "application/json;charset=UTF-8" }
  });
}

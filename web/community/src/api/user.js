import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/community/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/community/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/community/user/logout',
    method: 'post'
  })
}

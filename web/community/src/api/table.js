import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/community/table/list',
    method: 'get',
    params
  })
}

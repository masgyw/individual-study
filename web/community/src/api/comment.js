// 回复
import request from '@/utils/request'
import apiTypes from '@/api/base/api-types'

export function getComments(postId) {
  return request({
    url: apiTypes.COMMENT + '/' + postId,
    method: 'GET',
    params: {}
  })
}
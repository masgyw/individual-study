import request from '@/utils/request'

export function getOnlineUsers() {
  return request({
    url: '/chat-info/onlineUsers',
    method: 'get'
  })
}

export function getOfflineCount(userId) {
  return request({
    url: '/chat-info/offlineCount/' + userId,
    method: 'get'
  })
}

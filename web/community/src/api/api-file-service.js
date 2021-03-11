import axios from 'axios'
import request from '@/utils/request'

export function uploadFile(fd) {
  return axios.post('/file/upload', fd, {
    headers: { "content-type": "multipart/form-data" }
  });
}

export function queryAllMd() {
  return request({
    url: "/file/md",
    method: 'GET'
  })
}
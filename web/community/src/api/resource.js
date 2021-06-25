import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class ResourceApi extends BaseApi {

  constructor() {
    super(apiTypes.UMS_RESOURCE);
  }

}

let logger = LoggerFactory.getLogger(apiTypes.UMS_RESOURCE)
let resourceApi = new ResourceApi();

export {
  resourceApi
}


export function createResource(data) {
  return request({
    url: '/resource/create',
    method: 'post',
    data: data
  })
}

export function updateResource(id, data) {
  return request({
    url: '/resource/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteResource(id) {
  return request({
    url: '/resource/delete/' + id,
    method: 'post'
  })
}

export function fetchAllResourceList() {
  return request({
    url: '/resource/listAll',
    method: 'get'
  })
}

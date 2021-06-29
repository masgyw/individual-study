import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class ResourceCategoryApi extends BaseApi {

  constructor() {
    super(apiTypes.UMS_RESOUCE_CATE);
  }

}

let logger = LoggerFactory.getLogger(apiTypes.UMS_RESOUCE_CATE)
let resourceCategoryApi = new ResourceCategoryApi();

export {
  resourceCategoryApi
}

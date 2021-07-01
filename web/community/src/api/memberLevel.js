import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class MemberLevelApi extends BaseApi {
  constructor() {
    super(apiTypes.UMS_MEMBER_LEVEL);
  }
}
let logger = LoggerFactory.getLogger(apiTypes.UMS_MEMBER_LEVEL)
let memberLevelApi = new MemberLevelApi();

export {
  memberLevelApi
}


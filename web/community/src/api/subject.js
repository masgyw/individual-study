import BaseApi from './base/BaseApi'
import request from '@/utils/request'
import apiTypes from './base/api-types'
import LoggerFactory from "./base/logger";

class SubjectApi extends BaseApi {
  constructor() {
    super(apiTypes.CMS_SUBJECT);
  }
}
let logger = LoggerFactory.getLogger(apiTypes.CMS_SUBJECT)
let subjectApi = new SubjectApi();

export {
  subjectApi
}

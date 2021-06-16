import request from '@/utils/request'
import BaseApi from './base/BaseApi'
import LoggerFactory from "./base/logger"
import apiTypes from './base/api-types';

class SkuStockApi extends BaseApi {

  constructor() {
    super(apiTypes.PRODUCT_SKU);
  }

}

let logger = LoggerFactory.getLogger(apiTypes.PRODUCT_SKU)
let skuStockApi = new SkuStockApi();

export {
  skuStockApi
}

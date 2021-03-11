package cn.gyw.community.product.info.service;

import cn.gyw.community.product.api.ProductInfoService;
import cn.gyw.community.product.info.model.Product;

import java.util.List;

public interface LocalProductInfoService extends ProductInfoService {

    List<Product> getProductPics(String category);
}

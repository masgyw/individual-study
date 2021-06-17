package cn.gyw.community.product.entity;

import java.util.List;

public class ProductCategoryWithChildren extends ProductCategory {

    private List<ProductCategory> children;

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }
}

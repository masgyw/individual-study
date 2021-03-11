package cn.gyw.community.product.category.model;

public class ProductCategoryDto {
    /**
     * 分类ID
     * 
     * 表字段: product_category.category_id
     */
    private Short categoryId;

    /**
     * 分类名称
     * 
     * 表字段: product_category.category_name
     */
    private String categoryName;

    /**
     * 分类编码
     * 
     * 表字段: product_category.category_code
     */
    private String categoryCode;

    /**
     * 分类状态
     * 
     * 表字段: product_category.category_status
     */
    private Byte categoryStatus;

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Byte getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    @Override
    public String toString() {
        return "ProductCategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryStatus=" + categoryStatus +
                '}';
    }
}
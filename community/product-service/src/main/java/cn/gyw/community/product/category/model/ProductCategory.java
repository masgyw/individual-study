package cn.gyw.community.product.category.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductCategory {
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
     * 父分类ID
     * 
     * 表字段: product_category.parent_id
     */
    private Short parentId;

    /**
     * 分类层级
     * 
     * 表字段: product_category.category_level
     */
    private Byte categoryLevel;

    /**
     * 分类状态
     * 
     * 表字段: product_category.category_status
     */
    private Byte categoryStatus;

    /**
     * 最后修改时间
     * 
     * 表字段: product_category.modified_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

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

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Byte getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", parentId=" + parentId +
                ", categoryLevel=" + categoryLevel +
                ", categoryStatus=" + categoryStatus +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
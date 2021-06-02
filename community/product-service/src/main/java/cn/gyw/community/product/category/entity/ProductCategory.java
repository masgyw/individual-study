package cn.gyw.community.product.category.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_category")
public class ProductCategory {
    /**
     * 分类ID
     */
    @Id
    @Column(name = "category_id")
    private Short categoryId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类编码
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 父分类ID
     */
    @Column(name = "parent_id")
    private Short parentId;

    /**
     * 分类层级
     */
    @Column(name = "category_level")
    private Byte categoryLevel;

    /**
     * 分类状态
     */
    @Column(name = "category_status")
    private Byte categoryStatus;

    /**
     * 最后修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Short getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取分类编码
     *
     * @return category_code - 分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置分类编码
     *
     * @param categoryCode 分类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    /**
     * 获取父分类ID
     *
     * @return parent_id - 父分类ID
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * 设置父分类ID
     *
     * @param parentId 父分类ID
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分类层级
     *
     * @return category_level - 分类层级
     */
    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    /**
     * 设置分类层级
     *
     * @param categoryLevel 分类层级
     */
    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    /**
     * 获取分类状态
     *
     * @return category_status - 分类状态
     */
    public Byte getCategoryStatus() {
        return categoryStatus;
    }

    /**
     * 设置分类状态
     *
     * @param categoryStatus 分类状态
     */
    public void setCategoryStatus(Byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    /**
     * 获取最后修改时间
     *
     * @return modified_time - 最后修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param modifiedTime 最后修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
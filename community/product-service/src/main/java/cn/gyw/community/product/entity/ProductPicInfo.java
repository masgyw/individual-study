package cn.gyw.community.product.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_pic_info")
public class ProductPicInfo {
    /**
     * 商品图片ID
     */
    @Id
    @Column(name = "product_pic_id")
    private Integer productPicId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 图片描述
     */
    @Column(name = "pic_desc")
    private String picDesc;

    /**
     * 图片URL
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 是否主图：0.非主图1.主图
     */
    @Column(name = "is_master")
    private Byte isMaster;

    /**
     * 图片排序
     */
    @Column(name = "pic_order")
    private Byte picOrder;

    /**
     * 图片是否有效：0无效 1有效
     */
    @Column(name = "pic_status")
    private Byte picStatus;

    /**
     * 最后修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * 获取商品图片ID
     *
     * @return product_pic_id - 商品图片ID
     */
    public Integer getProductPicId() {
        return productPicId;
    }

    /**
     * 设置商品图片ID
     *
     * @param productPicId 商品图片ID
     */
    public void setProductPicId(Integer productPicId) {
        this.productPicId = productPicId;
    }

    /**
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取图片描述
     *
     * @return pic_desc - 图片描述
     */
    public String getPicDesc() {
        return picDesc;
    }

    /**
     * 设置图片描述
     *
     * @param picDesc 图片描述
     */
    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }

    /**
     * 获取图片URL
     *
     * @return pic_url - 图片URL
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片URL
     *
     * @param picUrl 图片URL
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取是否主图：0.非主图1.主图
     *
     * @return is_master - 是否主图：0.非主图1.主图
     */
    public Byte getIsMaster() {
        return isMaster;
    }

    /**
     * 设置是否主图：0.非主图1.主图
     *
     * @param isMaster 是否主图：0.非主图1.主图
     */
    public void setIsMaster(Byte isMaster) {
        this.isMaster = isMaster;
    }

    /**
     * 获取图片排序
     *
     * @return pic_order - 图片排序
     */
    public Byte getPicOrder() {
        return picOrder;
    }

    /**
     * 设置图片排序
     *
     * @param picOrder 图片排序
     */
    public void setPicOrder(Byte picOrder) {
        this.picOrder = picOrder;
    }

    /**
     * 获取图片是否有效：0无效 1有效
     *
     * @return pic_status - 图片是否有效：0无效 1有效
     */
    public Byte getPicStatus() {
        return picStatus;
    }

    /**
     * 设置图片是否有效：0无效 1有效
     *
     * @param picStatus 图片是否有效：0无效 1有效
     */
    public void setPicStatus(Byte picStatus) {
        this.picStatus = picStatus;
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
package cn.gyw.community.product.info.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_info")
public class ProductInfo {
    /**
     * 商品ID
     */
    @Id
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品编码
     */
    @Column(name = "product_core")
    private String productCore;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 国条码
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * 品牌表的ID
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 一级分类ID
     */
    @Column(name = "one_category_id")
    private Short oneCategoryId;

    /**
     * 二级分类ID
     */
    @Column(name = "two_category_id")
    private Short twoCategoryId;

    /**
     * 三级分类ID
     */
    @Column(name = "three_category_id")
    private Short threeCategoryId;

    /**
     * 商品的供应商ID
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 商品销售价格
     */
    private BigDecimal price;

    /**
     * 商品加权平均成本
     */
    @Column(name = "average_cost")
    private BigDecimal averageCost;

    /**
     * 上下架状态：0下架1上架
     */
    @Column(name = "publish_status")
    private Byte publishStatus;

    /**
     * 审核状态：0未审核，1已审核
     */
    @Column(name = "audit_status")
    private Byte auditStatus;

    /**
     * 商品重量
     */
    private Float weight;

    /**
     * 商品长度
     */
    private Float length;

    /**
     * 商品高度
     */
    private Float height;

    /**
     * 商品宽度
     */
    private Float width;

    @Column(name = "color_type")
    private String colorType;

    /**
     * 生产日期
     */
    @Column(name = "production_date")
    private Date productionDate;

    /**
     * 商品有效期
     */
    @Column(name = "shelf_life")
    private Integer shelfLife;

    /**
     * 商品录入时间
     */
    private Date indate;

    /**
     * 最后修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * 商品描述
     */
    private String descript;

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
     * 获取商品编码
     *
     * @return product_core - 商品编码
     */
    public String getProductCore() {
        return productCore;
    }

    /**
     * 设置商品编码
     *
     * @param productCore 商品编码
     */
    public void setProductCore(String productCore) {
        this.productCore = productCore == null ? null : productCore.trim();
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取国条码
     *
     * @return bar_code - 国条码
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * 设置国条码
     *
     * @param barCode 国条码
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    /**
     * 获取品牌表的ID
     *
     * @return brand_id - 品牌表的ID
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌表的ID
     *
     * @param brandId 品牌表的ID
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取一级分类ID
     *
     * @return one_category_id - 一级分类ID
     */
    public Short getOneCategoryId() {
        return oneCategoryId;
    }

    /**
     * 设置一级分类ID
     *
     * @param oneCategoryId 一级分类ID
     */
    public void setOneCategoryId(Short oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    /**
     * 获取二级分类ID
     *
     * @return two_category_id - 二级分类ID
     */
    public Short getTwoCategoryId() {
        return twoCategoryId;
    }

    /**
     * 设置二级分类ID
     *
     * @param twoCategoryId 二级分类ID
     */
    public void setTwoCategoryId(Short twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    /**
     * 获取三级分类ID
     *
     * @return three_category_id - 三级分类ID
     */
    public Short getThreeCategoryId() {
        return threeCategoryId;
    }

    /**
     * 设置三级分类ID
     *
     * @param threeCategoryId 三级分类ID
     */
    public void setThreeCategoryId(Short threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    /**
     * 获取商品的供应商ID
     *
     * @return supplier_id - 商品的供应商ID
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置商品的供应商ID
     *
     * @param supplierId 商品的供应商ID
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 获取商品销售价格
     *
     * @return price - 商品销售价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品销售价格
     *
     * @param price 商品销售价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取商品加权平均成本
     *
     * @return average_cost - 商品加权平均成本
     */
    public BigDecimal getAverageCost() {
        return averageCost;
    }

    /**
     * 设置商品加权平均成本
     *
     * @param averageCost 商品加权平均成本
     */
    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    /**
     * 获取上下架状态：0下架1上架
     *
     * @return publish_status - 上下架状态：0下架1上架
     */
    public Byte getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置上下架状态：0下架1上架
     *
     * @param publishStatus 上下架状态：0下架1上架
     */
    public void setPublishStatus(Byte publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取审核状态：0未审核，1已审核
     *
     * @return audit_status - 审核状态：0未审核，1已审核
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态：0未审核，1已审核
     *
     * @param auditStatus 审核状态：0未审核，1已审核
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取商品重量
     *
     * @return weight - 商品重量
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * 设置商品重量
     *
     * @param weight 商品重量
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * 获取商品长度
     *
     * @return length - 商品长度
     */
    public Float getLength() {
        return length;
    }

    /**
     * 设置商品长度
     *
     * @param length 商品长度
     */
    public void setLength(Float length) {
        this.length = length;
    }

    /**
     * 获取商品高度
     *
     * @return height - 商品高度
     */
    public Float getHeight() {
        return height;
    }

    /**
     * 设置商品高度
     *
     * @param height 商品高度
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * 获取商品宽度
     *
     * @return width - 商品宽度
     */
    public Float getWidth() {
        return width;
    }

    /**
     * 设置商品宽度
     *
     * @param width 商品宽度
     */
    public void setWidth(Float width) {
        this.width = width;
    }

    /**
     * @return color_type
     */
    public String getColorType() {
        return colorType;
    }

    /**
     * @param colorType
     */
    public void setColorType(String colorType) {
        this.colorType = colorType == null ? null : colorType.trim();
    }

    /**
     * 获取生产日期
     *
     * @return production_date - 生产日期
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * 设置生产日期
     *
     * @param productionDate 生产日期
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * 获取商品有效期
     *
     * @return shelf_life - 商品有效期
     */
    public Integer getShelfLife() {
        return shelfLife;
    }

    /**
     * 设置商品有效期
     *
     * @param shelfLife 商品有效期
     */
    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * 获取商品录入时间
     *
     * @return indate - 商品录入时间
     */
    public Date getIndate() {
        return indate;
    }

    /**
     * 设置商品录入时间
     *
     * @param indate 商品录入时间
     */
    public void setIndate(Date indate) {
        this.indate = indate;
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

    /**
     * 获取商品描述
     *
     * @return descript - 商品描述
     */
    public String getDescript() {
        return descript;
    }

    /**
     * 设置商品描述
     *
     * @param descript 商品描述
     */
    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}
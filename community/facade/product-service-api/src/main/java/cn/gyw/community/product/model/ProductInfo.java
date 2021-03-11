package cn.gyw.community.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String PRODUCT_ID = "productId";
	public static final String PRODUCT_CORE = "productCore";
	
    /**
     * <pre>
     * 商品ID
     * 表字段: product_info.product_id
     * </pre>
     * 
     */
    private Integer productId;

    /**
     * <pre>
     * 商品编码
     * 表字段: product_info.product_core
     * </pre>
     * 
     */
    private String productCore;

    /**
     * <pre>
     * 商品名称
     * 表字段: product_info.product_name
     * </pre>
     * 
     */
    private String productName;

    /**
     * <pre>
     * 国条码
     * 表字段: product_info.bar_code
     * </pre>
     * 
     */
    private String barCode;

    /**
     * <pre>
     * 品牌表的ID
     * 表字段: product_info.brand_id
     * </pre>
     * 
     */
    private Integer brandId;

    /**
     * <pre>
     * 一级分类ID
     * 表字段: product_info.one_category_id
     * </pre>
     * 
     */
    private Short oneCategoryId;

    /**
     * <pre>
     * 二级分类ID
     * 表字段: product_info.two_category_id
     * </pre>
     * 
     */
    private Short twoCategoryId;

    /**
     * <pre>
     * 三级分类ID
     * 表字段: product_info.three_category_id
     * </pre>
     * 
     */
    private Short threeCategoryId;

    /**
     * <pre>
     * 商品的供应商ID
     * 表字段: product_info.supplier_id
     * </pre>
     * 
     */
    private Integer supplierId;

    /**
     * <pre>
     * 商品销售价格
     * 表字段: product_info.price
     * </pre>
     * 
     */
    private BigDecimal price;

    /**
     * <pre>
     * 商品加权平均成本
     * 表字段: product_info.average_cost
     * </pre>
     * 
     */
    private BigDecimal averageCost;

    /**
     * <pre>
     * 上下架状态：0下架1上架
     * 表字段: product_info.publish_status
     * </pre>
     * 
     */
    private Byte publishStatus;

    /**
     * <pre>
     * 审核状态：0未审核，1已审核
     * 表字段: product_info.audit_status
     * </pre>
     * 
     */
    private Byte auditStatus;

    /**
     * <pre>
     * 商品重量
     * 表字段: product_info.weight
     * </pre>
     * 
     */
    private Float weight;

    /**
     * <pre>
     * 商品长度
     * 表字段: product_info.length
     * </pre>
     * 
     */
    private Float length;

    /**
     * <pre>
     * 商品高度
     * 表字段: product_info.height
     * </pre>
     * 
     */
    private Float height;

    /**
     * <pre>
     * 商品宽度
     * 表字段: product_info.width
     * </pre>
     * 
     */
    private Float width;

    /**
     * <pre>
     * 
     * 表字段: product_info.color_type
     * </pre>
     * 
     */
    private String colorType;

    /**
     * <pre>
     * 生产日期
     * 表字段: product_info.production_date
     * </pre>
     * 
     */
    private Date productionDate;

    /**
     * <pre>
     * 商品有效期
     * 表字段: product_info.shelf_life
     * </pre>
     * 
     */
    private Integer shelfLife;

    /**
     * <pre>
     * 商品录入时间
     * 表字段: product_info.indate
     * </pre>
     * 
     */
    private Date indate;

    /**
     * <pre>
     * 最后修改时间
     * 表字段: product_info.modified_time
     * </pre>
     * 
     */
    private Date modifiedTime;

    /**
     * <pre>
     * 商品描述
     * 表字段: product_info.descript
     * </pre>
     * 
     */
    private String descript;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore == null ? null : productCore.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Short getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Short oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public Short getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Short twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public Short getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Short threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public Byte getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Byte publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType == null ? null : colorType.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}
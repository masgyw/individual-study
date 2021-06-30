package cn.gyw.community.product.dto;

import java.math.BigDecimal;

public class SkuStockDto {

    private Long id;

    private Long productId;

    /**
     * sku编码
     */
    private String skuCode;

    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 预警库存
     */
    private Integer lowStock;

    /**
     * 展示图片
     */
    private String pic;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 单品促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    private Integer lockStock;

    /**
     * 商品销售属性，json格式
     */
    private String spData;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取sku编码
     *
     * @return sku_code - sku编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * 设置sku编码
     *
     * @param skuCode sku编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取预警库存
     *
     * @return low_stock - 预警库存
     */
    public Integer getLowStock() {
        return lowStock;
    }

    /**
     * 设置预警库存
     *
     * @param lowStock 预警库存
     */
    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    /**
     * 获取展示图片
     *
     * @return pic - 展示图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置展示图片
     *
     * @param pic 展示图片
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取销量
     *
     * @return sale - 销量
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置销量
     *
     * @param sale 销量
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * 获取单品促销价格
     *
     * @return promotion_price - 单品促销价格
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置单品促销价格
     *
     * @param promotionPrice 单品促销价格
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取锁定库存
     *
     * @return lock_stock - 锁定库存
     */
    public Integer getLockStock() {
        return lockStock;
    }

    /**
     * 设置锁定库存
     *
     * @param lockStock 锁定库存
     */
    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    /**
     * 获取商品销售属性，json格式
     *
     * @return sp_data - 商品销售属性，json格式
     */
    public String getSpData() {
        return spData;
    }

    /**
     * 设置商品销售属性，json格式
     *
     * @param spData 商品销售属性，json格式
     */
    public void setSpData(String spData) {
        this.spData = spData == null ? null : spData.trim();
    }
}

//package cn.gyw.community.product.rpc.controller;
//
//import cn.gyw.community.product.rpc.service.ProductInfoRpcService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//
//import cn.gyw.community.inventory.api.WarehouseProductService;
//import cn.gyw.community.order.api.OrderMasterService;
//import cn.gyw.community.product.model.ProductInfo;
//import cn.gyw.community.product.model.dto.ProductDto;
//import cn.gyw.community.product.model.dto.ProductWithWarehouseDto;
//
//@RestController
//@RequestMapping("/productInfo")
//@Profile(value = "rpc")
//public class ProductRpcController {
//
//	@Autowired
//	private ProductInfoRpcService productInfoService;
//	@Reference
//	private WarehouseProductService warehouseProductService;
//	@Reference
//	private OrderMasterService orderMasterService;
//
//	@PostMapping("/addWithInventory")
//	public boolean addWithInventory(@RequestBody ProductDto productDto) {
//		ProductInfo productInfo = new ProductInfo();
//		BeanUtils.copyProperties(productDto, productInfo);
//		this.productInfoService.addWithInventory(productInfo);
//		return true;
//	}
//
//	@PostMapping("/buy")
//	public boolean buyProduct(@RequestBody ProductDto productDto) {
//		return this.productInfoService.buyProduct(productDto);
//	}
//
//	@GetMapping("/cache/{productCore}")
//	public ProductWithWarehouseDto queryWithCache(@PathVariable String productCore) {
//		return this.productInfoService.queryWithInventory(productCore);
//	}
//
//	@DeleteMapping("/cache/{productCore}")
//	public int deleteProduct(@PathVariable String productCore) {
//		return this.productInfoService.deleteProduct(productCore);
//	}
//
//	/**
//	 * *********** 分布式事务 ****************
//	 */
//
//	@PostMapping("/buy/xa")
//	public boolean buyProductByXA(@RequestBody ProductDto productDto) {
//		return this.productInfoService.buyProductWithXA(productDto);
//	}
//
//	@PostMapping("/buy/tcc")
//	public boolean buyProductByTCC(@RequestBody ProductDto productDto) {
//		this.productInfoService.buyProductWithTCC(productDto);
//		return true;
//	}
//}

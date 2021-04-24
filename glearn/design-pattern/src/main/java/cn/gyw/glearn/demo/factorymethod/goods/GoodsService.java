package cn.gyw.glearn.demo.factorymethod.goods;

/**
 * 模拟实物商品服务
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + req);
        return true;
    }

}

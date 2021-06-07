package cn.gyw.community.search.repository;

import cn.gyw.community.search.domain.EsProduct;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EsProductRepository {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 搜索查询
     * @param name 商品名称
     * @param subTitle 商品标题
     * @param keywords 商品关键字
     * @param page 分页信息
     * @return
     */
    public Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page) {
        // TODO: 查询逻辑
        return null;
    }

    public Iterable<EsProduct> saveAll(List<EsProduct> esProductList) {

        return null;
    }

    public void deleteById(Long id) {
    }

    public EsProduct save(EsProduct esProduct) {
    }

    public void deleteAll(List<EsProduct> esProductList) {
    }
}

package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Map;

/**
 * 零件
 *
 * @date 2023/10/19
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {
    protected Part(Map<String, Object> properties) {
        super(properties);
    }
}

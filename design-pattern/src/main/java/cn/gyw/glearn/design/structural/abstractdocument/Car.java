package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Map;

/**
 * 汽车类
 *
 * @date 2023/10/19
 */
public class Car extends AbstractDocument implements HasPrice, HasModel, HasParts {

    protected Car(Map<String, Object> properties) {
        super(properties);
    }
}

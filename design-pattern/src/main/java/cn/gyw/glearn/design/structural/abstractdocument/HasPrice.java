package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Optional;

/**
 * 价格接口
 *
 * @date 2023/10/19
 */
public interface HasPrice extends Document {

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(Property.PRICE.toString()));
    }
}

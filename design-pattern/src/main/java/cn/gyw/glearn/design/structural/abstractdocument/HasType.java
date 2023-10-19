package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Optional;

/**
 * 类型 接口
 *
 * @date 2023/10/19
 */
public interface HasType extends Document {

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}

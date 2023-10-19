package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Optional;

/**
 * 模型接口
 *
 * @date 2023/10/19
 */
public interface HasModel extends Document {

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}

package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 零件接口
 *
 * @date 2023/10/19
 */
public interface HasParts extends Document {

    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}

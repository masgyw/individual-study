package cn.gyw.glearn.design.structural.abstractdocument;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 抽象文档模式
 * <p>
 * 目的：使对象拥有属性映射和任意数量的子对象
 *
 * @date 2023/10/19
 */
public abstract class AbstractDocument implements Document {

    private final Map<String, Object> properties;

    protected AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "properties is required");
        this.properties = properties;
    }

    @Override
    public Void put(String key, Object value) {
        properties.put(key, value);
        return null;
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        return Stream.of(get(key))
                .filter(Objects::nonNull)
                .map(el -> (List<Map<String, Object>>)el)
                .findAny()
                .orElse(new ArrayList<>())
                .stream()
                .map(constructor);
    }
}

package cn.gyw.platform.codegen.registry;

import cn.gyw.platform.codegen.spi.CodeGenProcessor;
import com.google.common.collect.Maps;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * 通过spi 加载所有的CodeGenProcessor识别要处理的annotation类
 *
 * @date 2022/9/7
 */
public final class ProcessorRegistry {

    private static Map<String, ? extends CodeGenProcessor> PROCESSOR_MAP;

    public static Set<String> supportedAnnotations() {
        return PROCESSOR_MAP.keySet();
    }

    public static CodeGenProcessor get(String annotationClassName) {
        return PROCESSOR_MAP.get(annotationClassName);
    }

    /**
     * spi 加载所有的processor
     */
    public static void initProcessors() {
        final Map<String, CodeGenProcessor> processorMap = Maps.newLinkedHashMap();
        ServiceLoader<CodeGenProcessor> processors =
                ServiceLoader.load(CodeGenProcessor.class, CodeGenProcessor.class.getClassLoader());
        Iterator<CodeGenProcessor> iter = processors.iterator();
        while (iter.hasNext()) {
            CodeGenProcessor next = iter.next();
            Class<? extends Annotation> an = next.getAnnotation();
            processorMap.put(an.getName(), next);
        }
        PROCESSOR_MAP = processorMap;
    }

    private ProcessorRegistry() {
        throw new UnsupportedOperationException();
    }
}

package cn.gyw.platform.codegen.spi;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;

/**
 * 代码生成 Processor
 * @date 2022/9/7
 */
public interface CodeGenProcessor {

    /**
     * 获取类上的注解
     * @return 注解类
     */
    Class<? extends Annotation> getAnnotation();

    /**
     * 获取生成的包路径
     * @param typeElement 类型元素
     * @return 包路径
     */
    String generatePackage(TypeElement typeElement);

    /**
     * 代码生成逻辑
     * @param typeElement 类型元素
     * @param roundEnvironment 环境
     * @throws Exception 异常
     */
    void generate(TypeElement typeElement, RoundEnvironment roundEnvironment) throws Exception;
}

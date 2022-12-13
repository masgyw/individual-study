package cn.gyw.platform.codegen.processor.mapper;

/**
 * Mapper类
 *
 * @date 2022/9/7
 */
public @interface CgMapper {

    /**
     * 包名
     *
     * @return 包名
     */
    String pkgName();

    /**
     * 源码路径
     *
     * @return 路径
     */
    String srcPath() default "src/main/java";

    /**
     * 是否覆盖原文件
     *
     * @return true/false
     */
    boolean overrideSrc() default false;
}

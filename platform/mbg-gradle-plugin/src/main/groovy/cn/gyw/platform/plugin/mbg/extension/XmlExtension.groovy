package cn.gyw.platform.plugin.mbg.extension

import org.mybatis.generator.api.PluginAdapter

/**
 * XML 配置扩展
 */
class XmlExtension {

    /**
     * 生成java文件所在的目录<br>
     * 默认为 src/main/java
     */
    String javaProject = "src/main/java"

    /**
     * 生成xml配置文件mapper所在的目录<br>
     * 默认为 src/main/resources
     */
    String resourcesProject = "src/main/resources"

    /**
     * 基础应用包名
     * 默认值为null，必传
     */
    String basePackage = null

    /**
     * mapper配置,生成的Mapper(dao)所在的包所在的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String mapperPackage = "dao"

    /**
     * model配置,生成的实体类所在的包所在的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String modelPackage = "entity"

    /**
     * mapper的xml配置,生成的mapper的xml所在的包的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String xmlPackage = "mapper"


    /**
     * 插件信息,xml中插件的类名,继承自<code>org.mybatis.generator.api.PluginAdapter</code><br/>
     * 默认值为tk.mybatis.mapper.generator.MapperPlugin.class
     */
    Class<? extends PluginAdapter> mapperPlugin = tk.mybatis.mapper.generator.MapperPlugin.class

    /**
     * mapper配置,生成的Mapper类的父类<br/>
     * 默认值为tk.mybatis.mapper.common.Mapper
     */
    String mapperMapper = "tk.mybatis.mapper.common.Mapper"
    /**
     * tableName需要生成的表名<br/>
     * 默认值为空,必须设置
     */
    String tableName = null
    /**
     * objectName需要生成的实体类名<br/>
     * 默认通过tableName转换而来，指定使用指定的值
     */
    String objectName = null
    /**
     * mapper配置,生成的Mapper类的后缀<br/>
     * 默认值为Mapper
     */
    String mapperSuffix = "Mapper"
}

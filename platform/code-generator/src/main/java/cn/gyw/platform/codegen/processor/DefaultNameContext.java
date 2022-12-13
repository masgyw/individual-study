package cn.gyw.platform.codegen.processor;

import lombok.Data;

/**
 * 默认名称上下文
 *
 * @date 2022/9/9
 */
@Data
public class DefaultNameContext {

    private String voPkgName;

    private String voClzName;

    private String mapperPkgName;

    private String mapperClzName;

    private String servicePkgName;

    private String serviceClzName;

    private String implPkgName;

    private String implClzName;

    private String controllerPkgName;

    private String controllerClzName;

    private String queryRequestPkgName;

    private String queryRequestClzName;

    private String responsePkgName;

    private String responseClzName;
}

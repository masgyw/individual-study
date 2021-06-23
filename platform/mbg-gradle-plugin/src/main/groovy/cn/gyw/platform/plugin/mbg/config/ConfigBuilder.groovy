package cn.gyw.platform.plugin.mbg.config

class ConfigBuilder {

    boolean restControllerStyle = false

    File javaProjectFile

    String entityPackage

    String entityDtoPackage

    String controllerPackage

    String servicePackage

    String superControllerClass = null

    String superServiceClass

    Collection<String> moduleList = []

    /**
     * 路径配置信息
     */
    Map<OutputFile, String> pathInfo = new HashMap<>();

    @Override
    public String toString() {
        return "ConfigBuilder{" +
                "restControllerStyle=" + restControllerStyle +
                ", controllerPackage='" + controllerPackage + '\'' +
                ", servicePackage='" + servicePackage + '\'' +
                ", superControllerClass='" + superControllerClass + '\'' +
                ", superServiceClass='" + superServiceClass + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }
}

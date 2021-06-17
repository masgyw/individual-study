# 手写Gradle 插件

## Mybatis-generator 插件

1. 实现Plugin 接口
2. resources/META-INF/gradle-plugins/{pluginName}.properties  
ps: 插件名是properties文件的文件名

## 插件的扩展Extension 用来把需要的参数传回插件
使用方式：  
project.extensions.add('myextension',MyExtension)
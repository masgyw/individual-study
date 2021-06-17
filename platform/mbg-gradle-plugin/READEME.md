# Mybatis-generator gradle 插件

## 一、依赖
1. TkMybatis
2. Mybatis generator

## 二、mybatis-generator 插件
1. 实现Plugin 接口
2. 插件定义  
resources/META-INF/gradle-plugins/{pluginName}.properties  
ps: 插件名是properties文件的文件名
3. 插件扩展Extension  
目的：用来把需要的参数传回插件  
使用方法：project.extensions.add('myextension',MyExtension)

## 三、使用方式
- 加入环境
```groovy
buildscript {
  repositories {
    mavenLocal()
  }
  dependencies {
    classpath "cn.gyw.platform:mbg-gradle-plugin:1.0.0"
  }
}

apply plugin: 'cn.gyw.platform.plugin.mbg'
```
- 参数配置

|参数|类型|说明|默认值|
|---|---|---|---|
|overwrite|boolean|是否覆盖同名文件|true|
|generatorFile|string|mbg配置文件位置|gene|
|sqlScript|||

## 参考
1. [mybatis_generator_gradle_plugin](https://github.com/cuisongliu/mybatis_generator_gradle_plugin)
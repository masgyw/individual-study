# code-generator

## 说明
代码生成器

## 实现原理
1. 基于spi+Processor

## Processor技术
1. 什么是Processor
   1. Processor会在编译阶段初始化，然后对当前模块内的代码进行一次扫描，然后获取到对应的注解，之后调用process方法，然后根据这些注解类来做一些后续操作
2. ProcessingEnvironment
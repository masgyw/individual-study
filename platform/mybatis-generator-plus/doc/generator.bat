@echo off
:: -overwrite 覆盖同名文件
set EXTLIBS=%~dp0mybatis-generator-core-1.4.0\lib\
set MGB_LIBS=%EXTLIBS%mybatis-generator-plus-1.0.0.jar
SET MGB_LIBS=%MGB_LIBS%;%EXTLIBS%mybatis-generator-core-1.4.0.jar

SET CLASSPATH=./;%MGB_LIBS%

java %OPTIONS% -Dfile.encoding=UTF-8 org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
pause
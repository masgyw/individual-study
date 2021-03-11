#! /bin/bash
RUN_PATH=`pwd`
EXT_LIBS=.:$RUN_PATH/mybatis-generator-core-1.4.0/lib/mybatis-generator-core-1.4.0.jar
EXT_LIBS=$EXT_LIBS:$RUN_PATH/mybatis-generator-core-1.4.0/lib/mybatis-generator-plus-1.0.0.jar
echo $EXT_LIBS
java -cp $EXT_LIBS org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite

# method2
EXT_LIBS_DIR=$RUN_PATH/mybatis-generator-core-1.4.0/lib/
#java -Djava.ext.dirs=$EXT_LIBS_DIR org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite

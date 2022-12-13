package cn.gyw.platform.codegen.processor;

import cn.gyw.platform.codegen.processor.mapper.CgMapper;
import cn.gyw.platform.codegen.processor.mapper.CgMapperProcessor;
import cn.gyw.platform.codegen.spi.CodeGenProcessor;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @date 2022/9/7
 */
public abstract class BaseCodeGenProcessor implements CodeGenProcessor {

    private static final String PREFIX = "Base";
    private static final String JAVA_FILE_SUFFIX = ".java";

    @Override
    public void generate(TypeElement typeElement, RoundEnvironment roundEnvironment) throws Exception {

        // 生成Java文件
        generateJava(typeElement, roundEnvironment);
    }

    /**
     * 生成java文件
     *
     * @param typeElement      类型元素
     * @param roundEnvironment
     */
    protected abstract void generateJava(TypeElement typeElement, RoundEnvironment roundEnvironment);

    /**
     * 获取默认命名上下文
     *
     * @param typeElement 类型元素
     * @return 上下文
     */
    protected DefaultNameContext getNameContext(TypeElement typeElement) {
        DefaultNameContext context = new DefaultNameContext();
        String mapperName = typeElement.getSimpleName() + CgMapperProcessor.SUFFIX;
        context.setMapperClzName(mapperName);
        Optional.ofNullable(typeElement.getAnnotation(CgMapper.class)).ifPresent(an -> context.setMapperPkgName(an.pkgName()));

        return context;
    }

    /**
     * 生成 java 源文件
     *
     * @param pkgName         包名
     * @param srcPath         原文件目录
     * @param typeSpecBuilder 类构造器
     */
    protected void genJavaSrcFile(String pkgName, String srcPath, TypeSpec.Builder typeSpecBuilder) {
        TypeSpec typeSpec = typeSpecBuilder.build();
        JavaFile javaFile = JavaFile.builder(pkgName, typeSpec)
                .addFileComment("Auto create by code-generator")
                .build();
        String packagePath = pkgName.replace(".", File.separator)
                + File.separator + typeSpec.name + JAVA_FILE_SUFFIX;
        Path path = Paths.get(srcPath);
        File sourceDir = new File(path.toFile().getAbsolutePath());
        if (!sourceDir.exists()) {
            System.err.println("文件不存在：" + sourceDir);
            return;
        }
        String srcFileName = sourceDir.getAbsolutePath() + File.separator + packagePath;
        File srcFile = new File(srcFileName);
        if (srcFile.exists()) {
            return;
        }
        // TODO: 若覆盖
        try {
            javaFile.writeTo(sourceDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

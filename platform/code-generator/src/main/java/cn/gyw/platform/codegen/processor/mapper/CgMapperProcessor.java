package cn.gyw.platform.codegen.processor.mapper;

import cn.gyw.platform.codegen.processor.BaseCodeGenProcessor;
import cn.gyw.platform.codegen.processor.DefaultNameContext;
import cn.gyw.platform.codegen.spi.CodeGenProcessor;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.util.Optional;

/**
 * Mapper 文件生成器
 *
 * @date 2022/9/7
 */
@AutoService({CodeGenProcessor.class})
public class CgMapperProcessor extends BaseCodeGenProcessor {

    public static final String SUFFIX = "Mapper";

    @Override
    protected void generateJava(TypeElement typeElement, RoundEnvironment roundEnvironment) {
        CgMapper cgMapper = typeElement.getAnnotation(CgMapper.class);
        String className = typeElement.getSimpleName() + SUFFIX;
        String packageName = cgMapper.pkgName();
        AnnotationSpec mapperAnnotation = AnnotationSpec.builder(Mapper.class)
                .build();
        TypeSpec.Builder typeSpecBuilder = TypeSpec.interfaceBuilder(className)
                .addAnnotation(mapperAnnotation)
                .addModifiers(Modifier.PUBLIC);
        // instance 字段
        FieldSpec instance = FieldSpec.builder(ClassName.get(packageName, className), "INSTANCE")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.getMapper($T.class)", Mappers.class, ClassName.get(packageName, className))
                .build();
        typeSpecBuilder.addField(instance);

        DefaultNameContext nameContext = getNameContext(typeElement);

        genJavaSrcFile(cgMapper.pkgName(), cgMapper.srcPath(), typeSpecBuilder);
    }

    @Override
    public Class<? extends Annotation> getAnnotation() {
        return CgMapper.class;
    }

    @Override
    public String generatePackage(TypeElement typeElement) {
        return typeElement.getAnnotation(CgMapper.class).pkgName();
    }
}

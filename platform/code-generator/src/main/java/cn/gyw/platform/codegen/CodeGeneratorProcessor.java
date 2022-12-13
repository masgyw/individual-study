package cn.gyw.platform.codegen;

import cn.gyw.platform.codegen.context.ProcessingEnvironmentHolder;
import cn.gyw.platform.codegen.registry.ProcessorRegistry;
import cn.gyw.platform.codegen.spi.CodeGenProcessor;
import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * 编译器注解处理器
 *
 * @date 2022/9/7
 */
@AutoService(Processor.class)
public class CodeGeneratorProcessor extends AbstractProcessor {

    /**
     * 扫描代码的时候会把当前获取到的annotations传入当前方法，一个模块的processor 可能会有多个
     *
     * @param annotations 注解列表
     * @param roundEnv    环境
     * @return true: 声明注释类型，并且不会要求后续处理器处理它们;false: 注释类型无人认领，可能会要求后续处理器处理它们
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(an -> {
            Set<? extends Element> typeElements = roundEnv.getElementsAnnotatedWith(an);
            Set<TypeElement> types = ElementFilter.typesIn(typeElements);
            for (TypeElement typeElement : types) {
                CodeGenProcessor codeGenProcessor = ProcessorRegistry.get(an.getQualifiedName().toString());
                try {
                    codeGenProcessor.generate(typeElement, roundEnv);
                } catch (Exception e) {
                    ProcessingEnvironmentHolder.getEnvironment().getMessager()
                            .printMessage(Diagnostic.Kind.ERROR, "代码生成异常:" + e.getMessage());
                }
            }
        });
        return false;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        // 设置环境变量
        ProcessingEnvironmentHolder.setEnvironment(processingEnv);
        // 初始化
        ProcessorRegistry.initProcessors();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return ProcessorRegistry.supportedAnnotations();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}

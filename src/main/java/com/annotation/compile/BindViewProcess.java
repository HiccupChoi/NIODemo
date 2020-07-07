package com.annotation.compile;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @Author: Hiccup
 * @Date: 2020/6/12 11:08
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.annotation.compile.BindView")
public class BindViewProcess extends AbstractProcessor {

    /**
     * process 注解处理的主函数，这里处理扫描、评估和处理注解的代码，以及生产 Java 文件。
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (Element ele : roundEnv.getElementsAnnotatedWith(BindView.class)) {
            if (ele.getKind() == ElementKind.FIELD) {
                messager.printMessage(Diagnostic.Kind.NOTE, "printMessage:" + ele.toString());
            }
        }
        return true;
    }

    /**
     * init 被注解处理工具调用，并输入 processingEnvironment 参数。processingEnvironment 提供了很多工具类，如 Elements、Types、Filer 和 Messenger 等。
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

}

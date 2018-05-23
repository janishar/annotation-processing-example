package com.mindorks.compiler.lib;

import com.mindorks.lib.annotations.BindView;
import com.mindorks.lib.annotations.Keep;
import com.mindorks.lib.annotations.OnClick;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

public class Processor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        Set<? extends Element> elements = roundEnv
//                .getElementsAnnotatedWith(annotations.iterator().next());

        for (Element element : annotations) {

            if(element.toString().equals(BindView.class.getCanonicalName())){
                messager.printMessage(Diagnostic.Kind.WARNING, "DEBUG BindView: " + element.getEnclosingElement());
            }

            if(element.toString().equals(OnClick.class.getCanonicalName())){
                messager.printMessage(Diagnostic.Kind.WARNING, "DEBUG OnClick: " + element);
            }
        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new TreeSet<>(Arrays.asList(
                BindView.class.getCanonicalName(),
                OnClick.class.getCanonicalName(),
                Keep.class.getCanonicalName()));
    }
}

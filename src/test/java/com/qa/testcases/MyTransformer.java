package com.qa.testcases;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
 
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
/**
 * Created by ONUR on 17.12.2016. 
 */
public class MyTransformer implements IAnnotationTransformer {
 
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
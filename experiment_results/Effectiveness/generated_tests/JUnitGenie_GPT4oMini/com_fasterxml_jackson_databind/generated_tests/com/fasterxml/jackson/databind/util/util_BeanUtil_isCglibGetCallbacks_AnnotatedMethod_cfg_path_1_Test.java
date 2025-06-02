package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class util_BeanUtil_isCglibGetCallbacks_AnnotatedMethod_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withCglibArrayType() {
        try {
            // Create a mock method that returns an array type
            Method method = MockClass.class.getMethod("getCallbacks");
            TypeResolutionContext typeResolutionContext = new TypeResolutionContext() {
                @Override
                public com.fasterxml.jackson.databind.JavaType resolveType(Type type) {
                    return null; // Provide a simple implementation that returns null
                }
            };
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(typeResolutionContext, method, new AnnotationMap(), new AnnotationMap[0]);

            // Invoke the protected static method using reflection
            boolean result = (boolean) BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class)
                    .invoke(null, annotatedMethod);

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withNonCglibArrayType() {
        try {
            // Create a mock method that returns a non-CGLIB array type
            Method method = MockClass.class.getMethod("getNonCglibCallbacks");
            TypeResolutionContext typeResolutionContext = new TypeResolutionContext() {
                @Override
                public com.fasterxml.jackson.databind.JavaType resolveType(Type type) {
                    return null; // Provide a simple implementation that returns null
                }
            };
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(typeResolutionContext, method, new AnnotationMap(), new AnnotationMap[0]);

            // Invoke the protected static method using reflection
            boolean result = (boolean) BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class)
                    .invoke(null, annotatedMethod);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mock class to simulate methods returning array types
    public static class MockClass {
        public net.sf.cglib.proxy.Callback[] getCallbacks() {
            return new net.sf.cglib.proxy.Callback[0];
        }

        public String[] getNonCglibCallbacks() {
            return new String[0];
        }
    }

}
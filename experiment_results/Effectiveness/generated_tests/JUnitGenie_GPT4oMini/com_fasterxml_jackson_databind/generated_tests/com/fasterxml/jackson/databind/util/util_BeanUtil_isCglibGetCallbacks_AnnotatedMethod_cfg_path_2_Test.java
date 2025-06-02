package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_BeanUtil_isCglibGetCallbacks_AnnotatedMethod_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withCglibArrayType() {
        try {
            // Create a Method object with a non-array return type
            Method method = SampleClass.class.getMethod("getCallbacks");
            // Create an instance of AnnotatedMethod
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(new TypeResolutionContext.Basic(TypeFactory.defaultInstance(), TypeBindings.emptyBindings()), method, new AnnotationMap(), new AnnotationMap[0]);
            
            // Access the protected static method using reflection
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
            // Create a Method object with a non-array return type
            Method method = SampleClass.class.getMethod("getNonCglibCallbacks");
            // Create an instance of AnnotatedMethod
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(new TypeResolutionContext.Basic(TypeFactory.defaultInstance(), TypeBindings.emptyBindings()), method, new AnnotationMap(), new AnnotationMap[0]);
            
            // Access the protected static method using reflection
            boolean result = (boolean) BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class)
                    .invoke(null, annotatedMethod);
            
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sample class to simulate methods for testing
    public static class SampleClass {
        public net.sf.cglib.proxy.Callback[] getCallbacks() {
            return new net.sf.cglib.proxy.Callback[0];
        }

        public String getNonCglibCallbacks() {
            return "Not a CGLIB callback";
        }
    }


}
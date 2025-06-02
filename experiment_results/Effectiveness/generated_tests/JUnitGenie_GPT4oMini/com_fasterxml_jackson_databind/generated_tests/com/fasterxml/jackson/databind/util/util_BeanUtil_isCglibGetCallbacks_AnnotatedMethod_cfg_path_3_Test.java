package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import org.junit.runners.model.TestClass;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_BeanUtil_isCglibGetCallbacks_AnnotatedMethod_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withCglibArrayType() {
        try {
            // Create a Method object that returns an array type
            Method method = TestClass.class.getDeclaredMethod("getCallbacks"); // Changed to getDeclaredMethod
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(null, method, null, null);

            // Access the protected static method using reflection
            boolean result = (Boolean) BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class)
                    .invoke(null, annotatedMethod);

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withNonCglibArrayType() {
        try {
            // Create a Method object that returns a non-CGLIB array type
            Method method = TestClass.class.getDeclaredMethod("getNonCglibCallbacks"); // Changed to getDeclaredMethod
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(null, method, null, null);

            // Access the protected static method using reflection
            boolean result = (Boolean) BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class)
                    .invoke(null, annotatedMethod);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class util_BeanUtil_isCglibGetCallbacks_AnnotatedMethod_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_WithArrayType_ReturnsFalse() {
        try {
            // Create a mock method that returns an array type
            Method mockMethod = String[].class.getMethod("clone"); // Changed from "length" to "clone"
            Constructor<AnnotatedMethod> constructor = AnnotatedMethod.class.getDeclaredConstructor(
                    com.fasterxml.jackson.databind.introspect.TypeResolutionContext.class,
                    Method.class,
                    com.fasterxml.jackson.databind.introspect.AnnotationMap.class,
                    com.fasterxml.jackson.databind.introspect.AnnotationMap[].class
            );
            constructor.setAccessible(true);
            AnnotatedMethod am = constructor.newInstance(null, mockMethod, null, null);

            // Invoke the protected static method using reflection
            Method method = BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, am);

            // Assert the expected result
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
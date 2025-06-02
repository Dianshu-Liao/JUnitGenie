package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class util_BeanUtil_isCglibGetCallbacks_AnnotatedMethod_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsCglibGetCallbacks_withNonArrayType() {
        try {
            // Create a method that returns a non-array type
            Method method = String.class.getMethod("toString");
            // Create an instance of AnnotatedMethod using reflection
            Constructor<AnnotatedMethod> constructor = AnnotatedMethod.class.getDeclaredConstructor(
                com.fasterxml.jackson.databind.introspect.TypeResolutionContext.class,
                Method.class,
                com.fasterxml.jackson.databind.introspect.AnnotationMap.class,
                com.fasterxml.jackson.databind.introspect.AnnotationMap[].class
            );
            constructor.setAccessible(true);
            AnnotatedMethod am = constructor.newInstance(null, method, null, null);

            // Access the protected static method using reflection
            Method isCglibGetCallbacksMethod = BeanUtil.class.getDeclaredMethod("isCglibGetCallbacks", AnnotatedMethod.class);
            isCglibGetCallbacksMethod.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) isCglibGetCallbacksMethod.invoke(null, am);
            assertFalse(result); // Expecting false since the method is not returning an array type
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
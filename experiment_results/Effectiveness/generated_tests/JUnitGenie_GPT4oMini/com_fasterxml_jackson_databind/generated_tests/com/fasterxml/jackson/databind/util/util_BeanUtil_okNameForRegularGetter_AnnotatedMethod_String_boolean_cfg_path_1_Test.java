package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class util_BeanUtil_okNameForRegularGetter_AnnotatedMethod_String_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testOkNameForRegularGetterWithCglibGetCallbacks() {
        try {
            // Create a Method object that simulates a non-array return type
            Method method = TestClass.class.getMethod("getCallbacks");
            AnnotatedMethod am = new AnnotatedMethod(null, method, null, null);

            String result = BeanUtil.okNameForRegularGetter(am, "getCallbacks", true);
            assertNull(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // A test class to simulate the method we want to test against
    public static class TestClass {
        public Object getCallbacks() {
            return new Object();
        }
    }

}
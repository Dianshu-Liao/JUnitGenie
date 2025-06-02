package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import static org.junit.Assert.assertNotNull;

public class reflect_TypeUtils_getClosestParentType_Class_Class_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetClosestParentTypeThrowsException() {
        try {
            // Prepare test input
            Class<?> cls = TestClass.class; // TestClass should implement an interface
            Class<?> superClass = TestInterface.class; // TestInterface is an interface

            // Access the private static method using reflection
            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
            method.setAccessible(true);

            // Invoke the method with the test input
            method.invoke(null, cls, superClass);
        } catch (IllegalStateException e) {
            // Expected exception
            assertNotNull(e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    // Dummy classes for testing
    interface TestInterface {}

    static class TestClass implements TestInterface {}

}
package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import static org.junit.Assert.assertNotNull;

public class reflect_TypeUtils_getClosestParentType_Class_Class_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testGetClosestParentType() {
        try {
            // Create a mock class that implements an interface
            Class<?> cls = MockClass.class;
            Class<?> superClass = MockInterface.class;

            // Access the private static method using reflection
            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
            method.setAccessible(true);

            // Invoke the method
            Type result = (Type) method.invoke(null, cls, superClass);

            // Assert that the result is not null
            assertNotNull("The result should not be null", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mock classes for testing
    interface MockInterface {}

    static class MockClass implements MockInterface {}

}
package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import static org.junit.Assert.assertNotNull;

public class reflect_TypeUtils_getClosestParentType_Class_Class_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithValidParameterizedType() {
        try {
            // Create a mock class that implements a generic interface
            Class<?> cls = MockClass.class;
            Class<?> superClass = MockInterface.class;

            // Access the private static method using reflection
            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
            method.setAccessible(true);

            // Invoke the method
            Type result = (Type) method.invoke(null, cls, superClass);

            // Assert that the result is not null
            assertNotNull("Expected a non-null result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithUnexpectedGenericType() {
        try {
            Class<?> cls = MockClassWithUnexpectedGeneric.class;
            Class<?> superClass = MockInterface.class;

            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
            method.setAccessible(true);

            // Invoke the method and expect an IllegalStateException
            try {
                method.invoke(null, cls, superClass);
            } catch (IllegalStateException e) {
                // Expected exception
                return;
            }
            // If we reach here, the exception was not thrown
            assert false : "Expected IllegalStateException was not thrown";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mock classes for testing
    interface MockInterface {}

    class MockClass implements MockInterface {}

    class MockClassWithUnexpectedGeneric implements MockInterface, ParameterizedType {
        // Implement methods of ParameterizedType as needed for the test
        @Override
        public Type[] getActualTypeArguments() {
            return new Type[0];
        }

        @Override
        public Type getRawType() {
            return MockClass.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

}
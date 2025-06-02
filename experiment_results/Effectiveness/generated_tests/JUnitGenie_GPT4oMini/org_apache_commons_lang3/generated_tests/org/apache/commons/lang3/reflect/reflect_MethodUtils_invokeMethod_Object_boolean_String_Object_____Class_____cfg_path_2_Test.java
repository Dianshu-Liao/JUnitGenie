package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInvokeMethodWithValidParameters() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "sayHello";
            boolean forceAccess = false;
            Object[] args = null; // This will be converted to an empty array
            Class<?>[] parameterTypes = null; // This will also be converted to an empty array

            // Act
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);

            // Assert
            assertEquals("Hello, World!", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithForceAccess() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "privateMethod";
            boolean forceAccess = true;
            Object[] args = null; // This will be converted to an empty array
            Class<?>[] parameterTypes = null; // This will also be converted to an empty array

            // Act
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);

            // Assert
            assertEquals("Private Method Invoked", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodThrowsNoSuchMethodException() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "nonExistentMethod";
            boolean forceAccess = false;
            Object[] args = null; // This will be converted to an empty array
            Class<?>[] parameterTypes = null; // This will also be converted to an empty array

            // Act
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Assert
            assertTrue(e.getMessage().contains("No such accessible method: nonExistentMethod() on object: " + TestClass.class.getName()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    // Test class with methods to invoke
    public static class TestClass {
        public String sayHello() {
            return "Hello, World!";
        }

        private String privateMethod() {
            return "Private Method Invoked";
        }
    }

}
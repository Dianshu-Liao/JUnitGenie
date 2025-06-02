package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInvokeMethodWithValidParameters() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "sayHello";
        Object[] args = new Object[] {"World"};
        Class<?>[] parameterTypes = new Class<?>[] {String.class};
        boolean forceAccess = false;

        // Act
        try {
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            // Assert
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithNoSuchMethodException() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "nonExistentMethod";
        Object[] args = new Object[] {};
        Class<?>[] parameterTypes = new Class<?>[] {};
        boolean forceAccess = false;

        // Act
        try {
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Assert
            assertTrue(e.getMessage().contains("No such accessible method: nonExistentMethod() on object: " + testObject.getClass().getName()));
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithForceAccess() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "privateMethod";
        Object[] args = new Object[] {};
        Class<?>[] parameterTypes = new Class<?>[] {};
        boolean forceAccess = true;

        // Act
        try {
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            // Assert
            assertEquals("This is a private method", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    // Test class with methods to invoke
    public static class TestClass {
        public String sayHello(String name) {
            return "Hello, " + name + "!";
        }

        private String privateMethod() {
            return "This is a private method";
        }
    }

}
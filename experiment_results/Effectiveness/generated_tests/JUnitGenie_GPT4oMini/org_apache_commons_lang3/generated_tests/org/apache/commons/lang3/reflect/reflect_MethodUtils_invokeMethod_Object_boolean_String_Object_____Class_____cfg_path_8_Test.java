package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testInvokeMethod_WithValidMethod() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "testMethod";
            Object[] args = new Object[] { "Hello" };
            Class<?>[] parameterTypes = new Class<?>[] { String.class };
            boolean forceAccess = false;

            // Act
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);

            // Assert
            assertEquals("Expected return value", "Hello", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("The method invocation threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethod_ThrowsNoSuchMethodException() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "nonExistentMethod";
            Object[] args = null; // This should be converted to an empty array by nullToEmpty.
            Class<?>[] parameterTypes = null; // This should be converted to an empty array by nullToEmpty.
            boolean forceAccess = true;

            // Act
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException was not thrown.");
        } catch (NoSuchMethodException e) {
            assertTrue(e.getMessage().contains("No such method:"));
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("The method invocation threw an unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethod_MethodNotAccessible() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "privateTestMethod"; // Assume this method exists but is private
            Object[] args = new Object[] { "Access" };
            Class<?>[] parameterTypes = new Class<?>[] { String.class };
            boolean forceAccess = false;

            // Act
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected IllegalAccessException was not thrown.");
        } catch (IllegalAccessException e) {
            assertTrue(e.getMessage().contains("not accessible"));
        } catch (NoSuchMethodException | InvocationTargetException e) {
            fail("The method invocation threw an unexpected exception: " + e.getMessage());
        }
    }

    private static class TestClass {
        public String testMethod(String input) {
            return input;
        }

        private String privateTestMethod(String input) {
            return input;
        }
    }

}
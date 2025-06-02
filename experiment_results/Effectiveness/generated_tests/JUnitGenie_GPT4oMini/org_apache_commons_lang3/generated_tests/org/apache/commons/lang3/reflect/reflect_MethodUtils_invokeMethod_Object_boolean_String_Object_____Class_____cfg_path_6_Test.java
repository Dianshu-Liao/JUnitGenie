package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInvokeMethodWithValidParameters() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "sayHello";
        Object[] args = null; // This will be handled by ArrayUtils.nullToEmpty
        Class<?>[] parameterTypes = null; // This will also be handled by ArrayUtils.nullToEmpty

        // Act
        try {
            Object result = MethodUtils.invokeMethod(testObject, true, methodName, args, parameterTypes);
            // Assert
            assertEquals("Hello, World!", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithNoSuchMethod() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "nonExistentMethod";
        Object[] args = null;
        Class<?>[] parameterTypes = null;

        // Act
        try {
            MethodUtils.invokeMethod(testObject, true, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Assert
            assertTrue(e.getMessage().contains("No such method: nonExistentMethod() on object: " + TestClass.class.getName()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithIllegalAccess() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "privateMethod";
        Object[] args = null;
        Class<?>[] parameterTypes = null;

        // Act
        try {
            MethodUtils.invokeMethod(testObject, false, methodName, args, parameterTypes);
            fail("Expected IllegalAccessException to be thrown");
        } catch (IllegalAccessException e) {
            // Assert
            assertTrue(e.getMessage().contains("No such accessible method: privateMethod() on object: " + TestClass.class.getName()));
        } catch (NoSuchMethodException | InvocationTargetException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    // Test class with methods to invoke
    public static class TestClass {
        public String sayHello() {
            return "Hello, World!";
        }

        private void privateMethod() {
            // This method is private and should not be accessible
        }
    }


}
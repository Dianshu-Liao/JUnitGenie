package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testInvokeMethod_NoSuchMethodException() {
        // Arrange
        Object object = new Object(); // Using a generic Object as the target
        boolean forceAccess = false;
        String methodName = "nonExistentMethod"; // Method that does not exist
        Object[] args = null; // No arguments
        Class<?>[] parameterTypes = null; // No parameter types

        // Act
        try {
            MethodUtils.invokeMethod(object, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Assert
            assertTrue(e.getMessage().contains("No such accessible method: nonExistentMethod() on object: java.lang.Object"));
        } catch (IllegalAccessException | InvocationTargetException e) { // Corrected the catch block
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethod_ValidMethod() throws Exception {
        // Arrange
        TestClass testObject = new TestClass();
        boolean forceAccess = true;
        String methodName = "testMethod"; // A valid method in TestClass
        Object[] args = new Object[] { "Hello" }; // Arguments for the method
        Class<?>[] parameterTypes = new Class<?>[] { String.class }; // Parameter types

        // Act
        Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);

        // Assert
        assertEquals("Hello", result);
    }

    // A test class with a method to invoke
    public static class TestClass {
        public String testMethod(String input) {
            return input;
        }
    }


}
package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInvokeMethod_NoSuchMethodException() {
        Object testObject = new Object();
        boolean forceAccess = true;
        String methodName = "nonExistentMethod"; // This method does not exist
        Object[] args = new Object[] { };
        Class<?>[] parameterTypes = ArrayUtils.nullToEmpty(new Class<?>[0]); // Correctly initializing an empty array

        try {
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            assertTrue(e.getMessage().contains("No such method: nonExistentMethod() on object: java.lang.Object"));
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethod_WithValidMethod() {
        TestClass testObject = new TestClass();
        boolean forceAccess = false; // Accessing a public method
        String methodName = "publicMethod"; // This method does exist
        Object[] args = new Object[] { "Hello" };
        Class<?>[] parameterTypes = new Class<?>[] { String.class };

        try {
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            assertEquals("Hello", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("No exception should be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethod_WithPrivateMethod_ForceAccess() {
        TestClass testObject = new TestClass();
        boolean forceAccess = true; // Forcing access to a private method
        String methodName = "privateMethod"; // This method does exist
        Object[] args = new Object[] { "World" };
        Class<?>[] parameterTypes = new Class<?>[] { String.class };

        try {
            Object result = MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            assertEquals("Private method called with input: World", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("No exception should be thrown: " + e.getMessage());
        }
    }

    private static class TestClass {
        public String publicMethod(String input) {
            return input;
        }

        private String privateMethod(String input) {
            return "Private method called with input: " + input;
        }
    }


}
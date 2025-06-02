package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInvokeMethodWithValidParameters() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "sayHello";
            Object[] args = null; // This will be handled by ArrayUtils.nullToEmpty
            Class<?>[] parameterTypes = null; // This will also be handled by ArrayUtils.nullToEmpty

            // Act
            Object result = MethodUtils.invokeMethod(testObject, true, methodName, args, parameterTypes);

            // Assert
            assertEquals("Hello, World!", result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokeMethodWithNoSuchMethod() {
        try {
            // Arrange
            TestClass testObject = new TestClass();
            String methodName = "nonExistentMethod";
            Object[] args = null;
            Class<?>[] parameterTypes = null;

            // Act
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
    public void testInvokeMethodWithNullObject() {
        try {
            // Act
            MethodUtils.invokeMethod(null, true, "methodName", null, null);
            fail("Expected NullPointerException to be thrown");
        } catch (NoSuchMethodException e) {
            fail("Unexpected NoSuchMethodException thrown: " + e.getMessage());
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        } catch (NullPointerException e) {
            // Assert
            assertEquals("object", e.getMessage());
        }
    }

    private static class TestClass {
        public String sayHello() {
            return "Hello, World!";
        }
    }

}
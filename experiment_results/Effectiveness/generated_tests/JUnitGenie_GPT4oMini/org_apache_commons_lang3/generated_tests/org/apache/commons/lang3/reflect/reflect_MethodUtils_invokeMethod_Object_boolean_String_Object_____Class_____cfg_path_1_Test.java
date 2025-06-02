package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class reflect_MethodUtils_invokeMethod_Object_boolean_String_Object_____Class_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInvokeMethod_NoSuchMethodException() {
        // Arrange
        Object testObject = new TestClass();
        boolean forceAccess = false;
        String methodName = "nonExistentMethod"; // Method that does not exist
        Object[] args = null; // Can be null
        Class<?>[] parameterTypes = null; // Can be null

        // Act
        try {
            MethodUtils.invokeMethod(testObject, forceAccess, methodName, args, parameterTypes);
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Assert
            assertEquals("No such accessible method: nonExistentMethod() on object: " + testObject.getClass().getName(), e.getMessage());
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    private static class TestClass {
        // This class intentionally left blank for testing purposes
    }

}
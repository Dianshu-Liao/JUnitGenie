package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName_EmptyString() {
        // Arrange
        String input = ""; // input meets the constraints
        String expectedResult = "";

        try {
            // Act
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);
            String result = (String) method.invoke(null, input); // invoke in static context

            // Assert
            assertEquals(expectedResult, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception in a way that fits your testing strategy
        }
    }

    @Test(timeout = 4000)
    public void testGetCanonicalName_ArrayType() {
        // Arrange
        String input = "[Ljava/lang/String;"; // input for array type
        String expectedResult = "java.lang.String[]";

        try {
            // Act
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);
            String result = (String) method.invoke(null, input); // invoke in static context

            // Assert
            assertEquals(expectedResult, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception in a way that fits your testing strategy
        }
    }

    @Test(timeout = 4000)
    public void testGetCanonicalName_SimpleClass() {
        // Arrange
        String input = "String"; // input for a simple class
        String expectedResult = "java.lang.String";

        try {
            // Act
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);
            String result = (String) method.invoke(null, input); // invoke in static context

            // Assert
            assertEquals(expectedResult, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception in a way that fits your testing strategy
        }
    }

}
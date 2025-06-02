package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class Validate_getMessage_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithEmptyValues() {
        try {
            // Accessing the private static method using reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);

            // Test case with an empty array
            String message = "Hello, World!";
            Object[] values = new Object[0]; // empty array
            String result = (String) method.invoke(null, message, values);
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullValues() {
        try {
            // Accessing the private static method using reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);

            // Test case with null values
            String message = "Hello, World!";
            Object[] values = null; // null array
            String result = (String) method.invoke(null, message, values);
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithFormattedValues() {
        try {
            // Accessing the private static method using reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);

            // Test case with formatted values
            String message = "Hello, %s!";
            Object[] values = new Object[]{"World"}; // non-empty array
            String result = (String) method.invoke(null, message, values);
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
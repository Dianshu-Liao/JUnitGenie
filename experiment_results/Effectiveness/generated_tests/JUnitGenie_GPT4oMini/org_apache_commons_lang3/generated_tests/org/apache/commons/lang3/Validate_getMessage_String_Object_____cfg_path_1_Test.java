package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Validate_getMessage_String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNonEmptyValues() {
        try {
            // Accessing the private static method getMessage via reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);
            
            // Prepare test inputs
            String message = "Hello, %s!";
            Object[] values = new Object[] {"World"};
            
            // Invoke the method
            String result = (String) method.invoke(null, message, values);
            
            // Verify the output
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            // Handle exceptions thrown by the method
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithEmptyValues() {
        try {
            // Accessing the private static method getMessage via reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);
            
            // Prepare test inputs
            String message = "Hello, World!";
            Object[] values = null; // Case with empty values
            
            // Invoke the method
            String result = (String) method.invoke(null, message, values);
            
            // Verify the output
            assertEquals("Hello, World!", result);
        } catch (Exception e) {
            // Handle exceptions thrown by the method
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithEmptyObjectArray() {
        try {
            // Accessing the private static method getMessage via reflection
            Method method = Validate.class.getDeclaredMethod("getMessage", String.class, Object[].class);
            method.setAccessible(true);
            
            // Prepare test inputs
            String message = "No values provided.";
            Object[] values = new Object[0]; // Empty array
            
            // Invoke the method
            String result = (String) method.invoke(null, message, values);
            
            // Verify the output
            assertEquals("No values provided.", result);
        } catch (Exception e) {
            // Handle exceptions thrown by the method
            e.printStackTrace();
        }
    }

}
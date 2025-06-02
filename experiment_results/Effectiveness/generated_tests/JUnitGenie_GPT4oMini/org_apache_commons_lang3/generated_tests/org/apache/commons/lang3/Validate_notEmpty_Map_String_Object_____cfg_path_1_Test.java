package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static org.junit.Assert.fail;

public class Validate_notEmpty_Map_String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNotEmpty_WithNonEmptyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        String message = "Map should not be empty.";
        Object[] values = new Object[0];

        // Call the focal method
        Validate.notEmpty(map, message, values);
    }

    @Test(timeout = 4000)
    public void testNotEmpty_WithEmptyMap() {
        Map<String, String> map = new HashMap<>();
        String message = "Map should not be empty.";
        Object[] values = new Object[0];

        try {
            // Call the focal method expecting exception
            Validate.notEmpty(map, message, values);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Exception caught as expected
            // You can add additional assertions on the exception message if needed
        }
    }

    @Test(timeout = 4000)
    public void testNotEmpty_WithNullMap() {
        String message = "Map should not be null.";
        Object[] values = new Object[0];

        try {
            // Call the focal method expecting exception
            Validate.notEmpty((Map<String, String>) null, message, values); // Cast to resolve ambiguity
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Exception caught as expected
        }
    }


}
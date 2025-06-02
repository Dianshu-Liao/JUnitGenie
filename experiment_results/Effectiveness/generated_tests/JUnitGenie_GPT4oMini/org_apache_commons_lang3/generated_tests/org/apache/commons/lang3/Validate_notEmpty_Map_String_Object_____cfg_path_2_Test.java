package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class Validate_notEmpty_Map_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNotEmpty_withNonEmptyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        String message = "Map should not be empty";
        Object[] values = new Object[]{};

        Map<String, String> result = Validate.notEmpty(map, message, values);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test(timeout = 4000)
    public void testNotEmpty_withEmptyMap() {
        Map<String, String> map = new HashMap<>();
        String message = "Map should not be empty";
        Object[] values = new Object[]{};

        try {
            Validate.notEmpty(map, message, values);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Map should not be empty", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNotEmpty_withNullMap() {
        String message = "Map cannot be null";
        Object[] values = new Object[]{};

        try {
            Validate.notEmpty((Map<String, String>) null, message, values); // Cast to resolve ambiguity
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertNotNull(e.getMessage());
        }
    }


}
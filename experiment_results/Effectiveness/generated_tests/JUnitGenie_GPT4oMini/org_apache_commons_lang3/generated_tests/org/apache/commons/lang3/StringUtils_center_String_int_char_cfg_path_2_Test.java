package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_center_String_int_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCenter() {
        String str = "test";
        int size = 10;
        char padChar = '*';

        // Test the center method with appropriate parameters
        String result = null;
        try {
            result = StringUtils.center(str, size, padChar);
        } catch (Exception e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }

        assertEquals("**test****", result);
    }

    @Test(timeout = 4000)
    public void testCenter_NullString() {
        String str = null;
        int size = 10;
        char padChar = '*';

        // Test the center method with a null string
        String result = null;
        try {
            result = StringUtils.center(str, size, padChar);
        } catch (Exception e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }

        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testCenter_InvalidSize() {
        String str = "test";
        int size = 0; // Invalid size
        char padChar = '*';

        // Test the center method with an invalid size
        String result = null;
        try {
            result = StringUtils.center(str, size, padChar);
        } catch (Exception e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }

        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testCenter_SmallSize() {
        String str = "test";
        int size = 3; // Size smaller than string length
        char padChar = '*';

        // Test the center method with a size smaller than the string length
        String result = null;
        try {
            result = StringUtils.center(str, size, padChar);
        } catch (Exception e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }

        assertEquals("test", result);
    }

}
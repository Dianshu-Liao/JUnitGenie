package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSqueeze() {
        // Test input where str is null and set contains non-empty strings
        String str = null;
        String[] set = {"a", "b", "c"};
        String expected = null; // Since str is null, the output should also be null
        String result = null;
        try {
            result = CharSetUtils.squeeze(str, set);
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals(expected, result);

        // Test input where str is empty and set contains non-empty strings
        str = "";
        expected = ""; // Since str is empty, the output should also be empty
        result = null;
        try {
            result = CharSetUtils.squeeze(str, set);
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals(expected, result);

        // Test input where str has repeated characters and set contains characters to squeeze
        str = "aaabbbccc";
        set = new String[]{"a", "b"};
        expected = "abc"; // Squeezed output
        result = null;
        try {
            result = CharSetUtils.squeeze(str, set);
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals(expected, result);
    }

}
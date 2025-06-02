package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullAndEmptyDuringProcessing() {
        try {
            // Test input with `null` for parameter `str` and `set` with one empty string
            String result = CharSetUtils.squeeze(null, new String[]{""});
            assertEquals(null, result);
        } catch (Exception e) {
            // Catching the exception if any occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndNullSet() {
        try {
            // Test input with an empty string and an empty set
            String result = CharSetUtils.squeeze("", null);
            assertEquals("", result);
        } catch (Exception e) {
            // Catching the exception if any occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithMultipleCharacters() {
        try {
            // Test input with a string containing multiple characters and set with one valid character
            String result = CharSetUtils.squeeze("aaabbbcc", new String[]{"a"});
            assertEquals("abc", result);
        } catch (Exception e) {
            // Catching the exception if any occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithSingleCharacter() {
        try {
            // Test input with a single character and set with that character
            String result = CharSetUtils.squeeze("a", new String[]{"a"});
            assertEquals("a", result);
        } catch (Exception e) {
            // Catching the exception if any occurs
            e.printStackTrace();
        }
    }

}
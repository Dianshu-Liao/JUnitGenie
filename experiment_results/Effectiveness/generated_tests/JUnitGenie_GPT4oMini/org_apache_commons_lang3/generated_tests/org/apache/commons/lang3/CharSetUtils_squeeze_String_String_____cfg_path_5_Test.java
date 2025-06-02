package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSqueeze_withNonEmptyStrings() {
        String input = "aaabbbccc";
        String[] set = {"a", "b"};
        // Expected output after squeezing: "abc"
        String expected = "abc";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withEmptyString() {
        String input = "";
        String[] set = {"a", "b"};
        // Expected output: ""
        String expected = "";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withNullString() {
        String input = null;
        String[] set = {"a", "b"};
        // Expected output: null
        String expected = null;

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withDeepEmptySet() {
        String input = "aaa";
        String[] set = {}; // empty set should be considered deep empty
        // Expected output should be "aaa" since set is deep empty
        String expected = "aaa";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withSingleCharacterInSet() {
        String input = "aaabbb";
        String[] set = {"a"}; 
        // Expected output after squeezing: "ab"
        String expected = "ab";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withValidCharacterFromSet() {
        String input = "aaaabbbcc";
        String[] set = {"b"}; 
        // Expected output after squeezing: "abc"
        String expected = "abc";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueeze_withExceptions() {
        try {
            String input = "abc";
            String[] set = null; // should handle null without throwing exception
            CharSetUtils.squeeze(input, set);
            // If no exception, the test passes
        } catch (Exception e) {
            // If it throws, the test fails
            assert false : "Exception should not be thrown for null set";
        }
    }

    @Test(timeout = 4000)
    public void testSqueeze_invalidCharacterInSet() {
        String input = "aaa";
        String[] set = {"z"}; 
        // Expected output should be: "aaa" since 'z' is not in the input
        String expected = "aaa";

        // Invoke the focal method
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

}
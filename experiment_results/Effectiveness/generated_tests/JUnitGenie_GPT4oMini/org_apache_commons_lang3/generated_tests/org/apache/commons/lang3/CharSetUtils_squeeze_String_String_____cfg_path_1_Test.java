package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullStrAndValidSet() {
        // Prepare test inputs
        String str = null; // parameter0 should be null
        String[] set = new String[]{"a", "b", "c"}; // valid set

        // Execute the focal method and capture output
        String result = CharSetUtils.squeeze(str, set);

        // Check that the output is as expected
        assertEquals(null, result); // Expected to return null
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStrAndNonEmptySet() {
        // Prepare test inputs
        String str = "aaabbbc";
        String[] set = new String[]{"a", "b"};

        // Execute the focal method and capture output
        String result = CharSetUtils.squeeze(str, set);

        // Check that the output is as expected
        assertEquals("abc", result); // Expected to squeeze 'a' and 'b'
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStrWithDifferentSets() {
        // Prepare test inputs
        String str = "aaabbbccc";
        String[] set = new String[]{"b", "c"};

        // Execute the focal method and capture output
        String result = CharSetUtils.squeeze(str, set);

        // Check that the output is as expected
        assertEquals("abc", result); // Expected to squeeze 'a' but keep 'b' and 'c'
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptySet() {
        // Prepare test inputs
        String str = "aaa";
        String[] set = new String[]{}; // empty set, which is valid but should not filter anything

        // Execute the focal method and capture output
        String result = CharSetUtils.squeeze(str, set);

        // Check that the output is as expected
        assertEquals("a", result); // The output should still be squeezed 
    }

}
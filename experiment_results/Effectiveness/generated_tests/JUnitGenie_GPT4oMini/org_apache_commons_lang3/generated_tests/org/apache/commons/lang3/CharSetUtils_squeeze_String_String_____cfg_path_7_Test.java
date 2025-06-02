package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        // Test case where str is null
        String result = CharSetUtils.squeeze(null, new String[]{"a"});
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptySet() {
        // Test case where set is empty
        String result = CharSetUtils.squeeze("aaabbb", new String[]{});
        assertEquals("aaabbb", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithValidInput() {
        // Test case with valid input
        String result = CharSetUtils.squeeze("aaabbb", new String[]{"a"});
        assertEquals("ab", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithDeepEmptySet() {
        // Test case where set is deep empty
        String result = CharSetUtils.squeeze("aaabbb", new String[]{null});
        assertEquals("aaabbb", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithSingleElementSet() {
        // Test case with a single element in set
        String result = CharSetUtils.squeeze("aaabbb", new String[]{"b"});
        assertEquals("a", result);
    }

}
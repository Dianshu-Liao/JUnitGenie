package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        String input = "   Hello   World   ";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        String input = "";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNull() {
        String input = null;
        try {
            String result = StringUtils.normalizeSpace(input);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        String input = "   Leading and trailing spaces   ";
        String expected = "Leading and trailing spaces";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMultipleSpaces() {
        String input = "Multiple    spaces";
        String expected = "Multiple spaces";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}
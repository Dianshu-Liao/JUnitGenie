package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharSetUtils_squeeze_String_String_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithValidInput() {
        String input = "aaabbbccc";
        String[] set = {"a", "b"};
        String expected = "abc";
        try {
            String result = CharSetUtils.squeeze(input, set);
            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Unexpected Exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyString() {
        String input = "";
        String[] set = {"a", "b"};
        try {
            String result = CharSetUtils.squeeze(input, set);
            assertEquals(input, result);
        } catch (Exception e) {
            fail("Unexpected Exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        String input = null;
        String[] set = {"a", "b"};
        try {
            String result = CharSetUtils.squeeze(input, set);
            assertNull(result);
        } catch (Exception e) {
            fail("Unexpected Exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullSet() {
        String input = "aaabbbccc";
        String[] set = null;
        String expected = "aaabbbccc";
        try {
            String result = CharSetUtils.squeeze(input, set);
            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Unexpected Exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSqueezeWithDeepEmptySet() {
        String input = "aaabbbccc";
        String[] set = {null, ""};
        try {
            String result = CharSetUtils.squeeze(input, set);
            assertEquals(input, result);
        } catch (Exception e) {
            fail("Unexpected Exception: " + e.getMessage());
        }
    }

}
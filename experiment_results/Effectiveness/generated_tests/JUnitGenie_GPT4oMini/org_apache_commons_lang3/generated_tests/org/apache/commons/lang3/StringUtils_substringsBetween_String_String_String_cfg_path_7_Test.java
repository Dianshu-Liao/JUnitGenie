package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_substringsBetween_String_String_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween_NullString() {
        try {
            String[] result = StringUtils.substringsBetween(null, "open", "close");
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyOpen() {
        try {
            String[] result = StringUtils.substringsBetween("some string", "", "close");
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyClose() {
        try {
            String[] result = StringUtils.substringsBetween("some string", "open", "");
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NoSubstrings() {
        try {
            String[] result = StringUtils.substringsBetween("some string", "open", "close");
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_Success() {
        try {
            String[] result = StringUtils.substringsBetween("openHello close openWorld close", "open", "close");
            String[] expected = {"Hello ", "World "};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

}
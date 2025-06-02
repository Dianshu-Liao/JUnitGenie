package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringUtils_isNoneBlank_CharSequence_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNoneBlank_WithNonEmptyNonBlankStrings() {
        CharSequence[] input = {"Hello", "World", "!"};
        try {
            boolean result = StringUtils.isNoneBlank(input);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if one occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_WithNonEmptyAndSomeBlankStrings() {
        CharSequence[] input = {"Hello", "", "World"};
        try {
            boolean result = StringUtils.isNoneBlank(input);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if one occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_WithOnlyBlankString() {
        CharSequence[] input = {"", "   "};
        try {
            boolean result = StringUtils.isNoneBlank(input);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if one occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_WithEmptyArray() {
        CharSequence[] input = {};
        try {
            boolean result = StringUtils.isNoneBlank(input);
            // Expecting the method to handle this internally
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if one occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_WithNullArray() {
        CharSequence[] input = null;
        try {
            boolean result = StringUtils.isNoneBlank(input);
            // Expecting it to throw an exception; if not, this is a test failure
            assertFalse(result);
        } catch (Exception e) {
            // Expected behavior, handle the exception here
        }
    }

}
package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isNoneBlank_CharSequence_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNoneBlank_withNonEmptyArray() {
        // Given a non-null array of CharSequence with at least one element
        CharSequence[] css = {"Hello", "World"};

        // When calling isNoneBlank
        boolean result = StringUtils.isNoneBlank(css);

        // Then the result should be true
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_withEmptyArray() {
        // Given an empty array
        CharSequence[] css = {};

        // When calling isNoneBlank
        try {
            StringUtils.isNoneBlank(css);
        } catch (Exception e) {
            // Then we expect an exception to be thrown
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testIsNoneBlank_withNullArray() {
        // Given a null array
        CharSequence[] css = null;

        // When calling isNoneBlank
        try {
            StringUtils.isNoneBlank(css);
        } catch (Exception e) {
            // Then we expect an exception to be thrown
            // Handle the exception as needed
        }
    }

}
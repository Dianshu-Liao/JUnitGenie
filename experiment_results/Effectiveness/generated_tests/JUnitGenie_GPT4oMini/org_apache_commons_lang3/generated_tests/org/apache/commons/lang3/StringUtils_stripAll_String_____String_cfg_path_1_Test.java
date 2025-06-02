package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_stripAll_String_____String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStripAll() {
        // Given
        String[] input = {"  hello  ", "  world  "};
        String stripChars = " ";

        // When
        String[] result = null;
        try {
            result = StringUtils.stripAll(input, stripChars);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Then
        String[] expected = {"hello", "world"};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripAll_EmptyArray() {
        // Given
        String[] input = {};
        String stripChars = " ";

        // When
        String[] result = null;
        try {
            result = StringUtils.stripAll(input, stripChars);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Then
        assertArrayEquals(input, result);
    }

    @Test(timeout = 4000)
    public void testStripAll_NullArray() {
        // Given
        String[] input = null;
        String stripChars = " ";

        // When
        String[] result = null;
        try {
            result = StringUtils.stripAll(input, stripChars);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Then
        assertArrayEquals(null, result);
    }

}
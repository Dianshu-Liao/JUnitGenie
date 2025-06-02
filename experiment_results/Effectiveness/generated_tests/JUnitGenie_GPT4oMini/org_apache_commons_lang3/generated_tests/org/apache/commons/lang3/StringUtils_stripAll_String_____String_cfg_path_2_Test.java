package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_stripAll_String_____String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStripAllWithNullArray() {
        String[] input = null;
        String stripChars = " ";
        String[] expected = null;

        try {
            String[] result = StringUtils.stripAll(input, stripChars);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testStripAllWithEmptyArray() {
        String[] input = new String[0];
        String stripChars = " ";
        String[] expected = new String[0];

        try {
            String[] result = StringUtils.stripAll(input, stripChars);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}
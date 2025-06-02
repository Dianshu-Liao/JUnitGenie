package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_join_int_____char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testJoinWithValidData() {
        int[] array = {1, 2, 3};
        char separator = ',';
        String expected = "1,2,3"; // Expected output when joining the integers with a comma
        String actual = StringUtils.join(array, separator);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testJoinWithNullArray() {
        int[] array = null;
        char separator = ',';
        String actual = StringUtils.join(array, separator);
        // Since the method should return null when the array is null
        assertEquals(null, actual);
    }

}
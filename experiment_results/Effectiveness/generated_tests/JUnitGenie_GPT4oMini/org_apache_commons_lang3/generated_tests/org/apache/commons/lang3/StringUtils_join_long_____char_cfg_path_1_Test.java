package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_join_long_____char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testJoinWithValidInput() {
        long[] array = {1, 2, 3};
        char separator = ',';
        String expected = "1,2,3"; // Assuming the join method concatenates the numbers with the separator
        String result = StringUtils.join(array, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testJoinWithNullArray() {
        long[] array = null;
        char separator = ',';
        String result = StringUtils.join(array, separator);
        assertEquals(null, result);
    }

}
package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_join_int_____char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testJoinWithNullArray() {
        try {
            int[] array = null;
            char separator = ',';
            String result = StringUtils.join(array, separator);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}
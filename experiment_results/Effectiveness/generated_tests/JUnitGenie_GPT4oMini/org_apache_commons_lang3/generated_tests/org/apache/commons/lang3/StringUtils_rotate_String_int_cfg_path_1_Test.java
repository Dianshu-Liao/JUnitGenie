package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_rotate_String_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRotateWithNullString() {
        try {
            String result = StringUtils.rotate(null, 5);
            assertNull(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
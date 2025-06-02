package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_rightPad_String_int_String_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        try {
            String result = StringUtils.rightPad(null, 5, " ");
            assertNull(result);
        } catch (Exception e) {
            // Handle Exception
            e.printStackTrace();
        }
    }

}
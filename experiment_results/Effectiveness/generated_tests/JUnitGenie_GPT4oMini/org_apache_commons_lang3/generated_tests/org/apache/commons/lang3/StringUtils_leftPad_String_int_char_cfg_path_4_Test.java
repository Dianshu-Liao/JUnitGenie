package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_leftPad_String_int_char_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testLeftPadWithNullString() {
        try {
            String result = StringUtils.leftPad(null, 5, ' ');
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}
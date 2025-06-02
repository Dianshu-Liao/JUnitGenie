package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String result = StringUtils.rightPad(null, 5, " ");
        assertEquals(null, result);
    }

}
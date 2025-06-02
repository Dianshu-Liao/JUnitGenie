package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_NumberUtils_createBigDecimal_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateBigDecimalWithBlankString() {
        try {
            NumberUtils.createBigDecimal("");
            fail("Expected NumberFormatException to be thrown");
        } catch (NumberFormatException e) {
            assertEquals("A blank string is not a valid number", e.getMessage());
        }
    }

}
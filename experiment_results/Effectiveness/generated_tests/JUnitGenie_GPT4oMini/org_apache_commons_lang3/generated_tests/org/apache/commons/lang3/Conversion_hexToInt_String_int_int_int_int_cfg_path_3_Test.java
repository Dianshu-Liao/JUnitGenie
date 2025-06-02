package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;

public class Conversion_hexToInt_String_int_int_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHexToInt() {
        // Test case where nHex is greater than 0 and does not exceed the limits.
        String src = "1A2B3C4D";
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nHex = 4;  // Testing the first 4 hex digits

        try {
            int result = Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
            assertEquals(0x1A2B3C00, result); // Expected int value from converting hex 1A2B3C
        } catch (Exception e) {
            fail("Exception was thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexToInt_throwsException_whenExceedsLimit() {
        String src = "1A2B3C4D";
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 29; // This will cause the shift value to exceed 32
        int nHex = 1;    // Testing just one hex digit

        try {
            Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", e.getMessage());
            throw e; // Re-throw to ensure the test passes
        }
    }

}
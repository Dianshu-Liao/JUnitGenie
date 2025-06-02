package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Conversion_longToHex_long_int_String_int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testLongToHexWithZeroHexs() {
        // Test case where nHexs is 0, should return dstInit
        String result = Conversion.longToHex(123456789L, 0, "initial", 0, 0);
        assertEquals("initial", result);
    }

    @Test(timeout = 4000)
    public void testLongToHexWithValidParameters() {
        // Test case with valid parameters
        String result = Conversion.longToHex(123456789L, 0, "0000", 0, 2);
        assertEquals("15", result); // 0x15 is the hex representation of the last 8 bits of 123456789
    }

    @Test(timeout = 4000)
    public void testLongToHexWithInvalidNHexs() {
        // Test case where nHexs is too large
        try {
            Conversion.longToHex(123456789L, 0, "0000", 0, 17); // This should throw an exception
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", e.getMessage());
        }
    }

}
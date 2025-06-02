package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Conversion_hexToInt_String_int_int_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHexToIntWithZeroHex() {
        // Test case where nHex is 0, should return dstInit
        int result = Conversion.hexToInt("1A", 0, 5, 0, 0);
        assertEquals(5, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexToIntWithExceedingBits() {
        // Test case where (nHex - 1) * 4 + dstPos >= 32
        Conversion.hexToInt("1A", 0, 0, 30, 8); // This should throw an exception
    }

}
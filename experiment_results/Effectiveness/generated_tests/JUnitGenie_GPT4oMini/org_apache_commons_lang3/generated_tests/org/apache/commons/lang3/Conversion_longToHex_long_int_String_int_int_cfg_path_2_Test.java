package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Conversion_longToHex_long_int_String_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLongToHex() {
        long src = 0x1F; // Example long value
        int srcPos = 0; // Starting position
        String dstInit = ""; // Initial destination string
        int dstPos = 0; // Starting position in destination
        int nHexs = 2; // Number of hex digits to convert

        // Expected output for the given input
        String expected = "1f"; // Expected hex representation

        // Call the focal method
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        // Assert the result
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLongToHexWithZeroHexs() {
        long src = 0x1F;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 0;

        // Expected output should be the same as dstInit
        String expected = dstInit;

        // Call the focal method
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        // Assert the result
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongToHexThrowsException() {
        long src = 0x1F;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 17; // This will cause the exception

        // Call the focal method expecting an exception
        try {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        } catch (IllegalArgumentException e) {
            // Exception is expected, test passes
            throw e;
        }
    }

}
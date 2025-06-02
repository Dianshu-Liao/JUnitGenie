package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Conversion_longToHex_long_int_String_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testLongToHex() {
        long src = 0x1234567890ABCDEFL; // Example long value
        int srcPos = 0; // Starting position
        String dstInit = ""; // Initial destination string
        int dstPos = 0; // Starting position in destination
        int nHexs = 8; // Number of hex digits to convert

        // Expected output for the given input
        String expected = "12345678"; // Expected hex representation

        // Call the focal method
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert the result
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLongToHexWithZeroHexs() {
        long src = 0x1234567890ABCDEFL;
        int srcPos = 0;
        String dstInit = "Initial";
        int dstPos = 0;
        int nHexs = 0;

        // Call the focal method
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert the result is equal to the initial destination
        assertEquals(dstInit, result);
    }

    @Test(timeout = 4000)
    public void testLongToHexThrowsException() {
        long src = 0x1234567890ABCDEFL;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 17; // This should trigger the exception

        try {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", e.getMessage());
        }
    }

}
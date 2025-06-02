package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;

public class Conversion_longToHex_long_int_String_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testLongToHex() {
        long src = 0x1F; // Example long value
        int srcPos = 0; // Starting position
        String dstInit = ""; // Initial destination string
        int dstPos = 0; // Starting position in destination
        int nHexs = 1; // Number of hex digits to convert

        // Expected output for the given input
        String expected = "f"; // Expected hex representation

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

        // Expected output should be the initial string
        String expected = "initial";

        // Call the focal method
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        // Assert the result
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLongToHexThrowsException() {
        long src = 0x1F;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 17; // This will cause the exception

        try {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", e.getMessage());
        }
    }

}
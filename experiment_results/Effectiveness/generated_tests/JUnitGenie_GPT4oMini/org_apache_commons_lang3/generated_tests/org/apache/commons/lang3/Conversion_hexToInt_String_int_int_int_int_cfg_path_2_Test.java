package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;

public class Conversion_hexToInt_String_int_int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHexToInt_ValidInput() {
        String src = "1A3F";
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nHex = 4;

        int result = Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
        assertEquals(0x1A3F, result);
    }

    @Test(timeout = 4000)
    public void testHexToInt_ZeroHex() {
        String src = "1A3F";
        int srcPos = 0;
        int dstInit = 5;
        int dstPos = 0;
        int nHex = 0;

        int result = Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
        assertEquals(dstInit, result);
    }

    @Test(timeout = 4000)
    public void testHexToInt_ExceedingBitLimit() {
        String src = "1A3F";
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 30; // This will cause an exception
        int nHex = 1;

        try {
            Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", e.getMessage());
        }
    }

}
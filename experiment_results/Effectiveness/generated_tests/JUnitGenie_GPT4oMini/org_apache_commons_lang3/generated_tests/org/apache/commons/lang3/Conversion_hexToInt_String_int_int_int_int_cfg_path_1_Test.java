package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;

public class Conversion_hexToInt_String_int_int_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHexToInt_WithValidInput() {
        // Arrange
        final String src = "1A2B";
        final int srcPos = 0;
        final int dstInit = 0;
        final int dstPos = 0;
        final int nHex = 2;

        // Act
        int result = Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);

        // Assert
        assertEquals(0x00001A00, result); // Expecting 1A shifted 0 bits and 2B shifted 4 bits
    }

    @Test(timeout = 4000)
    public void testHexToInt_WhenNHexIsZero() {
        // Arrange
        final String src = "1A2B";
        final int srcPos = 0;
        final int dstInit = 10;
        final int dstPos = 0;
        final int nHex = 0;

        // Act
        int result = Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);

        // Assert
        assertEquals(10, result); // Expecting dstInit
    }

    @Test(timeout = 4000)
    public void testHexToInt_WhenExceedingBitSize() {
        // Arrange
        final String src = "1A2B";
        final int srcPos = 0;
        final int dstInit = 0;
        final int dstPos = 28; // 28 + (nHex - 1) * 4 >= 32 with nHex = 2
        final int nHex = 2;

        // Act & Assert
        try {
            Conversion.hexToInt(src, srcPos, dstInit, dstPos, nHex);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", e.getMessage());
        }
    }

}
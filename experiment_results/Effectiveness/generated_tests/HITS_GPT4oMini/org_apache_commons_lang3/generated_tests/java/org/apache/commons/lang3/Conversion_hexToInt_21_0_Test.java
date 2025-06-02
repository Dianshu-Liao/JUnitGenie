package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class Conversion_hexToInt_21_0_Test {

    @Test
    public void testHexToInt_ValidInput() {
        // Test with valid hexadecimal input
        assertEquals(0x1A, Conversion.hexToInt("1A", 0, 0, 0, 2));
        assertEquals(0xF0F0, Conversion.hexToInt("F0F0", 0, 0, 0, 4));
        assertEquals(0x0000000F, Conversion.hexToInt("0F", 0, 0, 0, 2));
    }

    @Test
    public void testHexToInt_ZeroHex() {
        // Test with nHex = 0
        assertEquals(5, Conversion.hexToInt("1A", 0, 5, 0, 0));
    }

    @Test
    public void testHexToInt_ExceedingBitLimit() {
        // Test exceeding 32 bits
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("1A", 0, 0, 30, 2);
        });
        assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    public void testHexToInt_InvalidHexDigit() {
        // Test with invalid hexadecimal digit
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("G1", 0, 0, 0, 2);
        });
        assertEquals("Cannot interpret 'G' as a hexadecimal digit", exception.getMessage());
    }

    @Test
    public void testHexToInt_ShiftingBits() {
        // Test shifting bits with valid input
        assertEquals(0x000000A0, Conversion.hexToInt("A0", 0, 0, 5, 2));
        assertEquals(0x0000F000, Conversion.hexToInt("F0", 0, 0, 12, 2));
    }

    @Test
    public void testHexToInt_MultipleHexDigits() {
        // Test with multiple hexadecimal digits
        assertEquals(0xC0DE, Conversion.hexToInt("C0DE", 0, 0, 0, 4));
        assertEquals(0xDEAD, Conversion.hexToInt("DEAD", 0, 0, 0, 4));
    }
}

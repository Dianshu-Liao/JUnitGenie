package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
        int result = Conversion.hexToInt("1A3F", 0, 0, 0, 4);
        assertEquals(0x1A3F, result);
    }

    @Test
    public void testHexToInt_ZeroHex() {
        int result = Conversion.hexToInt("1A3F", 0, 0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testHexToInt_ExceedingBitLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // 9 hex digits exceed 32 bits
            Conversion.hexToInt("1A3F", 0, 0, 0, 9);
        });
        assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    public void testHexToInt_NegativeHexDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Negative hex digits
            Conversion.hexToInt("1A3F", 0, 0, 0, -1);
        });
        assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    public void testHexToInt_ValidInputWithShift() {
        // Shifted by 4 bits
        int result = Conversion.hexToInt("1A3F", 0, 0, 4, 4);
        assertEquals(0x1A3F << 4, result);
    }

    @Test
    public void testHexToInt_ValidInputWithDifferentPosition() {
        // 2 hex digits
        int result = Conversion.hexToInt("1A", 0, 0, 0, 2);
        assertEquals(0x1A << 2, result);
    }

    // Reflection test to invoke private method if needed
    private int invokeHexDigitToInt(char hexChar) throws Exception {
        Method method = Conversion.class.getDeclaredMethod("hexDigitToInt", char.class);
        method.setAccessible(true);
        return (int) method.invoke(null, hexChar);
    }

    @Test
    public void testHexDigitToInt() throws Exception {
        assertEquals(10, invokeHexDigitToInt('A'));
        assertEquals(15, invokeHexDigitToInt('F'));
        assertEquals(0, invokeHexDigitToInt('0'));
    }
}

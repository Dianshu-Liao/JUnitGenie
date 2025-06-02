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
        int result = Conversion.hexToInt("1A3", 0, 0, 0, 3);
        assertEquals(0x1A3, result);
    }

    @Test
    public void testHexToInt_ZeroHex() {
        int result = Conversion.hexToInt("1A3", 0, 0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testHexToInt_ExceedingBits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("1A3", 0, 0, 29, 1);
        });
        assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    public void testHexToInt_NegativeHexDigit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("G", 0, 0, 0, 1);
        });
        assertEquals("Cannot interpret 'G' as a hexadecimal digit", exception.getMessage());
    }

    @Test
    public void testHexToInt_ValidInputWithShift() {
        int result = Conversion.hexToInt("F", 0, 0, 0, 1);
        assertEquals(0xF << 0, result);
    }

    @Test
    public void testHexToInt_MultipleHexDigits() {
        int result = Conversion.hexToInt("1F", 0, 0, 0, 2);
        assertEquals(0x1F, result);
    }

    @Test
    public void testHexToInt_ComplexInput() {
        int result = Conversion.hexToInt("ABC", 0, 0, 0, 3);
        assertEquals(0xABC, result);
    }

    // Reflection test case for private method
    @Test
    public void testHexDigitToInt_Reflection() throws Exception {
        Method method = Conversion.class.getDeclaredMethod("hexDigitToInt", char.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, 'A');
        assertEquals(10, result);
    }
}

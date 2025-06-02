package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class Conversion_longToHex_33_0_Test {

    @Test
    public void testLongToHex_ZeroHexes() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "Initial", 0, 0);
        assertEquals("Initial", result);
    }

    @Test
    public void testLongToHex_ValidInput() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 0, 4);
        assertEquals("1234", result);
    }

    @Test
    public void testLongToHex_OverwritingInitial() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 0, 4);
        assertEquals("1234", result);
    }

    @Test
    public void testLongToHex_ValidInputWithPosition() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 2, 4);
        assertEquals("001234", result);
    }

    @Test
    public void testLongToHex_ArgumentTooLarge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 0, 17);
        });
        assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", exception.getMessage());
    }

    @Test
    public void testLongToHex_ExactBoundary() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 0, 16);
        assertEquals("123456789ABCDEF0", result);
    }

    @Test
    public void testLongToHex_EmptyDestinationString() {
        String result = Conversion.longToHex(0x0, 0, "", 0, 1);
        assertEquals("0", result);
    }

    @Test
    public void testLongToHex_OverwriteWithDifferentLength() {
        String result = Conversion.longToHex(0x123456789ABCDEF0L, 0, "0000", 0, 2);
        assertEquals("12", result);
    }

    // Reflection to test private method
    @Test
    public void testIntToHexDigit() throws Exception {
        Method method = Conversion.class.getDeclaredMethod("intToHexDigit", int.class);
        method.setAccessible(true);
        char result = (char) method.invoke(null, 10);
        assertEquals('A', result);
    }
}

package org.apache.commons.lang3;

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
        String result = Conversion.longToHex(0x1F, 0, "", 0, 0);
        assertEquals("", result);
    }

    @Test
    public void testLongToHex_SingleHex() {
        String result = Conversion.longToHex(0x1F, 0, "", 0, 1);
        assertEquals("f", result);
    }

    @Test
    public void testLongToHex_MultipleHexes() {
        String result = Conversion.longToHex(0x1F, 0, "", 0, 2);
        assertEquals("1f", result);
    }

    @Test
    public void testLongToHex_OverwriteHex() {
        String result = Conversion.longToHex(0x1F, 0, "00", 0, 2);
        assertEquals("1f", result);
    }

    @Test
    public void testLongToHex_OffsetPosition() {
        String result = Conversion.longToHex(0x1F, 0, "00", 1, 1);
        assertEquals("0f", result);
    }

    @Test
    public void testLongToHex_IllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToHex(0x1F, 0, "", 0, 17);
        });
        assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", exception.getMessage());
    }

    @Test
    public void testLongToHex_ValidHexWithInit() {
        String result = Conversion.longToHex(0x1234567890ABCDEFL, 0, "1234", 2, 4);
        assertEquals("12345678", result);
    }

    @Test
    public void testLongToHex_LargeValue() {
        String result = Conversion.longToHex(0xFFFFFFFFFFFFFFFFL, 0, "", 0, 16);
        assertEquals("ffffffffffffffff", result);
    }

    @Test
    public void testLongToHex_EmptyDestinationString() {
        String result = Conversion.longToHex(0x1F, 0, "", 0, 1);
        assertEquals("f", result);
    }

    @Test
    public void testLongToHex_OverwriteWithDifferentLength() {
        String result = Conversion.longToHex(0x1F, 0, "abcd", 0, 2);
        assertEquals("1bcd", result);
    }

    @Test
    public void testLongToHex_ZeroValue() {
        String result = Conversion.longToHex(0x0, 0, "", 0, 1);
        assertEquals("0", result);
    }
}

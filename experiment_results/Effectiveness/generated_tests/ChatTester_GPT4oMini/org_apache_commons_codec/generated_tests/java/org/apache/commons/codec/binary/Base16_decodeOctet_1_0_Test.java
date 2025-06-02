package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base16_decodeOctet_1_0_Test {

    private Base16 base16;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
    }

    @Test
    void testDecodeOctet_ValidUpperCase() throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        // 10 in decimal
        byte input = 'A';
        int expected = 10;
        int result = (int) method.invoke(base16, input);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeOctet_ValidLowerCase() throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        // 10 in decimal
        byte input = 'a';
        int expected = 10;
        int result = (int) method.invoke(base16, input);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeOctet_ValidDigit() throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        // 5 in decimal
        byte input = '5';
        int expected = 5;
        int result = (int) method.invoke(base16, input);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeOctet_InvalidValue() throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        // Invalid character
        byte input = 'G';
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(base16, input);
        });
        assertEquals("Invalid octet in encoded value: 71", exception.getMessage());
    }

    @Test
    void testDecodeOctet_OutOfBounds() throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        // Out of bounds
        byte input = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(base16, input);
        });
        assertEquals("Invalid octet in encoded value: -1", exception.getMessage());
    }
}

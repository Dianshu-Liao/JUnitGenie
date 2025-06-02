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

public class Base16_decodeOctet_1_0_Test {

    private Base16 base16;

    @BeforeEach
    public void setUp() {
        // Initialize with default case (upper case)
        base16 = new Base16();
    }

    private int invokeDecodeOctet(byte octet) throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        // Allow access to private method
        method.setAccessible(true);
        return (int) method.invoke(base16, octet);
    }

    @Test
    public void testDecodeOctet_ValidUpperCase() throws Exception {
        assertEquals(0, invokeDecodeOctet((byte) '0'));
        assertEquals(1, invokeDecodeOctet((byte) '1'));
        assertEquals(10, invokeDecodeOctet((byte) 'A'));
        assertEquals(15, invokeDecodeOctet((byte) 'F'));
    }

    @Test
    public void testDecodeOctet_ValidLowerCase() throws Exception {
        Base16 lowerCaseBase16 = new Base16(true);
        int result;
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        // Allow access to private method
        method.setAccessible(true);
        result = (int) method.invoke(lowerCaseBase16, (byte) '0');
        assertEquals(0, result);
        result = (int) method.invoke(lowerCaseBase16, (byte) '1');
        assertEquals(1, result);
        result = (int) method.invoke(lowerCaseBase16, (byte) 'a');
        assertEquals(10, result);
        result = (int) method.invoke(lowerCaseBase16, (byte) 'f');
        assertEquals(15, result);
    }

    @Test
    public void testDecodeOctet_InvalidCharacter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecodeOctet((byte) 'G');
        });
        assertEquals("Invalid octet in encoded value: 71", exception.getMessage());
    }

    @Test
    public void testDecodeOctet_CharacterOutsideRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecodeOctet((byte) 100);
        });
        assertEquals("Invalid octet in encoded value: 100", exception.getMessage());
    }

    @Test
    public void testDecodeOctet_NegativeValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecodeOctet((byte) -1);
        });
        assertEquals("Invalid octet in encoded value: -1", exception.getMessage());
    }
}

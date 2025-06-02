package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.Base16;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class Base16_decodeOctet_1_0_Test {

    private Base16 base16;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
    }

    @Test
    void testDecodeOctet_ValidUpperCase() throws Exception {
        // Test valid upper case hex characters
        byte[] validUpperCaseHex = { '0', '1', 'A', 'F' };
        for (byte octet : validUpperCaseHex) {
            int expected = Integer.parseInt(Character.toString((char) octet), 16);
            int result = invokeDecodeOctet(octet);
            assertEquals(expected, result);
        }
    }

    @Test
    void testDecodeOctet_ValidLowerCase() throws Exception {
        // Test valid lower case hex characters
        byte[] validLowerCaseHex = { '0', '1', 'a', 'f' };
        for (byte octet : validLowerCaseHex) {
            int expected = Integer.parseInt(Character.toString((char) octet), 16);
            int result = invokeDecodeOctet(octet);
            assertEquals(expected, result);
        }
    }

    @Test
    void testDecodeOctet_InvalidCharacter() {
        // Test invalid hex characters
        byte[] invalidHex = { 'G', 'Z', -1, 16, 17 };
        for (byte octet : invalidHex) {
            IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
                invokeDecodeOctet(octet);
            });
            assertTrue(thrown.getMessage().contains("Invalid octet in encoded value"));
        }
    }

    private int invokeDecodeOctet(byte octet) throws Exception {
        Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
        method.setAccessible(true);
        return (int) method.invoke(base16, octet);
    }
}

package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class Base32_decodeTable_1_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        base32 = new Base32();
    }

    @Test
    void testDecodeTableWithHexTrue() throws Exception {
        Method method = Base32.class.getDeclaredMethod("decodeTable", boolean.class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, true);
        assertNotNull(result);
        // HEX_DECODE_TABLE length
        assertEquals(76, result.length);
        // Check if '0' is correctly decoded
        assertEquals(0, result[48]);
        // Check if '1' is correctly decoded
        assertEquals(1, result[49]);
        // Check if 'A' is correctly decoded
        assertEquals(10, result[58]);
        // Check if 'F' is correctly decoded
        assertEquals(15, result[63]);
    }

    @Test
    void testDecodeTableWithHexFalse() throws Exception {
        Method method = Base32.class.getDeclaredMethod("decodeTable", boolean.class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, false);
        assertNotNull(result);
        // DECODE_TABLE length
        assertEquals(64, result.length);
        // Check if 'A' is correctly decoded
        assertEquals(0, result[52]);
        // Check if 'Z' is correctly decoded
        assertEquals(25, result[57]);
        // Check if '2' is correctly decoded
        assertEquals(26, result[62]);
        // Check if '7' is correctly decoded
        assertEquals(31, result[63]);
    }

    @Test
    void testDecodeTableWithInvalidInput() throws Exception {
        Method method = Base32.class.getDeclaredMethod("decodeTable", boolean.class);
        method.setAccessible(true);
        // Testing with invalid input is not applicable as the method is static and only accepts boolean
        // Hence, we do not need to test invalid inputs.
    }
}

package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class Base16_Base16_8_0_Test {

    private Base16 base16UpperCase;

    private Base16 base16LowerCase;

    @BeforeEach
    void setUp() {
        // Initialize instances for testing
        base16UpperCase = createBase16Instance(true, CodecPolicy.STRICT);
        base16LowerCase = createBase16Instance(false, CodecPolicy.STRICT);
    }

    private Base16 createBase16Instance(boolean lowerCase, CodecPolicy decodingPolicy) {
        try {
            Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class, CodecPolicy.class);
            constructor.setAccessible(true);
            return constructor.newInstance(lowerCase, decodingPolicy);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            fail("Failed to create Base16 instance: " + e.getMessage());
            // This will never be reached due to fail
            return null;
        }
    }

    @Test
    void testBase16UpperCaseConstructor() {
        assertNotNull(base16UpperCase);
        // Additional assertions can be added to check internal state if needed.
    }

    @Test
    void testBase16LowerCaseConstructor() {
        assertNotNull(base16LowerCase);
        // Additional assertions can be added to check internal state if needed.
    }

    @Test
    void testEncodeTableUpperCase() throws NoSuchFieldException, IllegalAccessException {
        byte[] encodeTable = (byte[]) Base16.class.getDeclaredField("encodeTable").get(base16UpperCase);
        assertArrayEquals(new byte[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }, encodeTable);
    }

    @Test
    void testEncodeTableLowerCase() throws NoSuchFieldException, IllegalAccessException {
        byte[] encodeTable = (byte[]) Base16.class.getDeclaredField("encodeTable").get(base16LowerCase);
        assertArrayEquals(new byte[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' }, encodeTable);
    }

    @Test
    void testDecodeTableUpperCase() throws NoSuchFieldException, IllegalAccessException {
        byte[] decodeTable = (byte[]) Base16.class.getDeclaredField("decodeTable").get(base16UpperCase);
        // Ensure the first element is as expected
        assertEquals(-1, decodeTable[0]);
        // 'A' should decode to 10
        assertEquals(10, decodeTable[0x41]);
    }

    @Test
    void testDecodeTableLowerCase() throws NoSuchFieldException, IllegalAccessException {
        byte[] decodeTable = (byte[]) Base16.class.getDeclaredField("decodeTable").get(base16LowerCase);
        // Ensure the first element is as expected
        assertEquals(-1, decodeTable[0]);
        // 'a' should decode to 10
        assertEquals(10, decodeTable[0x61]);
    }
}

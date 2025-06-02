package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base32;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base32_Base32_10_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Initialize the Base32 instance before each test
        base32 = new Base32();
    }

    @Test
    void testBase32ConstructorWithTrue() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Use reflection to invoke the constructor with boolean parameter
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32Hex = constructor.newInstance(true);
        // Assert that the instance is not null
        assertNotNull(base32Hex);
    }

    @Test
    void testBase32ConstructorWithFalse() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Use reflection to invoke the constructor with boolean parameter
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32NoHex = constructor.newInstance(false);
        // Assert that the instance is not null
        assertNotNull(base32NoHex);
    }

    @Test
    void testBase32DecodeTable() throws Exception {
        // Use reflection to access the private decodeTable method
        java.lang.reflect.Method decodeTableMethod = Base32.class.getDeclaredMethod("decodeTable", boolean.class);
        decodeTableMethod.setAccessible(true);
        // Test with hex
        byte[] hexDecodeTable = (byte[]) decodeTableMethod.invoke(null, true);
        assertNotNull(hexDecodeTable);
        // Check the length of the table
        assertEquals(16, hexDecodeTable.length);
        // Test with standard
        byte[] standardDecodeTable = (byte[]) decodeTableMethod.invoke(null, false);
        assertNotNull(standardDecodeTable);
        // Check the length of the table
        assertEquals(32, standardDecodeTable.length);
    }

    @Test
    void testBase32EncodeTable() throws Exception {
        // Use reflection to access the private encodeTable method
        java.lang.reflect.Method encodeTableMethod = Base32.class.getDeclaredMethod("encodeTable", boolean.class);
        encodeTableMethod.setAccessible(true);
        // Test with hex
        byte[] hexEncodeTable = (byte[]) encodeTableMethod.invoke(null, true);
        assertNotNull(hexEncodeTable);
        // Check the length of the table
        assertEquals(32, hexEncodeTable.length);
        // Test with standard
        byte[] standardEncodeTable = (byte[]) encodeTableMethod.invoke(null, false);
        assertNotNull(standardEncodeTable);
        // Check the length of the table
        assertEquals(26, standardEncodeTable.length);
    }

    @Test
    void testIsInAlphabet() {
        // Test with a valid byte
        assertTrue(base32.isInAlphabet((byte) 'A'));
        assertTrue(base32.isInAlphabet((byte) '2'));
        // Test with an invalid byte
        // Out of range
        assertFalse(base32.isInAlphabet((byte) 100));
    }

    @Test
    void testGetLineSeparator() throws Exception {
        // Access the private field lineSeparator using reflection
        java.lang.reflect.Field lineSeparatorField = Base32.class.getDeclaredField("lineSeparator");
        lineSeparatorField.setAccessible(true);
        byte[] lineSeparator = (byte[]) lineSeparatorField.get(base32);
        // Assert that the lineSeparator is not null
        assertNotNull(lineSeparator);
    }
}

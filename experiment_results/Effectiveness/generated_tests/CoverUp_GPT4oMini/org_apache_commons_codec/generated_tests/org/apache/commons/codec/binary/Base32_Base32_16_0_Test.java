package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
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

class Base32_Base32_16_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for the tests
    }

    @Test
    void testBase32ConstructorWithValidParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte padding = '=';
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithNullLineSeparator() {
        int lineLength = 8;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        });
        assertEquals("lineLength 8 > 0, but lineSeparator is null", exception.getMessage());
    }

    @Test
    void testBase32ConstructorWithInvalidPadding() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        // Invalid padding as it's part of the Base32 alphabet
        byte padding = 'A';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        });
        assertEquals("pad must not be in alphabet or whitespace", exception.getMessage());
    }

    @Test
    void testBase32ConstructorWithInvalidLineSeparatorContainingAlphabet() {
        int lineLength = 8;
        // Contains Base32 character
        byte[] lineSeparator = new byte[] { 'A' };
        boolean useHex = false;
        byte padding = '=';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain Base32 characters"));
    }

    @Test
    void testBase32ConstructorWithZeroLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        int lineLength = 0;
        // Should work with null separator
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32);
        assertNull(base32.getLineSeparator());
    }
}

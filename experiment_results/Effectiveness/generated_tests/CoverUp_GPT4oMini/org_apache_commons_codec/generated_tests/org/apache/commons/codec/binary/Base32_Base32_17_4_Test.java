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

class Base32_Base32_17_4_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Setup for the tests
        int lineLength = 0;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        // Use reflection to invoke the private constructor
        try {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            base32 = constructor.newInstance(lineLength, lineSeparator, useHex, padding, decodingPolicy);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            fail("Failed to create Base32 instance: " + e.getMessage());
        }
    }

    @Test
    void testBase32ConstructorWithValidParameters() {
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthAndSeparator() {
        int lineLength = 10;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte padding = '=';
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        // Use reflection to invoke the constructor
        try {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            Base32 base32WithLineSeparator = constructor.newInstance(lineLength, lineSeparator, useHex, padding, decodingPolicy);
            assertNotNull(base32WithLineSeparator);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            fail("Failed to create Base32 instance with line separator: " + e.getMessage());
        }
    }

    @Test
    void testBase32ConstructorWithInvalidLineSeparator() {
        int lineLength = 1;
        // Invalid, as 'A' is in the Base32 alphabet
        byte[] lineSeparator = new byte[] { 'A' };
        boolean useHex = false;
        byte padding = '=';
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding, decodingPolicy);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain Base32 characters"));
    }

    @Test
    void testBase32ConstructorWithInvalidPadding() {
        int lineLength = 0;
        byte[] lineSeparator = null;
        boolean useHex = false;
        // Invalid padding, as 'A' is in the Base32 alphabet
        byte padding = 'A';
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding, decodingPolicy);
        });
        assertTrue(exception.getMessage().contains("pad must not be in alphabet or whitespace"));
    }
}

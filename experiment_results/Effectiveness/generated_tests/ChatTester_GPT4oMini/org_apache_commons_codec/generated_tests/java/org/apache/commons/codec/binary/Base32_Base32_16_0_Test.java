package org.apache.commons.codec.binary;

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

class Base32_Base32_16_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Initialize with default values for testing
        base32 = new Base32();
    }

    @Test
    void testBase32ConstructorWithLineLengthAndSeparator() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Given
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte padding = '=';
        // When
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        // Then
        assertNotNull(base32Instance);
        assertArrayEquals(lineSeparator, base32Instance.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithHexEncoding() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Given
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        byte padding = '=';
        // When
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        // Then
        assertNotNull(base32Instance);
        assertArrayEquals(lineSeparator, base32Instance.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithNullLineSeparator() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Given
        int lineLength = 76;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        // When
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        // Then
        assertNotNull(base32Instance);
        assertNull(base32Instance.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithInvalidLineLength() {
        // Given
        // Invalid line length
        int lineLength = -1;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte padding = '=';
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex, padding);
        });
    }
}

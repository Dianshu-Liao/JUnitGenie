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

class Base32_Base32_14_1_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Initialize Base32 with default parameters
        base32 = new Base32();
    }

    @Test
    void testBase32ConstructorWithLineLengthAndLineSeparator() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        byte[] lineSeparator = new byte[] { '\n' };
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(8, lineSeparator);
        assertNotNull(base32Instance);
        assertArrayEquals(lineSeparator, base32Instance.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithLineLengthAndNullSeparator() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(8, null);
        });
    }

    @Test
    void testBase32ConstructorWithLineLengthAndInvalidSeparator() {
        // 'A' is a Base32 character
        byte[] invalidSeparator = new byte[] { 'A' };
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(8, invalidSeparator);
        });
    }

    @Test
    void testBase32ConstructorWithLineLengthAndValidSeparator() {
        byte[] validSeparator = new byte[] { '-' };
        Base32 base32Instance = new Base32(8, validSeparator);
        assertNotNull(base32Instance);
        assertArrayEquals(validSeparator, base32Instance.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithPadding() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(8, null, false, (byte) '=');
        assertNotNull(base32Instance);
    }

    @Test
    void testBase32ConstructorWithHex() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32Instance = constructor.newInstance(true);
        assertNotNull(base32Instance);
    }
}

package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base32;
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

class Base32_Base32_15_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Setup method to initialize common test data
    }

    @Test
    void testBase32ConstructorWithLineLengthZero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        byte[] lineSeparator = null;
        boolean useHex = false;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(0, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(null, base32.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithLineLengthPositive() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(8, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithHex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(8, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    void testBase32ConstructorWithNullLineSeparator() {
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(1, null, false);
        });
    }

    @Test
    void testBase32ConstructorWithInvalidPadding() {
        byte[] lineSeparator = new byte[] { 'A' };
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(8, lineSeparator, false);
        });
    }
}

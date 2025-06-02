package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base32_Base32_9_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        base32 = new Base32();
    }

    @Test
    void testBase32DefaultConstructor() {
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithHex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32Hex = constructor.newInstance(true);
        assertNotNull(base32Hex);
    }

    @Test
    void testBase32ConstructorWithPadding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(byte.class);
        constructor.setAccessible(true);
        Base32 base32WithPadding = constructor.newInstance((byte) '=');
        assertNotNull(base32WithPadding);
    }

    @Test
    void testBase32ConstructorWithLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base32 base32WithLineLength = constructor.newInstance(76);
        assertNotNull(base32WithLineLength);
    }

    @Test
    void testBase32ConstructorWithLineLengthAndSeparator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class);
        constructor.setAccessible(true);
        Base32 base32WithLineLengthAndSeparator = constructor.newInstance(76, new byte[] { '\n' });
        assertNotNull(base32WithLineLengthAndSeparator);
    }

    @Test
    void testBase32ConstructorWithAllParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class, byte.class, CodecPolicy.class);
        constructor.setAccessible(true);
        Base32 fullConstructorBase32 = constructor.newInstance(76, new byte[] { '\n' }, true, (byte) '=', null);
        assertNotNull(fullConstructorBase32);
    }

    @Test
    void testBase32ConstructorWithInvalidLineLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(-1);
        });
    }

    @Test
    void testBase32ConstructorWithInvalidHex() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(true, (byte) 0);
        });
    }

    @Test
    void testBase32ConstructorWithInvalidPadding() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32((byte) -1);
        });
    }
}

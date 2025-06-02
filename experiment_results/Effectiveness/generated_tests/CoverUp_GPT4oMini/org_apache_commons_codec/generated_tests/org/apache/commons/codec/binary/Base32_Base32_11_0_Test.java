package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

class Base32_Base32_11_0_Test {

    @Test
    void testBase32ConstructorWithHexAndPadding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        boolean useHex = true;
        byte padding = '=';
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(useHex, padding);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithNonHexAndPadding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        boolean useHex = false;
        byte padding = '=';
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class, byte.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(useHex, padding);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithHex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        boolean useHex = true;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(useHex);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithNonHex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        boolean useHex = false;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(useHex);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithPadding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        byte padding = '=';
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(byte.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(padding);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int lineLength = 76;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthAndSeparator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength, lineSeparator);
        // Assert
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthSeparatorAndHex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        boolean useHex = true;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength, lineSeparator, useHex);
        // Assert
        assertNotNull(base32);
    }
}

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

public class Base32_Base32_15_0_Test {

    @Test
    public void testBase32ConstructorWithValidParameters() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength, lineSeparator, useHex);
        // Assert
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithHex() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int lineLength = 76;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        // Act
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength, lineSeparator, useHex);
        // Assert
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithInvalidLineLength() {
        // Arrange
        // Invalid line length
        int lineLength = -1;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex);
        });
    }

    @Test
    public void testBase32ConstructorWithNullLineSeparator() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int lineLength = 76;
        // Null line separator
        byte[] lineSeparator = null;
        boolean useHex = false;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(lineLength, lineSeparator, useHex);
        });
    }
}

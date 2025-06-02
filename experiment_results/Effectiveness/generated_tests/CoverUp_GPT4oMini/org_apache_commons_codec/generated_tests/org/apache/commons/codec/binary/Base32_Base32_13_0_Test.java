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

class Base32_Base32_13_0_Test {

    @Test
    void testBase32ConstructorWithValidLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Test with a valid line length
        int lineLength = 32;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength);
        // Assertions to verify that the object is created correctly
        assertNotNull(base32);
        assertEquals(32, getLineLength(base32));
        assertArrayEquals(new byte[] {}, getLineSeparator(base32));
    }

    @Test
    void testBase32ConstructorWithZeroLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Test with line length of zero
        int lineLength = 0;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base32 base32 = constructor.newInstance(lineLength);
        // Assertions to verify that the object is created correctly
        assertNotNull(base32);
        assertEquals(0, getLineLength(base32));
        assertArrayEquals(new byte[] {}, getLineSeparator(base32));
    }

    @Test
    void testBase32ConstructorWithNegativeLineLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Test with a negative line length
        int lineLength = -1;
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance(lineLength);
        });
        // Check if the exception is thrown
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
    }

    private int getLineLength(Base32 base32) {
        try {
            return (int) Base32.class.getDeclaredField("lineLength").get(base32);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getLineSeparator(Base32 base32) {
        try {
            return (byte[]) Base32.class.getDeclaredField("lineSeparator").get(base32);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}

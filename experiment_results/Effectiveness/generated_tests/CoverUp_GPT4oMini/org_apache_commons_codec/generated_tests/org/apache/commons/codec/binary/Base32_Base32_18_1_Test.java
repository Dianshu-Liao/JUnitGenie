package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.StringUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base32_Base32_18_1_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Initialize Base32 with a valid configuration
        byte[] lineSeparator = new byte[] { '\n' };
        CodecPolicy codecPolicy = CodecPolicy.STRICT;
        try {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, byte[].class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            base32 = constructor.newInstance(64, lineSeparator, new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7' }, (byte) '=', codecPolicy);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            fail("Failed to create Base32 instance: " + e.getMessage());
        }
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(base32);
        assertArrayEquals(new byte[] { '\n' }, base32.getLineSeparator());
    }

    @Test
    void testConstructorWithNullLineSeparator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, byte[].class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            constructor.newInstance(64, null, new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7' }, (byte) '=', CodecPolicy.STRICT);
        });
        assertTrue(exception.getMessage().contains("lineSeparator is null"));
    }

    @Test
    void testConstructorWithLineLengthGreaterThanZeroAndNullSeparator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(int.class, byte[].class, byte[].class, byte.class, CodecPolicy.class);
            constructor.setAccessible(true);
            constructor.newInstance(1, null, new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7' }, (byte) '=', CodecPolicy.STRICT);
        });
        assertTrue(exception.getMessage().contains("lineLength 1 > 0, but lineSeparator is null"));
    }
}

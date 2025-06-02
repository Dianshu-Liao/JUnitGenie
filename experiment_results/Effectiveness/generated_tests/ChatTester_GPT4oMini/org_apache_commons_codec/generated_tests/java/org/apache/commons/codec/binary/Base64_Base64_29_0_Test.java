package org.apache.commons.codec.binary;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base64_Base64_29_0_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        // Initialize with a line length of 76 (common for Base64 encoding)
        base64 = new Base64(76);
    }

    @Test
    void testBase64ConstructorWithLineLength() {
        // Test if the constructor initializes correctly
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithUrlSafe() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Test the constructor with URL safe option
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 urlSafeBase64 = constructor.newInstance(true);
        assertNotNull(urlSafeBase64);
    }

    @Test
    void testBase64ConstructorWithLineLengthAndSeparator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Test constructor with line length and custom separator
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class);
        constructor.setAccessible(true);
        Base64 customSeparatorBase64 = constructor.newInstance(76, new byte[] { '\n' });
        assertNotNull(customSeparatorBase64);
    }

    @Test
    void testBase64ConstructorWithAllParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class, boolean.class);
        constructor.setAccessible(true);
        Base64 allParamsBase64 = constructor.newInstance(76, new byte[] { '\n' }, true);
        assertNotNull(allParamsBase64);
    }

    @Test
    void testBase64ConstructorWithVariousLineLengths() {
        // Test the constructor with a specific line length
        assertDoesNotThrow(() -> new Base64(100));
        assertDoesNotThrow(() -> new Base64(0));
        // Assuming negative line length is handled gracefully
        assertDoesNotThrow(() -> new Base64(-1));
    }
}

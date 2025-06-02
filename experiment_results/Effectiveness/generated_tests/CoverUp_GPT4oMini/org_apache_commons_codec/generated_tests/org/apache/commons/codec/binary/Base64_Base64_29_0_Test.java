package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base64_Base64_29_0_Test {

    @Test
    void testBase64ConstructorWithValidLineLength() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Test with a valid line length
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base64 base64Instance = constructor.newInstance(76);
        assertNotNull(base64Instance);
        assertFalse(base64Instance.isUrlSafe());
    }

    @Test
    void testBase64ConstructorWithZeroLineLength() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Test with zero line length
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base64 base64Instance = constructor.newInstance(0);
        assertNotNull(base64Instance);
        assertFalse(base64Instance.isUrlSafe());
    }

    @Test
    void testBase64ConstructorWithNegativeLineLength() {
        // Test with negative line length
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            constructor.newInstance(-1);
        });
    }

    @Test
    void testBase64ConstructorWithLargeLineLength() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Test with a large line length
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Base64 base64Instance = constructor.newInstance(1000);
        assertNotNull(base64Instance);
        assertFalse(base64Instance.isUrlSafe());
    }

    @Test
    void testBase64ConstructorWithUrlSafe() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Test with url safe constructor
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, boolean.class);
        constructor.setAccessible(true);
        Base64 base64Instance = constructor.newInstance(76, true);
        assertNotNull(base64Instance);
        assertTrue(base64Instance.isUrlSafe());
    }
}

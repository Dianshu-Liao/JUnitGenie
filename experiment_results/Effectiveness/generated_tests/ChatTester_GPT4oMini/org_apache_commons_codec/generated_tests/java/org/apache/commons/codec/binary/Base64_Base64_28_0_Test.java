package org.apache.commons.codec.binary;

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

public class // Additional tests can be added here to cover more functionality of the Base64 class
Base64_Base64_28_0_Test {

    private Base64 base64;

    @BeforeEach
    public void setUp() {
        // Initialize the Base64 object using the constructor with urlSafe parameter
        try {
            Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
            constructor.setAccessible(true);
            // or false for the other case
            base64 = constructor.newInstance(true);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBase64ConstructorWithUrlSafe() {
        // Ensure that the Base64 object is not null
        assertNotNull(base64);
        // Check if the object was initialized with urlSafe set to true
        assertTrue(base64.isUrlSafe(), "Expected Base64 to be initialized as URL safe");
    }

    @Test
    public void testBase64ConstructorWithUrlSafeFalse() {
        // Initialize the Base64 object with urlSafe set to false
        try {
            Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
            constructor.setAccessible(true);
            base64 = constructor.newInstance(false);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // Ensure that the Base64 object is not null
        assertNotNull(base64);
        // Check if the object was initialized with urlSafe set to false
        assertTrue(!base64.isUrlSafe(), "Expected Base64 to be initialized as not URL safe");
    }
}

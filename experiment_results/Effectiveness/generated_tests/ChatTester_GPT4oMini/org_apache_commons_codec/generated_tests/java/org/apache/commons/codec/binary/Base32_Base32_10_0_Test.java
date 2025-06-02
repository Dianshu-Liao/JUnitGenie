package org.apache.commons.codec.binary;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base32_Base32_10_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Prepare the instance of Base32 using the focal method
        base32 = invokeConstructorWithBoolean(true);
    }

    private Base32 invokeConstructorWithBoolean(boolean useHex) {
        try {
            Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
            constructor.setAccessible(true);
            return constructor.newInstance(useHex);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke constructor", e);
        }
    }

    @Test
    void testBase32ConstructorWithHex() {
        assertNotNull(base32, "Base32 instance should not be null");
    }

    @Test
    void testBase32ConstructorWithHexNotNull() {
        Base32 base32Hex = invokeConstructorWithBoolean(true);
        assertNotNull(base32Hex, "Base32 instance with hex should not be null");
    }

    @Test
    void testBase32ConstructorWithHexDifferentInstance() {
        Base32 base32Hex1 = invokeConstructorWithBoolean(true);
        Base32 base32Hex2 = invokeConstructorWithBoolean(true);
        assertNotNull(base32Hex1);
        assertNotNull(base32Hex2);
        assertNotSame(base32Hex1, base32Hex2, "Each instance should be different");
    }

    @Test
    void testBase32ConstructorWithNonHex() {
        Base32 base32NonHex = invokeConstructorWithBoolean(false);
        assertNotNull(base32NonHex, "Base32 instance with non-hex should not be null");
    }
}

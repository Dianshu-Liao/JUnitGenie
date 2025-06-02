package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

class Base64_Base64_30_0_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        base64 = new Base64();
    }

    @Test
    void testBase64EncodingWithValidInput() throws Exception {
        byte[] input = "Hello".getBytes();
        byte[] expectedOutput = { 'S', 'G', 'V', 's', 'b', 'w', '=' };
        byte[] actualOutput = invokeBase64Method(0, input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testBase64EncodingWithEmptyInput() throws Exception {
        byte[] input = {};
        byte[] expectedOutput = {};
        byte[] actualOutput = invokeBase64Method(0, input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testBase64EncodingWithNullInput() throws Exception {
        byte[] actualOutput = invokeBase64Method(0, null);
        assertNull(actualOutput);
    }

    @Test
    void testBase64EncodingWithUrlSafe() throws Exception {
        byte[] input = "Hello".getBytes();
        byte[] expectedOutput = { 'S', 'G', 'V', 's', 'b', 'w', '-' };
        Base64 urlSafeBase64 = new Base64(0, null, true);
        byte[] actualOutput = invokeBase64Method(0, input, urlSafeBase64);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    private byte[] invokeBase64Method(int lineLength, byte[] input) throws Exception {
        return invokeBase64Method(lineLength, input, base64);
    }

    private byte[] invokeBase64Method(int lineLength, byte[] input, Base64 base64Instance) throws Exception {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class);
        constructor.setAccessible(true);
        Base64 instance = constructor.newInstance(lineLength, null);
        Method method = Base64.class.getDeclaredMethod("Base64", int.class, byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(instance, lineLength, input);
    }
}

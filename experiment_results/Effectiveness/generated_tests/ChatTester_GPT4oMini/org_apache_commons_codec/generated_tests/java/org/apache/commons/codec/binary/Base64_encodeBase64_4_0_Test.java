package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

public class Base64_encodeBase64_4_0_Test {

    @Test
    public void testEncodeBase64() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        // Example input
        byte[] input = "Hello".getBytes();
        byte[] expectedOutput = new byte[] { // Expected Base64 encoding of "Hello"
        // Expected Base64 encoding of "Hello"
        // Expected Base64 encoding of "Hello"
        'S', // Expected Base64 encoding of "Hello"
        'G', // Expected Base64 encoding of "Hello"
        'V', // Expected Base64 encoding of "Hello"
        's', // Expected Base64 encoding of "Hello"
        'b', // Expected Base64 encoding of "Hello"
        'G', '8', '=' };
        // Act
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, input);
        // Assert
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testEncodeBase64WithEmptyInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        // Empty input
        byte[] input = new byte[0];
        // Expected output for empty input
        byte[] expectedOutput = new byte[0];
        // Act
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, input);
        // Assert
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testEncodeBase64WithNullInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        // Null input
        byte[] input = null;
        // Act & Assert
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class);
        method.setAccessible(true);
        assertThrows(NullPointerException.class, () -> {
            method.invoke(null, input);
        });
    }

    @Test
    public void testEncodeBase64WithSpecialCharacters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        // Input with special characters
        byte[] input = "!@#$%^&*()".getBytes();
        byte[] expectedOutput = new byte[] { // Expected Base64 encoding of "!@#$%^&*()"
        // Expected Base64 encoding of "!@#$%^&*()"
        'I', // Expected Base64 encoding of "!@#$%^&*()"
        'E', // Expected Base64 encoding of "!@#$%^&*()"
        'A', // Expected Base64 encoding of "!@#$%^&*()"
        'j', // Expected Base64 encoding of "!@#$%^&*()"
        'J', // Expected Base64 encoding of "!@#$%^&*()"
        'y', // Expected Base64 encoding of "!@#$%^&*()"
        'K', // Expected Base64 encoding of "!@#$%^&*()"
        'C', // Expected Base64 encoding of "!@#$%^&*()"
        'A', // Expected Base64 encoding of "!@#$%^&*()"
        'o', // Expected Base64 encoding of "!@#$%^&*()"
        'K', // Expected Base64 encoding of "!@#$%^&*()"
        'C', // Expected Base64 encoding of "!@#$%^&*()"
        'g', // Expected Base64 encoding of "!@#$%^&*()"
        'o', // Expected Base64 encoding of "!@#$%^&*()"
        'K', // Expected Base64 encoding of "!@#$%^&*()"
        'C', // Expected Base64 encoding of "!@#$%^&*()"
        'g', // Expected Base64 encoding of "!@#$%^&*()"
        'o', // Expected Base64 encoding of "!@#$%^&*()"
        'K', // Expected Base64 encoding of "!@#$%^&*()"
        'C', 'g', '=' };
        // Act
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, input);
        // Assert
        assertArrayEquals(expectedOutput, result);
    }
}

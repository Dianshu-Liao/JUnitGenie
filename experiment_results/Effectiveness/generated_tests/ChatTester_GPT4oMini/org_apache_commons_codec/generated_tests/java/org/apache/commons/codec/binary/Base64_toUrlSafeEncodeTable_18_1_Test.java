package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

public class Base64_toUrlSafeEncodeTable_18_1_Test {

    @Test
    public void testToUrlSafeEncodeTable_WithUrlSafeTrue() throws Exception {
        // Arrange
        boolean urlSafe = true;
        byte[] expected = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_' };
        // Act
        byte[] result = invokeToUrlSafeEncodeTable(urlSafe);
        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToUrlSafeEncodeTable_WithUrlSafeFalse() throws Exception {
        // Arrange
        boolean urlSafe = false;
        byte[] expected = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
        // Act
        byte[] result = invokeToUrlSafeEncodeTable(urlSafe);
        // Assert
        assertArrayEquals(expected, result);
    }

    private byte[] invokeToUrlSafeEncodeTable(boolean urlSafe) throws Exception {
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, urlSafe);
    }
}

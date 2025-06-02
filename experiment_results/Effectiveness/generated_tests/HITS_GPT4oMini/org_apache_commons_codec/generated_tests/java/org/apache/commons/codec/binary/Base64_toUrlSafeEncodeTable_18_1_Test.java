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
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        // Make the private method accessible
        method.setAccessible(true);
        // Call the method statically
        byte[] expected = (byte[]) method.invoke(null, true);
        // Act
        // Call the method statically
        byte[] result = (byte[]) method.invoke(null, true);
        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToUrlSafeEncodeTable_WithUrlSafeFalse() throws Exception {
        // Arrange
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        // Make the private method accessible
        method.setAccessible(true);
        // Call the method statically
        byte[] expected = (byte[]) method.invoke(null, false);
        // Act
        // Call the method statically
        byte[] result = (byte[]) method.invoke(null, false);
        // Assert
        assertArrayEquals(expected, result);
    }
}

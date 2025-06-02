package org.apache.commons.lang3.math;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

class // Reflection test for private method (if any)
// Assuming there are private methods to test, otherwise this can be omitted
// @Test
// void testPrivateMethod() throws Exception {
// Method privateMethod = NumberUtils.class.getDeclaredMethod("privateMethodName", parameterTypes);
// privateMethod.setAccessible(true);
// Object result = privateMethod.invoke(null, parameters);
// assertEquals(expectedValue, result);
// }
NumberUtils_min_30_0_Test {

    // Test for min method with positive numbers
    @Test
    void testMinWithPositiveNumbers() {
        byte result = NumberUtils.min((byte) 5, (byte) 3, (byte) 8);
        assertEquals(3, result);
    }

    // Test for min method with negative numbers
    @Test
    void testMinWithNegativeNumbers() {
        byte result = NumberUtils.min((byte) -2, (byte) -5, (byte) -1);
        assertEquals(-5, result);
    }

    // Test for min method with mixed numbers
    @Test
    void testMinWithMixedNumbers() {
        byte result = NumberUtils.min((byte) -1, (byte) 0, (byte) 1);
        assertEquals(-1, result);
    }

    // Test for min method with single element
    @Test
    void testMinWithSingleElement() {
        byte result = NumberUtils.min((byte) 42);
        assertEquals(42, result);
    }

    // Test for min method with all elements equal
    @Test
    void testMinWithAllEqualElements() {
        byte result = NumberUtils.min((byte) 7, (byte) 7, (byte) 7);
        assertEquals(7, result);
    }

    // Test for min method with an empty array
    @Test
    void testMinWithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min();
        });
        assertEquals("Array must not be empty", exception.getMessage());
    }

    // Test for min method with null array
    @Test
    void testMinWithNullArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min((byte[]) null);
        });
        assertEquals("Array must not be null", exception.getMessage());
    }

    // Test for min method with a large array
    @Test
    void testMinWithLargeArray() {
        byte[] largeArray = { 10, 20, -5, 30, 15 };
        byte result = NumberUtils.min(largeArray);
        assertEquals(-5, result);
    }

    // Test for min method with all negative elements
    @Test
    void testMinWithAllNegativeElements() {
        byte[] negativeArray = { -1, -2, -3, -4 };
        byte result = NumberUtils.min(negativeArray);
        assertEquals(-4, result);
    }

    // Test for min method with boundary values
    @Test
    void testMinWithBoundaryValues() {
        byte[] boundaryArray = { Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 0 };
        byte result = NumberUtils.min(boundaryArray);
        assertEquals(Byte.MIN_VALUE, result);
    }
}

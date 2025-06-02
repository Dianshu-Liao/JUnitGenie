package org.apache.commons.lang3.math;

import java.lang.reflect.Method;
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

public class NumberUtils_min_40_0_Test {

    @Test
    public void testMin_WithValidInput_ReturnsMinimumValue() {
        short result = NumberUtils.min((short) 5, (short) 3, (short) 8);
        assertEquals(3, result);
    }

    @Test
    public void testMin_WithAllEqualValues_ReturnsSameValue() {
        short result = NumberUtils.min((short) 2, (short) 2, (short) 2);
        assertEquals(2, result);
    }

    @Test
    public void testMin_WithNegativeValues_ReturnsMinimumValue() {
        short result = NumberUtils.min((short) -1, (short) -3, (short) -2);
        assertEquals(-3, result);
    }

    @Test
    public void testMin_WithSingleValue_ReturnsThatValue() {
        short result = NumberUtils.min((short) 10);
        assertEquals(10, result);
    }

    @Test
    public void testMin_WithEmptyArray_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min();
        });
        assertEquals("Array must not be empty", exception.getMessage());
    }

    @Test
    public void testMin_WithNullArray_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min((short[]) null);
        });
        assertEquals("Array must not be null", exception.getMessage());
    }

    // Reflection test to invoke private method if needed
    @Test
    public void testPrivateMethod() throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("validateArray", short[].class);
        method.setAccessible(true);
        // Example of invoking the method with a null array to test its behavior
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(null, (short[]) null);
        });
        assertEquals("Array must not be null", exception.getMessage());
    }
}

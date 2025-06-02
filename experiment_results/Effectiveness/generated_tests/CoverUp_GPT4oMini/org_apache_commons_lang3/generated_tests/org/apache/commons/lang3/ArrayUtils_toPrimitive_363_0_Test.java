package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.stream.IntStreams;
import org.apache.commons.lang3.stream.Streams;

public class ArrayUtils_toPrimitive_363_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test case for null array
        Float[] input = null;
        float valueForNull = 0.0f;
        float[] result = invokeToPrimitive(input, valueForNull);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test case for empty array
        Float[] input = {};
        float valueForNull = 0.0f;
        float[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Test case for array with null values
        Float[] input = { 1.0f, null, 3.0f };
        float valueForNull = 0.5f;
        float[] expected = { 1.0f, 0.5f, 3.0f };
        float[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithValues() {
        // Test case for array with non-null values
        Float[] input = { 1.0f, 2.0f, 3.0f };
        float valueForNull = 0.5f;
        float[] expected = { 1.0f, 2.0f, 3.0f };
        float[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithAllNulls() {
        // Test case for array with all null values
        Float[] input = { null, null, null };
        float valueForNull = 0.5f;
        float[] expected = { 0.5f, 0.5f, 0.5f };
        float[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    private float[] invokeToPrimitive(Float[] array, float valueForNull) {
        try {
            // Using reflection to invoke the private method
            Method method = ArrayUtils.class.getDeclaredMethod("toPrimitive", Float[].class, float.class);
            method.setAccessible(true);
            return (float[]) method.invoke(null, array, valueForNull);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

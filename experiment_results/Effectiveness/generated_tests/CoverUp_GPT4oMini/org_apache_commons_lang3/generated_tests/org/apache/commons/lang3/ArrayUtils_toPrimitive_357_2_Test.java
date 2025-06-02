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

public class ArrayUtils_toPrimitive_357_2_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Given
        Byte[] input = null;
        byte valueForNull = 0;
        // When
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Given
        Byte[] input = {};
        byte valueForNull = 0;
        // When
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Given
        Byte[] input = { 1, null, 3 };
        byte valueForNull = 0;
        // When
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        byte[] expected = { 1, valueForNull, 3 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithValues() {
        // Given
        Byte[] input = { 1, 2, 3 };
        byte valueForNull = 0;
        // When
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        byte[] expected = { 1, 2, 3 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithAllNulls() {
        // Given
        Byte[] input = { null, null, null };
        byte valueForNull = 5;
        // When
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        byte[] expected = { valueForNull, valueForNull, valueForNull };
        assertArrayEquals(expected, result);
    }
}

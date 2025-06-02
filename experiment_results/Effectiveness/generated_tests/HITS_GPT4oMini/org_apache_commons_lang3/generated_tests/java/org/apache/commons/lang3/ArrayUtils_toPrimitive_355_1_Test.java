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

public class ArrayUtils_toPrimitive_355_1_Test {

    @Test
    public void testToPrimitiveWithNullArray() {
        // Given
        Boolean[] input = null;
        boolean valueForNull = false;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertNull(result);
    }

    @Test
    public void testToPrimitiveWithEmptyArray() {
        // Given
        Boolean[] input = {};
        boolean valueForNull = false;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    public void testToPrimitiveWithAllNulls() {
        // Given
        Boolean[] input = { null, null, null };
        boolean valueForNull = true;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        boolean[] expected = { true, true, true };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitiveWithMixedValues() {
        // Given
        Boolean[] input = { null, true, false, null };
        boolean valueForNull = false;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitiveWithAllTrue() {
        // Given
        Boolean[] input = { true, true, true };
        boolean valueForNull = false;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        boolean[] expected = { true, true, true };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitiveWithAllFalse() {
        // Given
        Boolean[] input = { false, false, false };
        boolean valueForNull = true;
        // When
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        boolean[] expected = { false, false, false };
        assertArrayEquals(expected, result);
    }
}

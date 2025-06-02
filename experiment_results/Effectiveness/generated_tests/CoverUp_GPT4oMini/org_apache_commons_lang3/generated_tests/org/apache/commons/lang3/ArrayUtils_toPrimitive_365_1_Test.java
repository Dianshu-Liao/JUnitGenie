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

public class ArrayUtils_toPrimitive_365_1_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Integer[] input = null;
        int valueForNull = 0;
        int[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Integer[] input = {};
        int valueForNull = 5;
        int[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(ArrayUtils.EMPTY_INT_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        Integer[] input = { 1, null, 3 };
        int valueForNull = -1;
        int[] expected = { 1, -1, 3 };
        int[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithValues() {
        Integer[] input = { 1, 2, 3 };
        int valueForNull = 0;
        int[] expected = { 1, 2, 3 };
        int[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedArray() {
        Integer[] input = { null, 2, null, 4 };
        int valueForNull = 10;
        int[] expected = { 10, 2, 10, 4 };
        int[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }
}

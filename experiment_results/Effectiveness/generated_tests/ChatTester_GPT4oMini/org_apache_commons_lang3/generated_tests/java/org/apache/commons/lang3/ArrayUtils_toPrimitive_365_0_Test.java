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

class ArrayUtils_toPrimitive_365_0_Test {

    @Test
    void testToPrimitive_NullArray() {
        int[] result = ArrayUtils.toPrimitive((Integer[]) null, 0);
        assertNull(result);
    }

    @Test
    void testToPrimitive_EmptyArray() {
        int[] result = ArrayUtils.toPrimitive(new Integer[] {}, 0);
        assertArrayEquals(ArrayUtils.EMPTY_INT_ARRAY, result);
    }

    @Test
    void testToPrimitive_ArrayWithNulls() {
        Integer[] input = { 1, null, 3 };
        int[] result = ArrayUtils.toPrimitive(input, 0);
        assertArrayEquals(new int[] { 1, 0, 3 }, result);
    }

    @Test
    void testToPrimitive_ArrayWithValues() {
        Integer[] input = { 1, 2, 3 };
        int[] result = ArrayUtils.toPrimitive(input, 0);
        assertArrayEquals(new int[] { 1, 2, 3 }, result);
    }

    @Test
    void testToPrimitive_ArrayWithAllNulls() {
        Integer[] input = { null, null, null };
        int[] result = ArrayUtils.toPrimitive(input, 5);
        assertArrayEquals(new int[] { 5, 5, 5 }, result);
    }

    @Test
    void testToPrimitive_NegativeValueForNull() {
        Integer[] input = { 1, null, 3 };
        int[] result = ArrayUtils.toPrimitive(input, -1);
        assertArrayEquals(new int[] { 1, -1, 3 }, result);
    }
}

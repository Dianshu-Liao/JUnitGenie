package org.apache.commons.lang3;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtils_toPrimitive_366_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Long[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        long[] result = ArrayUtils.toPrimitive(new Long[0]);
        assertArrayEquals(ArrayUtils.EMPTY_LONG_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ValidArray() {
        Long[] input = { 1L, 2L, 3L };
        long[] expected = { 1L, 2L, 3L };
        long[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullValues() {
        Long[] input = { 1L, null, 3L };
        long[] expected = { 1L, 0L, 3L };
        long[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_LargeArray() {
        Long[] input = new Long[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (long) i;
        }
        long[] expected = new long[1000];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = (long) i;
        }
        long[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }
}

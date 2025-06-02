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

public class ArrayUtils_toPrimitive_366_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        long[] result = ArrayUtils.toPrimitive((Long[]) null);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test case for empty array
        long[] result = ArrayUtils.toPrimitive(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY);
        assertArrayEquals(ArrayUtils.EMPTY_LONG_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ValidArray() {
        // Test case for a valid Long array
        Long[] input = { 1L, 2L, 3L };
        long[] expected = { 1L, 2L, 3L };
        long[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Test case for an array containing null Long values
        Long[] input = { 1L, null, 3L };
        // null should be converted to 0
        long[] expected = { 1L, 0L, 3L };
        long[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }
}

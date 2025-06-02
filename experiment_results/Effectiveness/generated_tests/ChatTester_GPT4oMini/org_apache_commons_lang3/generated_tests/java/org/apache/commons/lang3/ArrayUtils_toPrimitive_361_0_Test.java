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

class ArrayUtils_toPrimitive_361_0_Test {

    @Test
    void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive(null, 0.0));
    }

    @Test
    void testToPrimitive_EmptyArray() {
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0], 0.0));
    }

    @Test
    void testToPrimitive_ArrayWithValues() {
        Double[] input = { 1.0, 2.0, 3.0 };
        double[] expected = { 1.0, 2.0, 3.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input, 0.0));
    }

    @Test
    void testToPrimitive_ArrayWithNulls() {
        Double[] input = { 1.0, null, 3.0 };
        // Assuming valueForNull is 0.0
        double[] expected = { 1.0, 0.0, 3.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input, 0.0));
    }

    @Test
    void testToPrimitive_ArrayWithAllNulls() {
        Double[] input = { null, null, null };
        // Assuming valueForNull is 0.0
        double[] expected = { 0.0, 0.0, 0.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input, 0.0));
    }

    @Test
    void testToPrimitive_NegativeValueForNull() {
        Double[] input = { 1.0, null, 3.0 };
        // Assuming valueForNull is -1.0
        double[] expected = { 1.0, -1.0, 3.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input, -1.0));
    }

    @Test
    void testToPrimitive_PositiveValueForNull() {
        Double[] input = { null, 2.0, null };
        // Assuming valueForNull is 5.0
        double[] expected = { 5.0, 2.0, 5.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input, 5.0));
    }
}

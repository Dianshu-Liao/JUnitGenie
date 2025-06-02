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

public class ArrayUtils_toPrimitive_361_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        double[] result = ArrayUtils.toPrimitive(null, 0.0);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        double[] result = ArrayUtils.toPrimitive(new Double[0], 0.0);
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullValues() {
        Double[] input = { 1.0, null, 3.0 };
        double[] expected = { 1.0, 0.0, 3.0 };
        double[] result = ArrayUtils.toPrimitive(input, 0.0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNonNullValues() {
        Double[] input = { 1.1, 2.2, 3.3 };
        double[] expected = { 1.1, 2.2, 3.3 };
        double[] result = ArrayUtils.toPrimitive(input, 0.0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedValues() {
        Double[] input = { null, 2.5, null, 4.0 };
        double[] expected = { 0.0, 2.5, 0.0, 4.0 };
        double[] result = ArrayUtils.toPrimitive(input, 0.0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_NonDefaultValueForNull() {
        Double[] input = { null, 5.0, null };
        double[] expected = { -1.0, 5.0, -1.0 };
        double[] result = ArrayUtils.toPrimitive(input, -1.0);
        assertArrayEquals(expected, result);
    }
}

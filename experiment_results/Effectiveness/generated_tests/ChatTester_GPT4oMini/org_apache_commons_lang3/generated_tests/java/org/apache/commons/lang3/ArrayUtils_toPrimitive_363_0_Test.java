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

class ArrayUtils_toPrimitive_363_0_Test {

    @Test
    void testToPrimitive_NullArray() {
        Float[] input = null;
        float valueForNull = 0.0f;
        float[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertNull(result);
    }

    @Test
    void testToPrimitive_EmptyArray() {
        Float[] input = {};
        float valueForNull = 0.0f;
        float[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result);
    }

    @Test
    void testToPrimitive_ArrayWithNulls() {
        Float[] input = { 1.0f, null, 3.0f };
        float valueForNull = 2.0f;
        float[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, result);
    }

    @Test
    void testToPrimitive_ArrayWithNonNulls() {
        Float[] input = { 1.0f, 2.0f, 3.0f };
        float valueForNull = 0.0f;
        float[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, result);
    }

    @Test
    void testToPrimitive_ArrayWithMixedValues() {
        Float[] input = { null, null, 3.0f, 4.5f };
        float valueForNull = 2.0f;
        float[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(new float[] { 2.0f, 2.0f, 3.0f, 4.5f }, result);
    }
}

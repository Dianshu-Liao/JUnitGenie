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

public class ArrayUtils_toPrimitive_355_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test case where the input array is null
        boolean[] result = ArrayUtils.toPrimitive(null, true);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test case where the input array is empty
        boolean[] result = ArrayUtils.toPrimitive(new Boolean[] {}, true);
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Test case where the input array contains null values
        Boolean[] input = { null, null, null };
        // using true for null values
        boolean[] expected = { true, true, true };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithValues() {
        // Test case where the input array contains actual Boolean values
        Boolean[] input = { true, false, null, true };
        // using false for null values
        boolean[] expected = { true, false, false, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedArray() {
        // Test case where the input array contains a mix of Boolean values and nulls
        Boolean[] input = { null, true, false, null, true };
        // using false for null values
        boolean[] expected = { false, true, false, false, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, result);
    }
}

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
        // Test with null array
        boolean[] result = ArrayUtils.toPrimitive(null, true);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        boolean[] result = ArrayUtils.toPrimitive(new Boolean[] {}, true);
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullValues() {
        // Test with array containing null values
        Boolean[] input = new Boolean[] { null, null, null };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        boolean[] expected = new boolean[] { false, false, false };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithMixedValues() {
        // Test with array containing mixed values
        Boolean[] input = new Boolean[] { true, null, false, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        boolean[] expected = new boolean[] { true, false, false, true };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithAllTrueValues() {
        // Test with array containing all true values
        Boolean[] input = new Boolean[] { true, true, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        boolean[] expected = new boolean[] { true, true, true };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithAllFalseValues() {
        // Test with array containing all false values
        Boolean[] input = new Boolean[] { false, false, false };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        boolean[] expected = new boolean[] { false, false, false };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullAndTrueValueForNull() {
        // Test with array containing null values and true value for null
        Boolean[] input = new Boolean[] { null, null, null };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        boolean[] expected = new boolean[] { true, true, true };
        assertArrayEquals(expected, result);
    }
}

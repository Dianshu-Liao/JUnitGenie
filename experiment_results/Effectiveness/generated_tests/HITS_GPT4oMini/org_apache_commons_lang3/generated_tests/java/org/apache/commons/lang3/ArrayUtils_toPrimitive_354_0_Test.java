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

public class ArrayUtils_toPrimitive_354_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test with null array
        Boolean[] input = null;
        boolean[] expected = null;
        boolean[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        Boolean[] input = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Test with array containing null values
        Boolean[] input = { true, null, false };
        boolean[] expected = { true, false, false };
        boolean[] actual = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_ArrayWithAllTrue() {
        // Test with array containing all true values
        Boolean[] input = { true, true, true };
        boolean[] expected = { true, true, true };
        boolean[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_ArrayWithAllFalse() {
        // Test with array containing all false values
        Boolean[] input = { false, false, false };
        boolean[] expected = { false, false, false };
        boolean[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_MixedValues() {
        // Test with mixed true and false values
        Boolean[] input = { true, false, true, null };
        boolean[] expected = { true, false, true, false };
        boolean[] actual = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_MixedValuesWithNullAsTrue() {
        // Test with mixed true and false values, treating null as true
        Boolean[] input = { true, false, true, null };
        boolean[] expected = { true, false, true, true };
        boolean[] actual = ArrayUtils.toPrimitive(input, true);
        assertArrayEquals(expected, actual);
    }
}

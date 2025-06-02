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

public class ArrayUtils_toPrimitive_359_1_Test {

    @Test
    public void testToPrimitiveWithNullArray() {
        // Test case for null input array
        Character[] input = null;
        char valueForNull = 'a';
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertNull(result, "Expected result to be null for null input array");
    }

    @Test
    public void testToPrimitiveWithEmptyArray() {
        // Test case for empty input array
        Character[] input = {};
        char valueForNull = 'a';
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result, "Expected result to be an empty char array for empty input array");
    }

    @Test
    public void testToPrimitiveWithAllNonNullCharacters() {
        // Test case for an array with all non-null Characters
        Character[] input = { 'A', 'B', 'C' };
        char valueForNull = 'a';
        char[] expected = { 'A', 'B', 'C' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result, "Expected result to match the input characters");
    }

    @Test
    public void testToPrimitiveWithNullCharacters() {
        // Test case for an array with some null Characters
        Character[] input = { 'A', null, 'C' };
        char valueForNull = 'a';
        char[] expected = { 'A', 'a', 'C' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result, "Expected result to replace null characters with valueForNull");
    }

    @Test
    public void testToPrimitiveWithAllNullCharacters() {
        // Test case for an array with all null Characters
        Character[] input = { null, null, null };
        char valueForNull = 'a';
        char[] expected = { 'a', 'a', 'a' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result, "Expected result to replace all null characters with valueForNull");
    }
}

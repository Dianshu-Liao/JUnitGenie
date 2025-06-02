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

public class ArrayUtils_toPrimitive_359_2_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Character[] input = null;
        char valueForNull = 'a';
        char[] expected = null;
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Character[] input = {};
        char valueForNull = 'a';
        char[] expected = ArrayUtils.EMPTY_CHAR_ARRAY;
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        Character[] input = { null, 'b', null, 'd' };
        char valueForNull = 'a';
        char[] expected = { 'a', 'b', 'a', 'd' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithCharacters() {
        Character[] input = { 'x', 'y', 'z' };
        char valueForNull = 'a';
        char[] expected = { 'x', 'y', 'z' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_AllNulls() {
        Character[] input = { null, null, null };
        char valueForNull = 'a';
        char[] expected = { 'a', 'a', 'a' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_NonNullCharacters() {
        Character[] input = { 'A', 'B', 'C', 'D' };
        char valueForNull = 'X';
        char[] expected = { 'A', 'B', 'C', 'D' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_WithDifferentValueForNull() {
        Character[] input = { '1', null, '3' };
        char valueForNull = '0';
        char[] expected = { '1', '0', '3' };
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }
}

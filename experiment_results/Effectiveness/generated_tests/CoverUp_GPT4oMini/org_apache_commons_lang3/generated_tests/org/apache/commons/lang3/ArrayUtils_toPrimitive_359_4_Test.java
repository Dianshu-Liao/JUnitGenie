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

public class ArrayUtils_toPrimitive_359_4_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Given
        Character[] input = null;
        char valueForNull = 'a';
        // When
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Given
        Character[] input = new Character[0];
        char valueForNull = 'a';
        // When
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Given
        Character[] input = new Character[] { 'b', null, 'd' };
        char valueForNull = 'a';
        // When
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        char[] expected = new char[] { 'b', 'a', 'd' };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithValues() {
        // Given
        Character[] input = new Character[] { 'b', 'c', 'd' };
        char valueForNull = 'a';
        // When
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        char[] expected = new char[] { 'b', 'c', 'd' };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedArray() {
        // Given
        Character[] input = new Character[] { null, 'c', null, 'd' };
        char valueForNull = 'a';
        // When
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then
        char[] expected = new char[] { 'a', 'c', 'a', 'd' };
        assertArrayEquals(expected, result);
    }
}

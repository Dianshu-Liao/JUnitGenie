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

public class ArrayUtils_toPrimitive_358_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Given
        Character[] input = null;
        // When
        char[] result = ArrayUtils.toPrimitive(input);
        // Then
        assertNull(result, "Expected null for null input array");
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Given
        Character[] input = {};
        // When
        char[] result = ArrayUtils.toPrimitive(input);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result, "Expected empty char array for empty input array");
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        // Given
        Character[] input = { 'a' };
        // When
        char[] result = ArrayUtils.toPrimitive(input);
        // Then
        assertArrayEquals(new char[] { 'a' }, result, "Expected char array with single element 'a'");
    }

    @Test
    public void testToPrimitive_MultipleElementArray() {
        // Given
        Character[] input = { 'a', 'b', 'c' };
        // When
        char[] result = ArrayUtils.toPrimitive(input);
        // Then
        assertArrayEquals(new char[] { 'a', 'b', 'c' }, result, "Expected char array with elements 'a', 'b', 'c'");
    }

    @Test
    public void testToPrimitive_ArrayWithNullElements() {
        // Given
        Character[] input = { 'a', null, 'c' };
        // When
        char[] result = ArrayUtils.toPrimitive(input);
        // Then
        assertArrayEquals(new char[] { 'a', '\u0000', 'c' }, result, "Expected char array with 'a', null as '\u0000', 'c'");
    }
}

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

public class ArrayUtils_toPrimitive_359_0_Test {

    @Test
    public void testToPrimitive_EmptyArray() {
        // Given an empty Character array
        Character[] input = new Character[0];
        // This value will not be used since the array is empty
        char valueForNull = 'a';
        // When calling toPrimitive
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then the result should be an empty char array
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test
    public void testToPrimitive_NullArray() {
        // Given a null Character array
        Character[] input = null;
        // This value will not be used since the array is null
        char valueForNull = 'a';
        // When calling toPrimitive
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then the result should be null
        assertArrayEquals(null, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Given a Character array with null values
        Character[] input = new Character[] { null, 'b', null, 'd' };
        char valueForNull = 'a';
        // When calling toPrimitive
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then the result should replace nulls with valueForNull
        char[] expected = new char[] { 'a', 'b', 'a', 'd' };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNonNulls() {
        // Given a Character array with non-null values
        Character[] input = new Character[] { 'e', 'f', 'g' };
        // This value will not be used since there are no nulls
        char valueForNull = 'a';
        // When calling toPrimitive
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Then the result should be the same as the input values
        char[] expected = new char[] { 'e', 'f', 'g' };
        assertArrayEquals(expected, result);
    }
}

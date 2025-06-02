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
    public void testToPrimitive_NullArray() {
        // Arrange
        Character[] input = null;
        char valueForNull = 'a';
        // Act
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Assert
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Arrange
        Character[] input = {};
        char valueForNull = 'a';
        // Act
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Arrange
        Character[] input = { 'b', null, 'd' };
        char valueForNull = 'a';
        // Act
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Assert
        assertArrayEquals(new char[] { 'b', 'a', 'd' }, result);
    }

    @Test
    public void testToPrimitive_ArrayWithoutNulls() {
        // Arrange
        Character[] input = { 'b', 'c', 'd' };
        char valueForNull = 'a';
        // Act
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Assert
        assertArrayEquals(new char[] { 'b', 'c', 'd' }, result);
    }

    @Test
    public void testToPrimitive_MixedArray() {
        // Arrange
        Character[] input = { null, 'c', null, 'e' };
        char valueForNull = 'a';
        // Act
        char[] result = ArrayUtils.toPrimitive(input, valueForNull);
        // Assert
        assertArrayEquals(new char[] { 'a', 'c', 'a', 'e' }, result);
    }
}

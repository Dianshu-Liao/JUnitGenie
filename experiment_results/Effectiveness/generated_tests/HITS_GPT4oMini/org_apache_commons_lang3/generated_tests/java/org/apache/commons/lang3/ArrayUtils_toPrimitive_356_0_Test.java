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

public class ArrayUtils_toPrimitive_356_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test case for null input
        Byte[] input = null;
        byte[] expected = null;
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test case for empty input array
        Byte[] input = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        byte[] expected = ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        // Test case for single element in the input array
        Byte[] input = new Byte[] { 1 };
        byte[] expected = new byte[] { 1 };
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_MultipleElementsArray() {
        // Test case for multiple elements in the input array
        Byte[] input = new Byte[] { 1, 2, 3, 4, 5 };
        byte[] expected = new byte[] { 1, 2, 3, 4, 5 };
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_NegativeValuesArray() {
        // Test case for negative values in the input array
        Byte[] input = new Byte[] { -1, -2, -3 };
        byte[] expected = new byte[] { -1, -2, -3 };
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_LargeValuesArray() {
        // Test case for large values in the input array
        Byte[] input = new Byte[] { Byte.MAX_VALUE, Byte.MIN_VALUE };
        byte[] expected = new byte[] { Byte.MAX_VALUE, Byte.MIN_VALUE };
        byte[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }
}

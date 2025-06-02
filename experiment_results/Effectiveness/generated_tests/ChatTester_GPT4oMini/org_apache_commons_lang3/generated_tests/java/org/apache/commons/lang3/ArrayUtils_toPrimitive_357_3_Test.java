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

public class ArrayUtils_toPrimitive_357_3_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Fixed the buggy line: changed byte[] to Byte[] for null input
        Byte[] input = null;
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        byte[] result = ArrayUtils.toPrimitive(new Byte[] {}, (byte) 0);
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToPrimitive_WithNulls() {
        Byte[] input = { 1, null, 3 };
        // Assuming valueForNull is 0
        byte[] expected = { 1, 0, 3 };
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_AllNulls() {
        Byte[] input = { null, null, null };
        // Assuming valueForNull is 0
        byte[] expected = { 0, 0, 0 };
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_NoNulls() {
        Byte[] input = { 1, 2, 3 };
        byte[] expected = { 1, 2, 3 };
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_WithNegativeValues() {
        Byte[] input = { -1, -2, null };
        // Assuming valueForNull is 0
        byte[] expected = { -1, -2, 0 };
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_WithMixedValues() {
        Byte[] input = { null, 2, null, 4 };
        // Assuming valueForNull is 0
        byte[] expected = { 0, 2, 0, 4 };
        byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
        assertArrayEquals(expected, result);
    }
}

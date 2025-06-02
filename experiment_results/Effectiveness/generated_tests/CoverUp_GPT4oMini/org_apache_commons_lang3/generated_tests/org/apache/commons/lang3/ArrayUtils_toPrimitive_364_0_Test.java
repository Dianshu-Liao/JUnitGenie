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

public class ArrayUtils_toPrimitive_364_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Integer[] input = null;
        int[] expected = null;
        int[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Integer[] input = {};
        int[] expected = ArrayUtils.EMPTY_INT_ARRAY;
        int[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        Integer[] input = { 5 };
        int[] expected = { 5 };
        int[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_MultipleElementArray() {
        Integer[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        int[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        Integer[] input = { 1, null, 3 };
        // Expecting 0 for null
        int[] expected = { 1, 0, 3 };
        int[] actual = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, actual);
    }
}

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

public class ArrayUtils_swap_341_0_Test {

    @Test
    public void testSwap_NullArray() {
        Object[] array = null;
        ArrayUtils.swap(array, 0, 1, 1);
        assertNull(array);
    }

    @Test
    public void testSwap_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.swap(array, 0, 1, 1);
        assertArrayEquals(array, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Test
    public void testSwap_OffsetOutOfBounds() {
        Object[] array = { 1, 2, 3, 4 };
        // offset1 out of bounds
        ArrayUtils.swap(array, 4, 1, 1);
        assertArrayEquals(new Object[] { 1, 2, 3, 4 }, array);
        // offset2 out of bounds
        ArrayUtils.swap(array, 1, 4, 1);
        assertArrayEquals(new Object[] { 1, 2, 3, 4 }, array);
    }

    @Test
    public void testSwap_SuccessfulSwap() {
        Object[] array = { 1, 2, 3, 4 };
        // swap first two elements
        ArrayUtils.swap(array, 0, 1, 2);
        assertArrayEquals(new Object[] { 2, 1, 3, 4 }, array);
    }

    @Test
    public void testSwap_SwapWithLengthLessThanArraySize() {
        Object[] array = { 1, 2, 3, 4, 5 };
        // swap elements 2 and 4
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new Object[] { 1, 4, 3, 2, 5 }, array);
    }

    @Test
    public void testSwap_SwapWithLengthEqualToArraySize() {
        Object[] array = { 1, 2, 3, 4 };
        // swap all elements with themselves
        ArrayUtils.swap(array, 0, 0, 4);
        assertArrayEquals(new Object[] { 1, 2, 3, 4 }, array);
    }

    @Test
    public void testSwap_SwapWithNegativeOffsets() {
        Object[] array = { 1, 2, 3, 4 };
        // negative offsets should be treated as 0
        ArrayUtils.swap(array, -1, -2, 2);
        assertArrayEquals(new Object[] { 2, 1, 3, 4 }, array);
    }

    @Test
    public void testSwap_SwapWithZeroLength() {
        Object[] array = { 1, 2, 3, 4 };
        // no swap should occur
        ArrayUtils.swap(array, 0, 1, 0);
        assertArrayEquals(new Object[] { 1, 2, 3, 4 }, array);
    }
}

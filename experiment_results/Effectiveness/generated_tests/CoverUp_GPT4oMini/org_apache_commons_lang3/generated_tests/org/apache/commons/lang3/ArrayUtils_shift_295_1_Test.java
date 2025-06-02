package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
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

class ArrayUtils_shift_295_1_Test {

    @Test
    void testShift_NullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 0, 1, 1);
        // No exception should be thrown, and method should return
    }

    @Test
    void testShift_EmptyArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 0, 0, 1);
        assertArrayEquals(array, new Object[] {});
    }

    @Test
    void testShift_SingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.shift(array, 0, 1, 1);
        assertArrayEquals(array, new Object[] { 1 });
    }

    @Test
    void testShift_OffsetGreaterThanLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 6);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    void testShift_PositiveOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 2);
        assertArrayEquals(array, new Object[] { 4, 5, 1, 2, 3 });
    }

    @Test
    void testShift_NegativeOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, -1);
        assertArrayEquals(array, new Object[] { 2, 3, 4, 5, 1 });
    }

    @Test
    void testShift_OffsetEqualToLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 5);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    void testShift_OffsetIsZero() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 0);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    void testShift_WithStartIndexAndEndIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, 1);
        assertArrayEquals(array, new Object[] { 1, 3, 4, 2, 5 });
    }

    @Test
    void testShift_WithNegativeStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, -1, 4, 1);
        // Should not change
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    void testShift_WithEndIndexLessThanStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 3, 2, 1);
        // Should not change
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    // Reflection to test private methods
    @Test
    void testMax0() throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("max0", int.class);
        method.setAccessible(true);
        assertEquals(0, method.invoke(null, -5));
        assertEquals(5, method.invoke(null, 5));
    }
}

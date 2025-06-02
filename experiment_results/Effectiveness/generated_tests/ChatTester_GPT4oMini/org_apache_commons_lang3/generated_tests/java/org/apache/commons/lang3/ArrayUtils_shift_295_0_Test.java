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

public class ArrayUtils_shift_295_0_Test {

    @Test
    public void testShift_NullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 0, 5, 2);
        // No exception should be thrown
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 0, 0, 1);
        assertArrayEquals(array, new Object[] {});
    }

    @Test
    public void testShift_SingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.shift(array, 0, 1, 1);
        assertArrayEquals(array, new Object[] { 1 });
    }

    @Test
    public void testShift_OffsetGreaterThanLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 7);
        assertArrayEquals(array, new Object[] { 4, 5, 1, 2, 3 });
    }

    @Test
    public void testShift_NegativeOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, -2);
        assertArrayEquals(array, new Object[] { 3, 4, 5, 1, 2 });
    }

    @Test
    public void testShift_OffsetEqualToLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 5);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testShift_ValidShift() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 2);
        assertArrayEquals(array, new Object[] { 3, 4, 5, 1, 2 });
    }

    @Test
    public void testShift_StartIndexOutOfBounds() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 5, 5, 2);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testShift_EndIndexNegative() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, -1, 2);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testShift_ZeroLengthShift() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0, 5, 0);
        assertArrayEquals(array, new Object[] { 1, 2, 3, 4, 5 });
    }
}

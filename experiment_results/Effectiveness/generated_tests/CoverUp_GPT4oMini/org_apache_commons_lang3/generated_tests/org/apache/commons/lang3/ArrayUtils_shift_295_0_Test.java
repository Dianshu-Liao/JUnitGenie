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
        ArrayUtils.shift(array, 0, 1, 1);
        // No exception should be thrown, and nothing should happen
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shift(array, 0, 0, 1);
        // No exception should be thrown, and nothing should happen
    }

    @Test
    public void testShift_SingleElementArray() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.shift(array, 0, 1, 1);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        // offset of 5 is effectively 1
        ArrayUtils.shift(array, 0, 4, 5);
        assertArrayEquals(new Object[] { "D", "A", "B", "C" }, array);
    }

    @Test
    public void testShift_OffsetNegative() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        // shift left
        ArrayUtils.shift(array, 0, 4, -1);
        assertArrayEquals(new Object[] { "B", "C", "D", "A" }, array);
    }

    @Test
    public void testShift_OffsetZero() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        // no shift
        ArrayUtils.shift(array, 0, 4, 0);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testShift_ValidShift() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        // shift "B", "C", "D" right by 2
        ArrayUtils.shift(array, 1, 4, 2);
        assertArrayEquals(new Object[] { "A", "D", "E", "B", "C" }, array);
    }

    @Test
    public void testShift_StartIndexOutOfBounds() {
        Object[] array = new Object[] { "A", "B", "C" };
        // startIndex out of bounds
        ArrayUtils.shift(array, 3, 3, 1);
        assertArrayEquals(new Object[] { "A", "B", "C" }, array);
    }

    @Test
    public void testShift_EndIndexNegative() {
        Object[] array = new Object[] { "A", "B", "C" };
        // endIndex negative
        ArrayUtils.shift(array, 0, -1, 1);
        assertArrayEquals(new Object[] { "A", "B", "C" }, array);
    }

    @Test
    public void testShift_EndIndexLessThanStartIndex() {
        Object[] array = new Object[] { "A", "B", "C" };
        // endIndex equals startIndex
        ArrayUtils.shift(array, 1, 1, 1);
        assertArrayEquals(new Object[] { "A", "B", "C" }, array);
    }

    @Test
    public void testShift_MultipleShifts() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E", "F" };
        // shift "B", "C", "D", "E" right by 3
        ArrayUtils.shift(array, 1, 5, 3);
        assertArrayEquals(new Object[] { "A", "D", "E", "F", "B", "C" }, array);
    }

    @Test
    public void testShift_ZeroLengthShift() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        // no shift
        ArrayUtils.shift(array, 1, 2, 0);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }
}

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

public class ArrayUtils_shift_294_0_Test {

    @Test
    public void testShift_NullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 1);
        // No exception should be thrown
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shift(array, 1);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    public void testShift_SingleElementArray() {
        Object[] array = new Object[] { "Element" };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { "Element" }, array);
    }

    @Test
    public void testShift_PositiveOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { "D", "A", "B", "C" }, array);
    }

    @Test
    public void testShift_NegativeOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, -1);
        assertArrayEquals(new Object[] { "B", "C", "D", "A" }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 5);
        assertArrayEquals(new Object[] { "D", "A", "B", "C" }, array);
    }

    @Test
    public void testShift_OffsetEqualToLength() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 4);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testShift_OffsetZero() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 0);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testShift_LargeNegativeOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, -100);
        assertArrayEquals(new Object[] { "B", "C", "D", "A" }, array);
    }

    @Test
    public void testShift_LargePositiveOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 100);
        assertArrayEquals(new Object[] { "D", "A", "B", "C" }, array);
    }
}

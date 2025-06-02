package org.apache.commons.lang3;

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

public class ArrayUtils_shift_294_0_Test {

    @Test
    public void testShift_NullArray() throws Exception {
        Object[] array = null;
        ArrayUtils.shift(array, 1);
        // No exception should be thrown
    }

    @Test
    public void testShift_EmptyArray() throws Exception {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shift(array, 1);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    public void testShift_SingleElementArray() throws Exception {
        Object[] array = new Object[] { "A" };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testShift_TwoElementArray_OffsetPositive() throws Exception {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testShift_TwoElementArray_OffsetNegative() throws Exception {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.shift(array, -1);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testShift_LargeOffset() throws Exception {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 5);
        assertArrayEquals(new Object[] { "D", "A", "B", "C" }, array);
    }

    @Test
    public void testShift_OffsetZero() throws Exception {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 0);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testShift_OffsetEqualToLength() throws Exception {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 4);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() throws Exception {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, 6);
        assertArrayEquals(new Object[] { "C", "D", "A", "B" }, array);
    }

    @Test
    public void testShift_NegativeOffsetGreaterThanLength() throws Exception {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.shift(array, -6);
        assertArrayEquals(new Object[] { "C", "D", "A", "B" }, array);
    }

    // Reflection to test private method if needed
    private void invokePrivateShift(Object[] array, int offset) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("shift", Object[].class, int.class);
        method.setAccessible(true);
        method.invoke(null, array, offset);
    }
}

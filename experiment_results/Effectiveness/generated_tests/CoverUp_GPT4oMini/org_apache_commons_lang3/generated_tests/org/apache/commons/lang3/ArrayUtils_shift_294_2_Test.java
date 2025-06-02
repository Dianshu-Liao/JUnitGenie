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

public class ArrayUtils_shift_294_2_Test {

    @Test
    public void testShift_NullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 2);
        // No exception should be thrown
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = new Object[0];
        ArrayUtils.shift(array, 2);
        assertArrayEquals(new Object[0], array);
    }

    @Test
    public void testShift_SingleElementArray() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.shift(array, 2);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testShift_TwoElementArray_PositiveOffset() {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testShift_TwoElementArray_NegativeOffset() {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.shift(array, -1);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testShift_MultipleElements_PositiveOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.shift(array, 2);
        assertArrayEquals(new Object[] { "D", "E", "A", "B", "C" }, array);
    }

    @Test
    public void testShift_MultipleElements_NegativeOffset() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.shift(array, -2);
        assertArrayEquals(new Object[] { "C", "D", "E", "A", "B" }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() {
        Object[] array = new Object[] { "A", "B", "C" };
        ArrayUtils.shift(array, 5);
        assertArrayEquals(new Object[] { "B", "C", "A" }, array);
    }

    @Test
    public void testShift_OffsetNegativeGreaterThanLength() {
        Object[] array = new Object[] { "A", "B", "C" };
        ArrayUtils.shift(array, -5);
        assertArrayEquals(new Object[] { "B", "C", "A" }, array);
    }

    // Reflection test for private method
    @Test
    public void testShift_PrivateMethod() throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("shift", Object[].class, int.class, int.class, int.class);
        method.setAccessible(true);
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        method.invoke(null, array, 0, array.length, 2);
        assertArrayEquals(new Object[] { "D", "E", "A", "B", "C" }, array);
    }
}

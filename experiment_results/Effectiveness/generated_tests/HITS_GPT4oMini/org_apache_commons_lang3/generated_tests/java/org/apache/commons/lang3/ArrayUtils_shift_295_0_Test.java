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
        // No assertion needed as the method should not throw an exception
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 0, 0, 2);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testShift_SingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.shift(array, 0, 1, 1);
        assertArrayEquals(new Object[] { 1 }, array);
    }

    @Test
    public void testShift_NoShift() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, 0);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testShift_PositiveOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, 2);
        assertArrayEquals(new Object[] { 1, 4, 5, 2, 3 }, array);
    }

    @Test
    public void testShift_NegativeOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, -1);
        assertArrayEquals(new Object[] { 1, 3, 4, 5, 2 }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, 10);
        assertArrayEquals(new Object[] { 1, 4, 5, 2, 3 }, array);
    }

    @Test
    public void testShift_OffsetNegativeGreaterThanLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 1, 4, -10);
        assertArrayEquals(new Object[] { 1, 3, 4, 5, 2 }, array);
    }

    @Test
    public void testShift_BoundaryConditions() {
        Object[] array = { 1, 2, 3, 4, 5 };
        // Full shift
        ArrayUtils.shift(array, 0, 5, 5);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }
}

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

public class ArrayUtils_reverse_275_1_Test {

    @Test
    public void testReverse_NullArray() {
        Object[] array = null;
        ArrayUtils.reverse(array, 0, 5);
        assertNull(array);
    }

    @Test
    public void testReverse_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(array, 0, 0);
        assertArrayEquals(array, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Test
    public void testReverse_SingleElementArray() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.reverse(array, 0, 1);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testReverse_TwoElementArray() {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.reverse(array, 0, 2);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testReverse_MultipleElementArray() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.reverse(array, 0, 5);
        assertArrayEquals(new Object[] { "E", "D", "C", "B", "A" }, array);
    }

    @Test
    public void testReverse_PartialReverse() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.reverse(array, 1, 4);
        assertArrayEquals(new Object[] { "A", "D", "C", "B", "E" }, array);
    }

    @Test
    public void testReverse_OutOfBoundIndices() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.reverse(array, -1, 10);
        assertArrayEquals(new Object[] { "E", "D", "C", "B", "A" }, array);
    }

    @Test
    public void testReverse_StartGreaterThanEnd() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.reverse(array, 3, 2);
        assertArrayEquals(new Object[] { "A", "B", "C", "D", "E" }, array);
    }
}

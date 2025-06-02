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

public class ArrayUtils_reverse_274_0_Test {

    @Test
    public void testReverse_NullArray() {
        Object[] input = null;
        ArrayUtils.reverse(input);
        // No exception should be thrown
    }

    @Test
    public void testReverse_EmptyArray() {
        Object[] input = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(input);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, input);
    }

    @Test
    public void testReverse_SingleElementArray() {
        Object[] input = new Object[] { "A" };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Object[] { "A" }, input);
    }

    @Test
    public void testReverse_TwoElementArray() {
        Object[] input = new Object[] { "A", "B" };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Object[] { "B", "A" }, input);
    }

    @Test
    public void testReverse_MultipleElementsArray() {
        Object[] input = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Object[] { "D", "C", "B", "A" }, input);
    }

    @Test
    public void testReverse_ArrayWithNulls() {
        Object[] input = new Object[] { "A", null, "C" };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Object[] { "C", null, "A" }, input);
    }

    @Test
    public void testReverse_EmptyStringArray() {
        String[] input = ArrayUtils.EMPTY_STRING_ARRAY;
        ArrayUtils.reverse(input);
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, input);
    }

    @Test
    public void testReverse_IntegerArray() {
        Integer[] input = new Integer[] { 1, 2, 3, 4 };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, input);
    }

    @Test
    public void testReverse_BooleanArray() {
        Boolean[] input = new Boolean[] { true, false, true };
        ArrayUtils.reverse(input);
        assertArrayEquals(new Boolean[] { true, false, true }, input);
    }
}

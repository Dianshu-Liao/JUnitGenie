package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

class ArrayUtils_reverse_274_0_Test {

    @Test
    void testReverse_NullArray() {
        Object[] array = null;
        ArrayUtils.reverse(array);
        // No exception should be thrown and nothing should happen
    }

    @Test
    void testReverse_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    void testReverse_SingleElementArray() {
        Object[] array = new Object[] { "single" };
        ArrayUtils.reverse(array);
        assertArrayEquals(new Object[] { "single" }, array);
    }

    @Test
    void testReverse_TwoElementsArray() {
        Object[] array = new Object[] { "first", "second" };
        ArrayUtils.reverse(array);
        assertArrayEquals(new Object[] { "second", "first" }, array);
    }

    @Test
    void testReverse_MultipleElementsArray() {
        Object[] array = new Object[] { "one", "two", "three", "four", "five" };
        ArrayUtils.reverse(array);
        assertArrayEquals(new Object[] { "five", "four", "three", "two", "one" }, array);
    }

    @Test
    void testReverse_ReverseEmptyStringArray() {
        String[] array = ArrayUtils.EMPTY_STRING_ARRAY;
        ArrayUtils.reverse(array);
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, array);
    }

    @Test
    void testReverse_ReverseMixedTypeArray() {
        Object[] array = new Object[] { 1, "two", 3.0, '4' };
        ArrayUtils.reverse(array);
        assertArrayEquals(new Object[] { '4', 3.0, "two", 1 }, array);
    }

    @Test
    void testReverse_ReverseWithNulls() {
        Object[] array = new Object[] { 1, null, 3, null };
        ArrayUtils.reverse(array);
        assertArrayEquals(new Object[] { null, 3, null, 1 }, array);
    }

    @Test
    void testReverse_ReversePartially() throws Exception {
        Object[] array = new Object[] { "a", "b", "c", "d", "e" };
        Method reverseMethod = ArrayUtils.class.getDeclaredMethod("reverse", Object[].class, int.class, int.class);
        reverseMethod.setAccessible(true);
        reverseMethod.invoke(null, array, 1, 4);
        assertArrayEquals(new Object[] { "a", "d", "c", "b", "e" }, array);
    }
}

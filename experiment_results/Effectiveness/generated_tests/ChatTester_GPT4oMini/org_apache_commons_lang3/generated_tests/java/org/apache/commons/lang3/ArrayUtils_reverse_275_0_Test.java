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

public class ArrayUtils_reverse_275_0_Test {

    @Test
    public void testReverse_NullArray() {
        Object[] array = null;
        ArrayUtils.reverse(array, 0, 5);
        // No exception should be thrown, and method should complete
    }

    @Test
    public void testReverse_EmptyArray() {
        Object[] array = {};
        ArrayUtils.reverse(array, 0, 0);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testReverse_SingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.reverse(array, 0, 1);
        assertArrayEquals(new Object[] { 1 }, array);
    }

    @Test
    public void testReverse_TwoElementArray() {
        Object[] array = { 1, 2 };
        ArrayUtils.reverse(array, 0, 2);
        assertArrayEquals(new Object[] { 2, 1 }, array);
    }

    @Test
    public void testReverse_MultipleElementArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 0, 5);
        assertArrayEquals(new Object[] { 5, 4, 3, 2, 1 }, array);
    }

    @Test
    public void testReverse_WithStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 1, 4);
        assertArrayEquals(new Object[] { 1, 4, 3, 2, 5 }, array);
    }

    @Test
    public void testReverse_WithNegativeStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, -1, 4);
        assertArrayEquals(new Object[] { 4, 3, 2, 1, 5 }, array);
    }

    @Test
    public void testReverse_WithEndIndexGreaterThanArrayLength() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 2, 10);
        assertArrayEquals(new Object[] { 1, 2, 5, 4, 3 }, array);
    }

    @Test
    public void testReverse_StartIndexEqualToEndIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 2, 2);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testReverse_EndIndexLessThanStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 3, 2);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }
}

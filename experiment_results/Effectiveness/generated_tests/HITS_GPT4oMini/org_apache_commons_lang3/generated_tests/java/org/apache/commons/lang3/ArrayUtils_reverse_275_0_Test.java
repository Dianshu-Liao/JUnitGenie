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
        assertNull(array);
    }

    @Test
    public void testReverse_EmptyArray() {
        Object[] array = {};
        ArrayUtils.reverse(array, 0, 0);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testReverse_SingleElement() {
        Object[] array = { 1 };
        ArrayUtils.reverse(array, 0, 1);
        assertArrayEquals(new Object[] { 1 }, array);
    }

    @Test
    public void testReverse_TwoElements() {
        Object[] array = { 1, 2 };
        ArrayUtils.reverse(array, 0, 2);
        assertArrayEquals(new Object[] { 2, 1 }, array);
    }

    @Test
    public void testReverse_MultipleElements() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 0, 5);
        assertArrayEquals(new Object[] { 5, 4, 3, 2, 1 }, array);
    }

    @Test
    public void testReverse_PartialReverse() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 1, 4);
        assertArrayEquals(new Object[] { 1, 4, 3, 2, 5 }, array);
    }

    @Test
    public void testReverse_StartIndexOutOfBounds() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 5, 5);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testReverse_EndIndexOutOfBounds() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 0, 10);
        assertArrayEquals(new Object[] { 5, 4, 3, 2, 1 }, array);
    }

    @Test
    public void testReverse_NegativeStartIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, -1, 4);
        assertArrayEquals(new Object[] { 4, 3, 2, 1, 5 }, array);
    }

    @Test
    public void testReverse_NegativeEndIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(array, 0, -1);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testReverse_IdenticalElements() {
        Object[] array = { 1, 1, 1, 1, 1 };
        ArrayUtils.reverse(array, 0, 5);
        assertArrayEquals(new Object[] { 1, 1, 1, 1, 1 }, array);
    }
}

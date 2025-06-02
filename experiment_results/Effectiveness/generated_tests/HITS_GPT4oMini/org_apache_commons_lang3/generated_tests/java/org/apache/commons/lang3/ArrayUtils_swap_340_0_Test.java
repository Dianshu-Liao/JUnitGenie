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

public class ArrayUtils_swap_340_0_Test {

    @Test
    public void testSwap_EmptyArray() {
        Object[] array = {};
        ArrayUtils.swap(array, 0, 1);
        assertArrayEquals(array, new Object[] {});
    }

    @Test
    public void testSwap_IndexOutOfBounds_Offset1() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, 3, 1);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }

    @Test
    public void testSwap_IndexOutOfBounds_Offset2() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, 1, 3);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }

    @Test
    public void testSwap_IndexOutOfBounds_Both() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, 3, 4);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }

    @Test
    public void testSwap_ValidSwap() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, 0, 2);
        assertArrayEquals(array, new Object[] { 3, 2, 1 });
    }

    @Test
    public void testSwap_SameIndex() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, 1, 1);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }

    @Test
    public void testSwap_NegativeIndex() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, -1, 1);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }

    @Test
    public void testSwap_NegativeIndexBoth() {
        Object[] array = { 1, 2, 3 };
        ArrayUtils.swap(array, -1, -2);
        assertArrayEquals(array, new Object[] { 1, 2, 3 });
    }
}

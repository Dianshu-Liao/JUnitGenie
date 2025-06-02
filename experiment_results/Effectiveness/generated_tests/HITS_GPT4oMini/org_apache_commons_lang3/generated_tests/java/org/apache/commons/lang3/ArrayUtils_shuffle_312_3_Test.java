package org.apache.commons.lang3;

import java.util.Arrays;
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

public class ArrayUtils_shuffle_312_3_Test {

    @Test
    public void testShuffle_NullArray() {
        Object[] array = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ArrayUtils.shuffle(array);
        });
        assertEquals("array is null", exception.getMessage());
    }

    @Test
    public void testShuffle_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shuffle(array);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    public void testShuffle_SingleElementArray() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testShuffle_TwoElementArray() {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.shuffle(array);
        assertTrue(Arrays.asList(array).contains("A"));
        assertTrue(Arrays.asList(array).contains("B"));
        assertEquals(2, array.length);
    }

    @Test
    public void testShuffle_MultipleElementArray() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        Object[] originalArray = Arrays.copyOf(array, array.length);
        ArrayUtils.shuffle(array);
        assertTrue(Arrays.asList(originalArray).containsAll(Arrays.asList(array)));
        assertNotEquals(Arrays.toString(originalArray), Arrays.toString(array));
    }

    @Test
    public void testShuffle_ArrayWithNullElements() {
        Object[] array = new Object[] { null, "B", null, "D" };
        ArrayUtils.shuffle(array);
        assertTrue(Arrays.asList(array).contains(null));
        assertEquals(4, array.length);
    }

    @Test
    public void testShuffle_ArrayWithSameElements() {
        Object[] array = new Object[] { "A", "A", "A", "A" };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { "A", "A", "A", "A" }, array);
    }
}

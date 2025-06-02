package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Random;
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

public class ArrayUtils_shuffle_313_0_Test {

    @Test
    public void testShuffle_NonEmptyArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        // Fixed seed for reproducibility
        Random random = new Random(0);
        ArrayUtils.shuffle(array, random);
        assertNotNull(array);
        assertEquals(5, array.length);
        assertTrue(Arrays.asList(array).contains(1));
        assertTrue(Arrays.asList(array).contains(2));
        assertTrue(Arrays.asList(array).contains(3));
        assertTrue(Arrays.asList(array).contains(4));
        assertTrue(Arrays.asList(array).contains(5));
    }

    @Test
    public void testShuffle_EmptyArray() {
        Object[] array = {};
        Random random = new Random();
        ArrayUtils.shuffle(array, random);
        assertNotNull(array);
        assertEquals(0, array.length);
    }

    @Test
    public void testShuffle_SingleElementArray() {
        Object[] array = { 1 };
        Random random = new Random();
        ArrayUtils.shuffle(array, random);
        assertNotNull(array);
        assertEquals(1, array.length);
        assertEquals(1, array[0]);
    }

    @Test
    public void testShuffle_NullArray() {
        Object[] array = null;
        Random random = new Random();
        assertThrows(NullPointerException.class, () -> {
            ArrayUtils.shuffle(array, random);
        });
    }

    @Test
    public void testShuffle_WithRandomness() {
        Object[] array = { 1, 2, 3, 4, 5 };
        Random random = new Random();
        Object[] originalArray = array.clone();
        ArrayUtils.shuffle(array, random);
        assertNotEquals(Arrays.toString(originalArray), Arrays.toString(array), "Array should be shuffled");
    }

    @Test
    public void testShuffle_WithSameSeed() {
        Object[] array1 = { 1, 2, 3, 4, 5 };
        Object[] array2 = array1.clone();
        Random random1 = new Random(42);
        Random random2 = new Random(42);
        ArrayUtils.shuffle(array1, random1);
        ArrayUtils.shuffle(array2, random2);
        assertArrayEquals(array1, array2, "Shuffled arrays should be the same with the same seed");
    }
}

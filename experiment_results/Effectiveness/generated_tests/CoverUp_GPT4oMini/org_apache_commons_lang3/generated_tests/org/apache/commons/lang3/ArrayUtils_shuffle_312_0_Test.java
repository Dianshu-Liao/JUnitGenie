package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class ArrayUtils_shuffle_312_0_Test {

    @Test
    public void testShuffle_NullArray() {
        Object[] array = null;
        ArrayUtils.shuffle(array);
        assertNull(array);
    }

    @Test
    public void testShuffle_EmptyArray() {
        Object[] array = {};
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testShuffle_SingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { 1 }, array);
    }

    @Test
    public void testShuffle_MultipleElementsArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        Object[] originalArray = Arrays.copyOf(array, array.length);
        // Shuffle multiple times to ensure randomness
        for (int i = 0; i < 10; i++) {
            ArrayUtils.shuffle(array);
            assertNotEquals(Arrays.toString(originalArray), Arrays.toString(array));
        }
    }

    @Test
    public void testShuffle_AlreadyShuffledArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shuffle(array);
        Object[] shuffledArray = Arrays.copyOf(array, array.length);
        ArrayUtils.shuffle(shuffledArray);
        assertNotEquals(Arrays.toString(array), Arrays.toString(shuffledArray));
    }

    @Test
    public void testShuffle_SimilarElementsArray() {
        Object[] array = { 1, 1, 1, 1, 1 };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { 1, 1, 1, 1, 1 }, array);
    }

    @Test
    public void testShuffle_LargeArray() {
        Object[] array = new Object[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Object[] originalArray = Arrays.copyOf(array, array.length);
        ArrayUtils.shuffle(array);
        assertNotEquals(Arrays.toString(originalArray), Arrays.toString(array));
    }
}

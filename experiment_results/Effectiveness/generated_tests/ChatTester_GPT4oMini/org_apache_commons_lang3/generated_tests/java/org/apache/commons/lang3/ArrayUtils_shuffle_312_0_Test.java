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
    public void testShuffleWithNullArray() {
        Object[] array = null;
        assertThrows(NullPointerException.class, () -> ArrayUtils.shuffle(array));
    }

    @Test
    public void testShuffleWithEmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shuffle(array);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    public void testShuffleWithSingleElementArray() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testShuffleWithMultipleElementsArray() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        Object[] originalArray = Arrays.copyOf(array, array.length);
        ArrayUtils.shuffle(array);
        assertNotEquals(Arrays.toString(originalArray), Arrays.toString(array));
    }

    @Test
    public void testShuffleWithAllIdenticalElements() {
        Object[] array = new Object[] { "A", "A", "A", "A" };
        ArrayUtils.shuffle(array);
        assertArrayEquals(new Object[] { "A", "A", "A", "A" }, array);
    }

    // Reflection test for private methods if needed in future
    private void invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod(methodName, Arrays.stream(args).map(Object::getClass).toArray(Class[]::new));
        method.setAccessible(true);
        method.invoke(null, args);
    }

    @Test
    public void testShuffleWithRandomness() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        Object[] originalArray = Arrays.copyOf(array, array.length);
        // Shuffle multiple times to check randomness
        boolean shuffled = false;
        for (int i = 0; i < 100; i++) {
            ArrayUtils.shuffle(array);
            if (!Arrays.equals(originalArray, array)) {
                shuffled = true;
                break;
            }
        }
        assertTrue(shuffled, "Array was not shuffled after multiple attempts.");
    }
}

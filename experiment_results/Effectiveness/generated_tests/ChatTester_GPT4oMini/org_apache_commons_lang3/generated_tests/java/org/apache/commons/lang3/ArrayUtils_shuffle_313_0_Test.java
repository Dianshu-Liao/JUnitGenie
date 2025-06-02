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

public class ArrayUtils_shuffle_313_0_Test {

    @Test
    public void testShuffle() throws Exception {
        // Arrange
        Object[] array = { 1, 2, 3, 4, 5 };
        // Using a fixed seed for predictable results
        Random random = new Random(0);
        // Act
        ArrayUtils.shuffle(array, random);
        // Assert
        assertNotNull(array);
        assertEquals(5, array.length);
        assertTrue(Arrays.asList(array).contains(1));
        assertTrue(Arrays.asList(array).contains(2));
        assertTrue(Arrays.asList(array).contains(3));
        assertTrue(Arrays.asList(array).contains(4));
        assertTrue(Arrays.asList(array).contains(5));
    }

    @Test
    public void testShuffleEmptyArray() throws Exception {
        // Arrange
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        Random random = new Random();
        // Act
        ArrayUtils.shuffle(array, random);
        // Assert
        assertEquals(0, array.length);
    }

    @Test
    public void testShuffleSingleElementArray() throws Exception {
        // Arrange
        Object[] array = { 1 };
        Random random = new Random();
        // Act
        ArrayUtils.shuffle(array, random);
        // Assert
        assertEquals(1, array.length);
        assertEquals(1, array[0]);
    }

    @Test
    public void testShuffleNullArray() {
        // Arrange
        Object[] array = null;
        Random random = new Random();
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            ArrayUtils.shuffle(array, random);
        });
    }

    @Test
    public void testShuffleWithNullRandom() throws Exception {
        // Arrange
        Object[] array = { 1, 2, 3 };
        Random random = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            ArrayUtils.shuffle(array, random);
        });
    }

    // Reflection test to invoke private swap method
    @Test
    public void testSwapMethod() throws Exception {
        // Arrange
        Object[] array = { 1, 2, 3 };
        Method swapMethod = ArrayUtils.class.getDeclaredMethod("swap", Object[].class, int.class, int.class, int.class);
        swapMethod.setAccessible(true);
        // Act
        swapMethod.invoke(null, (Object) array, 0, 1, 1);
        // Assert
        assertEquals(2, array[0]);
        assertEquals(1, array[1]);
        assertEquals(3, array[2]);
    }
}

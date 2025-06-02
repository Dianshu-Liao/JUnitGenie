package org.apache.commons.lang3;

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
import java.util.Arrays;
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

public class ArrayUtils_shuffle_312_1_Test {

    @Test
    public void testShuffle_NullArray_ThrowsIllegalArgumentException() {
        // Arrange
        Object[] array = null;
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.shuffle(array);
        });
        assertEquals("Array must not be null", thrown.getMessage());
    }

    @Test
    public void testShuffle_EmptyArray_DoesNotThrowException() {
        // Arrange
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        // Act
        assertDoesNotThrow(() -> ArrayUtils.shuffle(array));
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    public void testShuffle_SingleElementArray_DoesNotChangeArray() {
        // Arrange
        Object[] array = new Object[] { "SingleElement" };
        // Act
        ArrayUtils.shuffle(array);
        // Assert
        assertArrayEquals(new Object[] { "SingleElement" }, array);
    }

    @Test
    public void testShuffle_MultipleElements_ArrayIsShuffled() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        Object[] originalArray = array.clone();
        // Act
        ArrayUtils.shuffle(array);
        // Assert
        // Check that the shuffled array is not equal to the original array (though it might be in some cases, it's unlikely)
        assertFalse(Arrays.equals(originalArray, array), "Array should be shuffled");
    }
}

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

public class ArrayUtils_shift_294_1_Test {

    @Test
    public void testShift_NullArray() {
        // Arrange
        Object[] array = null;
        int offset = 2;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        // No exception should be thrown, and method should handle null gracefully
    }

    @Test
    public void testShift_EmptyArray() {
        // Arrange
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        int offset = 2;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Test
    public void testShift_SingleElementArray() {
        // Arrange
        Object[] array = new Object[] { "A" };
        int offset = 1;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, new Object[] { "A" });
    }

    @Test
    public void testShift_TwoElementArray_PositiveOffset() {
        // Arrange
        Object[] array = new Object[] { "A", "B" };
        int offset = 1;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, new Object[] { "B", "A" });
    }

    @Test
    public void testShift_TwoElementArray_NegativeOffset() {
        // Arrange
        Object[] array = new Object[] { "A", "B" };
        int offset = -1;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, new Object[] { "B", "A" });
    }

    @Test
    public void testShift_MultipleElements_PositiveOffset() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        int offset = 2;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, new Object[] { "D", "E", "A", "B", "C" });
    }

    @Test
    public void testShift_MultipleElements_NegativeOffset() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        int offset = -2;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        assertArrayEquals(array, new Object[] { "C", "D", "E", "A", "B" });
    }

    @Test
    public void testShift_OffsetGreaterThanArrayLength() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C" };
        // offset greater than length
        int offset = 4;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        // Should wrap around
        assertArrayEquals(array, new Object[] { "B", "C", "A" });
    }

    @Test
    public void testShift_OffsetNegativeGreaterThanArrayLength() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C" };
        // negative offset greater than length
        int offset = -4;
        // Act
        ArrayUtils.shift(array, offset);
        // Assert
        // Should wrap around
        assertArrayEquals(array, new Object[] { "B", "C", "A" });
    }
}

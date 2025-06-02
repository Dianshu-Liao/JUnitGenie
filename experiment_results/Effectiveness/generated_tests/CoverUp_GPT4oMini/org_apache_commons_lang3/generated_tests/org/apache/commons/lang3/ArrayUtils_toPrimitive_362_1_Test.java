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

public class ArrayUtils_toPrimitive_362_1_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Arrange
        Float[] input = null;
        // Act
        float[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Arrange
        Float[] input = new Float[0];
        // Act
        float[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, result);
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        // Arrange
        Float[] input = new Float[] { 1.5f };
        // Act
        float[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertArrayEquals(new float[] { 1.5f }, result);
    }

    @Test
    public void testToPrimitive_MultipleElementsArray() {
        // Arrange
        Float[] input = new Float[] { 1.1f, 2.2f, 3.3f };
        // Act
        float[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertArrayEquals(new float[] { 1.1f, 2.2f, 3.3f }, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullElements() {
        // Arrange
        Float[] input = new Float[] { 1.1f, null, 3.3f };
        // Act
        float[] result = ArrayUtils.toPrimitive(input);
        // Assert
        // null will be converted to 0.0f
        assertArrayEquals(new float[] { 1.1f, 0.0f, 3.3f }, result);
    }
}

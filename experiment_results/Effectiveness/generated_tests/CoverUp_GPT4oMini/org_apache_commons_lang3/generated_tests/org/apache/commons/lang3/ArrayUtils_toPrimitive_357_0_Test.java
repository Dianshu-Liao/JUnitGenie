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

public class ArrayUtils_toPrimitive_357_0_Test {

    @Test
    public void testToPrimitive_withNullArray() {
        // Arrange
        Byte[] input = null;
        byte defaultValue = 0;
        // Act
        byte[] result = ArrayUtils.toPrimitive(input, defaultValue);
        // Assert
        assertNull(result);
    }

    @Test
    public void testToPrimitive_withEmptyArray() {
        // Arrange
        Byte[] input = {};
        byte defaultValue = 0;
        // Act
        byte[] result = ArrayUtils.toPrimitive(input, defaultValue);
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToPrimitive_withNonEmptyArray_noNulls() {
        // Arrange
        Byte[] input = { 1, 2, 3 };
        byte defaultValue = 0;
        // Act
        byte[] result = ArrayUtils.toPrimitive(input, defaultValue);
        // Assert
        assertArrayEquals(new byte[] { 1, 2, 3 }, result);
    }

    @Test
    public void testToPrimitive_withNonEmptyArray_withNulls() {
        // Arrange
        Byte[] input = { 1, null, 3 };
        byte defaultValue = 0;
        // Act
        byte[] result = ArrayUtils.toPrimitive(input, defaultValue);
        // Assert
        assertArrayEquals(new byte[] { 1, 0, 3 }, result);
    }

    @Test
    public void testToPrimitive_withNonEmptyArray_allNulls() {
        // Arrange
        Byte[] input = { null, null, null };
        byte defaultValue = 5;
        // Act
        byte[] result = ArrayUtils.toPrimitive(input, defaultValue);
        // Assert
        assertArrayEquals(new byte[] { 5, 5, 5 }, result);
    }
}

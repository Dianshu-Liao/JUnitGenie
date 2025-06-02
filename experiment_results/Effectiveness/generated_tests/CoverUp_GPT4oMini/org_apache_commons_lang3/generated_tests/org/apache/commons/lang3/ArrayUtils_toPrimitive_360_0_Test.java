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

public class ArrayUtils_toPrimitive_360_0_Test {

    @Test
    public void testToPrimitive_withNullArray() {
        // Arrange
        Double[] input = null;
        // Act
        double[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertNull(result);
    }

    @Test
    public void testToPrimitive_withEmptyArray() {
        // Arrange
        Double[] input = new Double[0];
        // Act
        double[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result);
    }

    @Test
    public void testToPrimitive_withValidArray() {
        // Arrange
        Double[] input = { 1.1, 2.2, 3.3 };
        // Act
        double[] result = ArrayUtils.toPrimitive(input);
        // Assert
        assertArrayEquals(new double[] { 1.1, 2.2, 3.3 }, result);
    }

    @Test
    public void testToPrimitive_withArrayContainingNull() {
        // Arrange
        Double[] input = { 1.1, null, 3.3 };
        // Act
        double[] result = ArrayUtils.toPrimitive(input);
        // Assert
        // null is converted to 0.0
        assertArrayEquals(new double[] { 1.1, 0.0, 3.3 }, result);
    }
}

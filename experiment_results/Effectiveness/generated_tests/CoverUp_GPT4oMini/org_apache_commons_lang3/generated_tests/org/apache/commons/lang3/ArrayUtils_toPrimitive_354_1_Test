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

public class ArrayUtils_toPrimitive_354_1_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Arrange
        Boolean[] input = null;
        // Act
        boolean[] result = invokeToPrimitive(input);
        // Assert
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Arrange
        Boolean[] input = new Boolean[0];
        // Act
        boolean[] result = invokeToPrimitive(input);
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Arrange
        Boolean[] input = new Boolean[] { null, Boolean.TRUE, Boolean.FALSE };
        // Act
        boolean[] result = invokeToPrimitive(input);
        // Assert
        assertArrayEquals(new boolean[] { false, true, false }, result);
    }

    @Test
    public void testToPrimitive_ArrayWithBooleans() {
        // Arrange
        Boolean[] input = new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE };
        // Act
        boolean[] result = invokeToPrimitive(input);
        // Assert
        assertArrayEquals(new boolean[] { true, false, true }, result);
    }

    private boolean[] invokeToPrimitive(Boolean[] array) {
        try {
            Method method = ArrayUtils.class.getDeclaredMethod("toPrimitive", Boolean[].class);
            method.setAccessible(true);
            return (boolean[]) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class ArrayUtils_reverse_274_0_Test {

    @Test
    public void testReverse_NullArray() {
        // Arrange
        Object[] array = null;
        // Act
        ArrayUtils.reverse(array);
        // Assert
        // No exception should be thrown, and nothing should happen
    }

    @Test
    public void testReverse_EmptyArray() {
        // Arrange
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        // Act
        ArrayUtils.reverse(array);
        // Assert
        assertArrayEquals(array, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Test
    public void testReverse_SingleElementArray() {
        // Arrange
        Object[] array = new Object[] { "A" };
        // Act
        ArrayUtils.reverse(array);
        // Assert
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testReverse_MultipleElementsArray() {
        // Arrange
        Object[] array = new Object[] { "A", "B", "C" };
        // Act
        invokeReverse(array);
        // Assert
        assertArrayEquals(new Object[] { "C", "B", "A" }, array);
    }

    @Test
    public void testReverse_EmptyStringArray() {
        // Arrange
        String[] array = new String[] {};
        // Act
        ArrayUtils.reverse(array);
        // Assert
        assertArrayEquals(new String[] {}, array);
    }

    private void invokeReverse(Object[] array) {
        try {
            Method method = ArrayUtils.class.getDeclaredMethod("reverse", Object[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(null, (Object) array, 0, array.length);
        } catch (Exception e) {
            fail("Reflection invocation failed: " + e.getMessage());
        }
    }
}

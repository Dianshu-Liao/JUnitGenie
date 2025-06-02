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

public class ArrayUtils_nullToEmpty_200_0_Test {

    @Test
    public void testNullToEmpty_withNullArray() throws Exception {
        // Arrange
        String[] input = null;
        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
        // Act
        String[] result = invokeNullToEmpty(input);
        // Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testNullToEmpty_withEmptyArray() throws Exception {
        // Arrange
        String[] input = new String[0];
        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
        // Act
        String[] result = invokeNullToEmpty(input);
        // Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testNullToEmpty_withNonEmptyArray() throws Exception {
        // Arrange
        String[] input = new String[] { "Hello", "World" };
        String[] expected = new String[] { "Hello", "World" };
        // Act
        String[] result = invokeNullToEmpty(input);
        // Assert
        Assertions.assertArrayEquals(expected, result);
    }

    private String[] invokeNullToEmpty(String[] array) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("nullTo", Object.class, Object.class);
        method.setAccessible(true);
        return (String[]) method.invoke(null, array, ArrayUtils.EMPTY_STRING_ARRAY);
    }
}

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

public class ArrayUtils_isArrayEmpty_116_0_Test {

    @Test
    public void testIsArrayEmpty_WithNull() throws Exception {
        // Arrange
        Object array = null;
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyArray() throws Exception {
        // Arrange
        Object array = new int[0];
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyArray() throws Exception {
        // Arrange
        Object array = new int[] { 1, 2, 3 };
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyObjectArray() throws Exception {
        // Arrange
        Object array = new String[0];
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyObjectArray() throws Exception {
        // Arrange
        Object array = new String[] { "Hello" };
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyBooleanArray() throws Exception {
        // Arrange
        Object array = new boolean[0];
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyBooleanArray() throws Exception {
        // Arrange
        Object array = new boolean[] { true };
        // Act
        boolean result = invokeIsArrayEmpty(array);
        // Assert
        assertFalse(result);
    }

    private boolean invokeIsArrayEmpty(Object array) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, array);
    }
}

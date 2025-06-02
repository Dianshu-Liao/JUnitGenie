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

public class ArrayUtils_isSameLength_144_0_Test {

    @Test
    public void testIsSameLength_NullArrays() throws Exception {
        // Arrange
        Object array1 = null;
        Object array2 = null;
        // Act
        boolean result = invokeIsSameLength(array1, array2);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsSameLength_EmptyArrays() throws Exception {
        // Arrange
        Object array1 = new int[0];
        Object array2 = new int[0];
        // Act
        boolean result = invokeIsSameLength(array1, array2);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsSameLength_DifferentLengthArrays() throws Exception {
        // Arrange
        Object array1 = new int[5];
        Object array2 = new int[10];
        // Act
        boolean result = invokeIsSameLength(array1, array2);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsSameLength_SameLengthArrays() throws Exception {
        // Arrange
        Object array1 = new int[3];
        Object array2 = new int[3];
        // Act
        boolean result = invokeIsSameLength(array1, array2);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsSameLength_NullAndEmptyArray() throws Exception {
        // Arrange
        Object array1 = null;
        Object array2 = new int[0];
        // Act
        boolean result = invokeIsSameLength(array1, array2);
        // Assert
        assertFalse(result);
    }

    private boolean invokeIsSameLength(Object array1, Object array2) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("isSameLength", Object.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, array1, array2);
    }
}

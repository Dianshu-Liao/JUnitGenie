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

public class ArrayUtils_toStringArray_374_0_Test {

    @Test
    public void testToStringArray_NullArray() {
        String[] result = ArrayUtils.toStringArray(null, "null");
        assertNull(result);
    }

    @Test
    public void testToStringArray_EmptyArray() {
        String[] result = ArrayUtils.toStringArray(new Object[0], "null");
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test
    public void testToStringArray_ArrayWithNullElements() {
        Object[] input = { null, "Hello", null };
        String[] result = ArrayUtils.toStringArray(input, "null");
        String[] expected = { "null", "Hello", "null" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToStringArray_ArrayWithNonNullElements() {
        Object[] input = { "Hello", "World", 123 };
        String[] result = ArrayUtils.toStringArray(input, "null");
        String[] expected = { "Hello", "World", "123" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToStringArray_ArrayWithAllNulls() {
        Object[] input = { null, null, null };
        String[] result = ArrayUtils.toStringArray(input, "null");
        String[] expected = { "null", "null", "null" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToStringArray_ArrayWithMixedElements() {
        Object[] input = { null, "Test", 42, null, "JUnit" };
        String[] result = ArrayUtils.toStringArray(input, "null");
        String[] expected = { "null", "Test", "42", "null", "JUnit" };
        assertArrayEquals(expected, result);
    }

    // Reflection test for private method (if needed)
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod(methodName, Object[].class, String.class);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}

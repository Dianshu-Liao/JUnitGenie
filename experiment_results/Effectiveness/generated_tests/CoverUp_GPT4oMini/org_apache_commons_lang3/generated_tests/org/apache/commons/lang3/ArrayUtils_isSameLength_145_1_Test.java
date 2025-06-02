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

public class ArrayUtils_isSameLength_145_1_Test {

    @Test
    public void testIsSameLength_BothArraysNull() {
        Object[] array1 = null;
        Object[] array2 = null;
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_FirstArrayNull() {
        Object[] array1 = null;
        Object[] array2 = new Object[5];
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_SecondArrayNull() {
        Object[] array1 = new Object[5];
        Object[] array2 = null;
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_ArraysOfSameLength() {
        Object[] array1 = new Object[5];
        Object[] array2 = new Object[5];
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_ArraysOfDifferentLength() {
        Object[] array1 = new Object[5];
        Object[] array2 = new Object[3];
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_EmptyArrays() {
        Object[] array1 = new Object[0];
        Object[] array2 = new Object[0];
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_OneEmptyArray() {
        Object[] array1 = new Object[0];
        Object[] array2 = new Object[5];
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_AnotherEmptyArray() {
        Object[] array1 = new Object[5];
        Object[] array2 = new Object[0];
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    // Reflection test to invoke private method 'getLength'
    @Test
    public void testGetLengthReflection() throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("getLength", Object.class);
        method.setAccessible(true);
        assertEquals(0, method.invoke(null, null));
        assertEquals(5, method.invoke(null, new Object[5]));
    }
}

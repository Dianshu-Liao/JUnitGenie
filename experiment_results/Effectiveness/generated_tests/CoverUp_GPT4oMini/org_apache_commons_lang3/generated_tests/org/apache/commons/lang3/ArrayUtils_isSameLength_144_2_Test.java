package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

public class ArrayUtils_isSameLength_144_2_Test {

    @Test
    public void testIsSameLength_WithEqualLengthArrays() {
        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 4, 5, 6 };
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithUnequalLengthArrays() {
        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 4, 5 };
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithOneNullArray() {
        int[] array1 = { 1, 2, 3 };
        Object array2 = null;
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithBothNullArrays() {
        Object array1 = null;
        Object array2 = null;
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithEmptyArrays() {
        int[] array1 = {};
        int[] array2 = {};
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithDifferentTypes() {
        int[] array1 = { 1, 2, 3 };
        String[] array2 = { "a", "b", "c" };
        assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_WithDifferentObjectArrays() {
        Object[] array1 = new Object[3];
        Object[] array2 = new Object[2];
        assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testPrivateGetLengthMethod() throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("getLength", Object.class);
        method.setAccessible(true);
        // Test with a non-null array
        int[] testArray = { 1, 2, 3 };
        int length = (int) method.invoke(null, testArray);
        assertTrue(length == 3);
        // Test with a null array
        Object nullArray = null;
        length = (int) method.invoke(null, nullArray);
        assertTrue(length == 0);
    }
}

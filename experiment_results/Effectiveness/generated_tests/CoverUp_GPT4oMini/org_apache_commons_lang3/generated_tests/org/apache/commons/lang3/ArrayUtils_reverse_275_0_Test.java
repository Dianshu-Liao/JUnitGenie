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

public class ArrayUtils_reverse_275_0_Test {

    @Test
    public void testReverse_NullArray() {
        Object[] array = null;
        ArrayUtils.reverse(array, 0, 1);
        // No exception should be thrown and nothing should happen
    }

    @Test
    public void testReverse_EmptyArray() {
        Object[] array = new Object[0];
        ArrayUtils.reverse(array, 0, 1);
        assertArrayEquals(new Object[0], array);
    }

    @Test
    public void testReverse_SingleElement() {
        Object[] array = new Object[] { "A" };
        ArrayUtils.reverse(array, 0, 1);
        assertArrayEquals(new Object[] { "A" }, array);
    }

    @Test
    public void testReverse_TwoElements() {
        Object[] array = new Object[] { "A", "B" };
        ArrayUtils.reverse(array, 0, 2);
        assertArrayEquals(new Object[] { "B", "A" }, array);
    }

    @Test
    public void testReverse_MultipleElements() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.reverse(array, 1, 3);
        assertArrayEquals(new Object[] { "A", "C", "B", "D" }, array);
    }

    @Test
    public void testReverse_WithNegativeStartIndex() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.reverse(array, -1, 3);
        assertArrayEquals(new Object[] { "C", "B", "A", "D" }, array);
    }

    @Test
    public void testReverse_WithEndIndexGreaterThanLength() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.reverse(array, 0, 10);
        assertArrayEquals(new Object[] { "D", "C", "B", "A" }, array);
    }

    @Test
    public void testReverse_IdenticalStartAndEndIndex() {
        Object[] array = new Object[] { "A", "B", "C", "D" };
        ArrayUtils.reverse(array, 1, 1);
        assertArrayEquals(new Object[] { "A", "B", "C", "D" }, array);
    }

    @Test
    public void testReverse_ComplexObjects() {
        Object[] array = new Object[] { new Object(), new Object(), new Object() };
        ArrayUtils.reverse(array, 0, 3);
        // Ensure they are different objects
        assertNotSame(array[0], array[2]);
    }

    @Test
    public void testReverse_BoundaryConditions() {
        Object[] array = new Object[] { "A", "B", "C", "D", "E" };
        ArrayUtils.reverse(array, 0, 5);
        assertArrayEquals(new Object[] { "E", "D", "C", "B", "A" }, array);
    }

    private void invokePrivateReverse(Object[] array, int startIndex, int endIndex) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("reverse", Object[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(null, (Object) array, startIndex, endIndex);
    }
}

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

public class ArrayUtils_shift_294_0_Test {

    @Test
    public void testShift_NullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 1);
        // No exception should be thrown
    }

    @Test
    public void testShift_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.shift(array, 1);
        // No exception should be thrown
    }

    @Test
    public void testShift_NonEmptyArray() throws Exception {
        Object[] array = new Object[] { "A", "B", "C" };
        int offset = 1;
        // Use reflection to invoke the private method
        Method shiftMethod = ArrayUtils.class.getDeclaredMethod("shift", Object[].class, int.class, int.class, int.class);
        shiftMethod.setAccessible(true);
        // Invoke the method
        shiftMethod.invoke(null, array, 0, array.length, offset);
        // Validate the result (assuming the shift method modifies the array)
        assertArrayEquals(new Object[] { "B", "C", null }, array);
    }

    @Test
    public void testShift_NegativeOffset() throws Exception {
        Object[] array = new Object[] { "A", "B", "C" };
        int offset = -1;
        Method shiftMethod = ArrayUtils.class.getDeclaredMethod("shift", Object[].class, int.class, int.class, int.class);
        shiftMethod.setAccessible(true);
        shiftMethod.invoke(null, array, 0, array.length, offset);
        // Validate the result (assuming the shift method modifies the array)
        // Assuming no change for negative offset
        assertArrayEquals(new Object[] { "A", "B", "C" }, array);
    }

    @Test
    public void testShift_OffsetGreaterThanLength() throws Exception {
        Object[] array = new Object[] { "A", "B", "C" };
        int offset = 5;
        Method shiftMethod = ArrayUtils.class.getDeclaredMethod("shift", Object[].class, int.class, int.class, int.class);
        shiftMethod.setAccessible(true);
        shiftMethod.invoke(null, array, 0, array.length, offset);
        // Validate the result (assuming the shift method modifies the array)
        // Assuming all elements are shifted out
        assertArrayEquals(new Object[] { null, null, null }, array);
    }
}

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

public class ArrayUtils_swap_340_0_Test {

    @Test
    public void testSwap() throws Exception {
        // Test case 1: Swap two elements in a non-empty array
        Object[] array1 = { 1, 2, 3 };
        ArrayUtils.swap(array1, 0, 1);
        assertArrayEquals(new Object[] { 2, 1, 3 }, array1);
        // Test case 2: Swap two elements in an array with identical elements
        Object[] array2 = { "a", "a", "b" };
        ArrayUtils.swap(array2, 0, 1);
        assertArrayEquals(new Object[] { "a", "a", "b" }, array2);
        // Test case 3: Swap elements at the same index (should remain unchanged)
        Object[] array3 = { 1, 2, 3 };
        ArrayUtils.swap(array3, 1, 1);
        assertArrayEquals(new Object[] { 1, 2, 3 }, array3);
        // Test case 4: Swap elements with negative offsets (should throw ArrayIndexOutOfBoundsException)
        Object[] array4 = { 1, 2, 3 };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ArrayUtils.swap(array4, -1, 2);
        });
        // Test case 5: Swap elements with offsets out of bounds (should throw ArrayIndexOutOfBoundsException)
        Object[] array5 = { 1, 2, 3 };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ArrayUtils.swap(array5, 0, 3);
        });
    }

    // Reflection test to invoke the private swap method
    @Test
    public void testPrivateSwap() throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("swap", Object[].class, int.class, int.class);
        method.setAccessible(true);
        // Test case for private swap method
        Object[] array6 = { 4, 5, 6 };
        method.invoke(null, (Object) array6, 0, 2);
        assertArrayEquals(new Object[] { 6, 5, 4 }, array6);
    }
}

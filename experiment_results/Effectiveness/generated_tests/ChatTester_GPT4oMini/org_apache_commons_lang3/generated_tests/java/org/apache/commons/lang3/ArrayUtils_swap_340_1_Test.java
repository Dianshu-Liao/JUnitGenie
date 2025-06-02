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

public class ArrayUtils_swap_340_1_Test {

    @Test
    public void testSwap() throws Exception {
        // Prepare the test data
        Object[] array = { 1, 2, 3, 4, 5 };
        // Invoke the swap method
        invokeSwap(array, 0, 4);
        // Assert the expected outcome
        assertArrayEquals(new Object[] { 5, 2, 3, 4, 1 }, array);
    }

    @Test
    public void testSwapWithSameIndex() throws Exception {
        // Prepare the test data
        Object[] array = { 1, 2, 3, 4, 5 };
        // Invoke the swap method
        invokeSwap(array, 2, 2);
        // Assert the expected outcome (should remain unchanged)
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testSwapWithOutOfBoundsIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        // Assert that an ArrayIndexOutOfBoundsException is thrown
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Index 5 is out of bounds
            invokeSwap(array, 0, 5);
        });
    }

    @Test
    public void testSwapWithNegativeIndex() {
        Object[] array = { 1, 2, 3, 4, 5 };
        // Assert that an ArrayIndexOutOfBoundsException is thrown for negative index
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Negative index
            invokeSwap(array, -1, 2);
        });
    }

    private void invokeSwap(Object[] array, int offset1, int offset2) throws Exception {
        // Use reflection to access the private method
        Method method = ArrayUtils.class.getDeclaredMethod("swap", Object[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(null, (Object) array, offset1, offset2);
    }
}

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

public class ArrayUtils_swap_341_0_Test {

    private ArrayUtils arrayUtils;

    @BeforeEach
    public void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Test
    public void testSwap_ValidOffsets_SwapsElements() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new Object[] { 1, 4, 3, 2, 5 }, array);
    }

    @Test
    public void testSwap_EmptyArray_DoesNotChangeArray() {
        Object[] array = {};
        arrayUtils.swap(array, 0, 1, 1);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testSwap_OffsetOutOfBounds_DoesNotChangeArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, 1, 5, 2);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testSwap_NegativeOffset_SwapsElements() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, -1, 0, 1);
        assertArrayEquals(new Object[] { 5, 2, 3, 4, 1 }, array);
    }

    @Test
    public void testSwap_LenTooLarge_SwapsOnlyAvailable() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, 0, 1, 10);
        assertArrayEquals(new Object[] { 2, 1, 3, 4, 5 }, array);
    }

    @Test
    public void testSwap_SameOffsets_DoesNotChangeArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, 1, 1, 2);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testSwap_ZeroLength_DoesNotChangeArray() {
        Object[] array = { 1, 2, 3, 4, 5 };
        arrayUtils.swap(array, 1, 2, 0);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    // Reflection to invoke private methods if needed
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(arrayUtils, args);
    }
}

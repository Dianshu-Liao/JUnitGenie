package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

public class ArrayUtils_toPrimitive_364_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Integer[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        assertArrayEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[] {}));
    }

    @Test
    public void testToPrimitive_ValidArray() {
        // Test with valid array
        Integer[] input = { 1, 2, 3 };
        int[] expected = { 1, 2, 3 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        // Test with array containing null values
        Integer[] input = { 1, null, 3 };
        assertThrows(NullPointerException.class, () -> {
            ArrayUtils.toPrimitive(input);
        });
    }

    @Test
    public void testToPrimitive_ArrayWithAllNulls() {
        // Test with array containing only null values
        Integer[] input = { null, null, null };
        assertThrows(NullPointerException.class, () -> {
            ArrayUtils.toPrimitive(input);
        });
    }
}

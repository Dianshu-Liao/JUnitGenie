package org.apache.commons.lang3;

import java.lang.reflect.Array;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class ArrayUtils_toPrimitive_360_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Double[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.toPrimitive(new Double[0]));
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        Double[] input = { 1.0 };
        double[] expected = { 1.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    public void testToPrimitive_MultipleElementArray() {
        Double[] input = { 1.0, 2.0, 3.0 };
        double[] expected = { 1.0, 2.0, 3.0 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    public void testToPrimitive_ArrayWithNullElement() {
        Double[] input = { 1.0, null, 3.0 };
        double[] result = ArrayUtils.toPrimitive(input);
        assertEquals(1.0, result[0]);
        // null should be converted to 0.0
        assertEquals(0.0, result[1]);
        assertEquals(3.0, result[2]);
    }
}

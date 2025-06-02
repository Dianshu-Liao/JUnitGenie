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

public class ArrayUtils_toPrimitive_370_2_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Short[] input = null;
        short valueForNull = 0;
        short[] expected = null;
        short[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Short[] input = new Short[0];
        short valueForNull = 0;
        short[] expected = ArrayUtils.EMPTY_SHORT_ARRAY;
        short[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedValues() {
        Short[] input = new Short[] { 1, null, 3 };
        short valueForNull = 0;
        short[] expected = new short[] { 1, valueForNull, 3 };
        short[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_AllNulls() {
        Short[] input = new Short[] { null, null, null };
        short valueForNull = 5;
        short[] expected = new short[] { valueForNull, valueForNull, valueForNull };
        short[] result = invokeToPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    private short[] invokeToPrimitive(Short[] array, short valueForNull) {
        try {
            Method method = ArrayUtils.class.getDeclaredMethod("toPrimitive", Short[].class, short.class);
            method.setAccessible(true);
            return (short[]) method.invoke(null, array, valueForNull);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

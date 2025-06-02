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

public class ArrayUtils_toPrimitive_354_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Boolean[] input = null;
        boolean[] expected = null;
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Boolean[] input = {};
        boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_SingleTrueElement() {
        Boolean[] input = { true };
        boolean[] expected = { true };
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_SingleFalseElement() {
        Boolean[] input = { false };
        boolean[] expected = { false };
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_NullElement() {
        Boolean[] input = { null, true, false };
        // Assuming default false for null
        boolean[] expected = { false, true, false };
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToPrimitive_MultipleElements() {
        Boolean[] input = { true, null, false, true };
        // Assuming default false for null
        boolean[] expected = { true, false, false, true };
        boolean[] actual = invokeToPrimitive(input);
        assertArrayEquals(expected, actual);
    }

    private boolean[] invokeToPrimitive(Boolean[] array) {
        try {
            Method method = ArrayUtils.class.getDeclaredMethod("toPrimitive", Boolean[].class);
            method.setAccessible(true);
            return (boolean[]) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

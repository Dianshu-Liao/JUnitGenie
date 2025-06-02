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

public class ArrayUtils_toPrimitive_355_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test with null array
        boolean[] result = ArrayUtils.toPrimitive(null, true);
        assertNull(result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        boolean[] result = ArrayUtils.toPrimitive(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, true);
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    public void testToPrimitive_AllTrue() {
        // Test with all true values
        Boolean[] input = { true, true, true };
        boolean[] expected = { true, true, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_AllFalse() {
        // Test with all false values
        Boolean[] input = { false, false, false };
        boolean[] expected = { false, false, false };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedValues() {
        // Test with mixed values
        Boolean[] input = { true, null, false, null, true };
        boolean[] expected = { true, false, false, false, true };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_NullValuesWithDefault() {
        // Test with null values and default value for null
        Boolean[] input = { null, null, null };
        boolean[] expected = { true, true, true };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_NullValuesWithFalseDefault() {
        // Test with null values and default value for null as false
        Boolean[] input = { null, null, null };
        boolean[] expected = { false, false, false };
        boolean[] result = ArrayUtils.toPrimitive(input, false);
        assertArrayEquals(expected, result);
    }
}

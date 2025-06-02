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

public class ArrayUtils_toPrimitive_354_1_Test {

    @Test
    public void testToPrimitive_NullArray() {
        Boolean[] input = null;
        boolean[] expected = null;
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        Boolean[] input = {};
        boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNulls() {
        Boolean[] input = { null, Boolean.TRUE, Boolean.FALSE };
        // default value for null is false
        boolean[] expected = { false, true, false };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithBooleans() {
        Boolean[] input = { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE };
        boolean[] expected = { true, false, true };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithAllNulls() {
        Boolean[] input = { null, null, null };
        // default value for null is false
        boolean[] expected = { false, false, false };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithCustomNullValue() {
        Boolean[] input = { null, Boolean.TRUE, Boolean.FALSE };
        // custom value for null is true
        boolean[] expected = { true, true, false };
        boolean[] result = ArrayUtils.toPrimitive(input, true);
        assertArrayEquals(expected, result);
    }
}

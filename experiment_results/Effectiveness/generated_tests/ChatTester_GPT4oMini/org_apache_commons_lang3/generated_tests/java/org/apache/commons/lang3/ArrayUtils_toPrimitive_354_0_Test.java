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
    public void testToPrimitiveWithNullArray() {
        Boolean[] input = null;
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[0], result);
    }

    @Test
    public void testToPrimitiveWithEmptyArray() {
        Boolean[] input = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[0], result);
    }

    @Test
    public void testToPrimitiveWithAllFalse() {
        Boolean[] input = { false, false, false };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[] { false, false, false }, result);
    }

    @Test
    public void testToPrimitiveWithAllTrue() {
        Boolean[] input = { true, true, true };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[] { true, true, true }, result);
    }

    @Test
    public void testToPrimitiveWithMixedValues() {
        Boolean[] input = { true, false, null, true };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[] { true, false, false, true }, result);
    }

    @Test
    public void testToPrimitiveWithAllNulls() {
        Boolean[] input = { null, null, null };
        boolean[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new boolean[] { false, false, false }, result);
    }
}

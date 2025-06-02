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

public class ArrayUtils_toPrimitive_356_1_Test {

    @Test
    public void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Byte[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.toPrimitive(new Byte[0]));
    }

    @Test
    public void testToPrimitive_ValidArray() {
        Byte[] input = { 1, 2, 3, null, 4 };
        // null will be converted to 0
        byte[] expected = { 1, 2, 3, 0, 4 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_AllNulls() {
        Byte[] input = { null, null, null };
        // all nulls will be converted to 0
        byte[] expected = { 0, 0, 0 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_MixedValues() {
        Byte[] input = { null, 2, null, 4 };
        // nulls become 0
        byte[] expected = { 0, 2, 0, 4 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }
}

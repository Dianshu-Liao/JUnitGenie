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

public class ArrayUtils_toPrimitive_356_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test with null input
        byte[] result = ArrayUtils.toPrimitive((Byte[]) null);
        assertNull(result, "Expected null for null input");
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        Byte[] input = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result, "Expected empty byte array for empty input");
    }

    @Test
    public void testToPrimitive_ValidArray() {
        // Test with a valid Byte array
        Byte[] input = { 1, 2, 3, null, 4 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new byte[] { 1, 2, 3, 0, 4 }, result, "Expected correct byte array conversion with null handled as 0");
    }

    @Test
    public void testToPrimitive_AllNulls() {
        // Test with an array of nulls
        Byte[] input = { null, null, null };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new byte[] { 0, 0, 0 }, result, "Expected byte array with all zeros for an array of nulls");
    }
}

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

class ArrayUtils_toPrimitive_356_4_Test {

    @Test
    void testToPrimitive_NullArray() {
        // Test with null array
        Byte[] input = null;
        byte[] result = ArrayUtils.toPrimitive(input);
        assertNull(result, "Expected null for null input array");
    }

    @Test
    void testToPrimitive_EmptyArray() {
        // Test with empty array
        Byte[] input = {};
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result, "Expected empty byte array for empty input array");
    }

    @Test
    void testToPrimitive_SingleElement() {
        // Test with a single element
        Byte[] input = { 1 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new byte[] { 1 }, result, "Expected single element byte array");
    }

    @Test
    void testToPrimitive_MultipleElements() {
        // Test with multiple elements
        Byte[] input = { 1, 2, 3 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new byte[] { 1, 2, 3 }, result, "Expected byte array with multiple elements");
    }

    @Test
    void testToPrimitive_NullElement() {
        // Test with null element in array
        Byte[] input = { 1, null, 3 };
        byte[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new byte[] { 1, 0, 3 }, result, "Expected byte array with null element converted to 0");
    }
}

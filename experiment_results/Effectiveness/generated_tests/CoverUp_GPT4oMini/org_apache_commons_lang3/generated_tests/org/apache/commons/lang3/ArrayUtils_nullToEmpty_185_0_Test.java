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

public class ArrayUtils_nullToEmpty_185_0_Test {

    @Test
    public void testNullToEmpty() {
        // Test case for null input
        Byte[] input = null;
        Byte[] expected = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        Byte[] result = invokeNullToEmpty(input);
        assertArrayEquals(expected, result);
        // Test case for empty array input
        input = new Byte[0];
        expected = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        result = invokeNullToEmpty(input);
        assertArrayEquals(expected, result);
        // Test case for non-empty array input
        input = new Byte[] { 1, 2, 3 };
        expected = new Byte[] { 1, 2, 3 };
        result = invokeNullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    private Byte[] invokeNullToEmpty(Byte[] array) {
        try {
            Method method = ArrayUtils.class.getDeclaredMethod("nullToEmpty", Byte[].class);
            method.setAccessible(true);
            return (Byte[]) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

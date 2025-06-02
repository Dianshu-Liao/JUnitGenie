package org.apache.commons.lang3;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
public class ArrayUtils_toPrimitive_358_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        // Test with null array
        assertNull(ArrayUtils.toPrimitive((Character[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        // Test with empty array
        char[] result = ArrayUtils.toPrimitive(new Character[] {});
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test
    public void testToPrimitive_ValidArray() {
        // Test with valid Character array
        Character[] input = new Character[] { 'a', 'b', 'c' };
        char[] expected = new char[] { 'a', 'b', 'c' };
        char[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToPrimitive_ArrayWithNullElements() {
        // Test with Character array containing null elements
        Character[] input = new Character[] { 'a', null, 'c' };
        char[] result = ArrayUtils.toPrimitive(input);
        assertEquals('a', result[0]);
        assertThrows(NullPointerException.class, () -> {
            // This will throw NullPointerException
            char value = result[1];
        });
        assertEquals('c', result[2]);
    }
}

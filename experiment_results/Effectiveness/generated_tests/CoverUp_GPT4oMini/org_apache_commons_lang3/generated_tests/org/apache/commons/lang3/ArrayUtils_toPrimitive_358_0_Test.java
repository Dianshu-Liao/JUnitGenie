package org.apache.commons.lang3;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ArrayUtils_toPrimitive_358_0_Test {

    @Test
    public void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Character[]) null));
    }

    @Test
    public void testToPrimitive_EmptyArray() {
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0]));
    }

    @Test
    public void testToPrimitive_SingleElementArray() {
        Character[] input = { 'a' };
        char[] expected = { 'a' };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    public void testToPrimitive_MultipleElementsArray() {
        Character[] input = { 'a', 'b', 'c' };
        char[] expected = { 'a', 'b', 'c' };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    public void testToPrimitive_ArrayWithNullElements() {
        Character[] input = { 'a', null, 'c' };
        // null character is represented as '\u0000'
        char[] expected = { 'a', '\u0000', 'c' };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }
}

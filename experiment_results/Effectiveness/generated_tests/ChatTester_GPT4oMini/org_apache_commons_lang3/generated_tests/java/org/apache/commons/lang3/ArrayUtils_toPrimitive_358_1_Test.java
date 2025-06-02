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

class ArrayUtils_toPrimitive_358_1_Test {

    @Test
    void testToPrimitive_NullArray() {
        Character[] input = null;
        char[] result = ArrayUtils.toPrimitive(input);
        assertNull(result);
    }

    @Test
    void testToPrimitive_EmptyArray() {
        Character[] input = {};
        char[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test
    void testToPrimitive_SingleElement() {
        Character[] input = { 'a' };
        char[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new char[] { 'a' }, result);
    }

    @Test
    void testToPrimitive_MultipleElements() {
        Character[] input = { 'a', 'b', 'c' };
        char[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new char[] { 'a', 'b', 'c' }, result);
    }

    @Test
    void testToPrimitive_ContainsNull() {
        Character[] input = { 'a', null, 'c' };
        char[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(new char[] { 'a', '\u0000', 'c' }, result);
    }
}

package org.apache.commons.lang3;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtils_toPrimitive_369_0_Test {

    @Test
    void testToPrimitive_NullArray() {
        assertNull(ArrayUtils.toPrimitive((Short[]) null));
    }

    @Test
    void testToPrimitive_EmptyArray() {
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.toPrimitive(new Short[] {}));
    }

    @Test
    void testToPrimitive_SingleElementArray() {
        Short[] input = { 1 };
        short[] expected = { 1 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    void testToPrimitive_MultipleElementArray() {
        Short[] input = { 1, 2, 3, 4, 5 };
        short[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }

    @Test
    void testToPrimitive_ArrayWithNullElements() {
        Short[] input = { 1, null, 3 };
        // null should be converted to 0
        short[] expected = { 1, 0, 3 };
        assertArrayEquals(expected, ArrayUtils.toPrimitive(input));
    }
}

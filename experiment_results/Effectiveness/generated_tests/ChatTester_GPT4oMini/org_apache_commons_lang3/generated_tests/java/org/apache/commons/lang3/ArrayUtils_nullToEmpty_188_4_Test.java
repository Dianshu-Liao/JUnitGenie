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

public class ArrayUtils_nullToEmpty_188_4_Test {

    @Test
    public void testNullToEmpty_withNullArray() {
        // Given a null array
        Class<?>[] input = null;
        // When calling nullToEmpty
        Class<?>[] result = ArrayUtils.nullToEmpty(input);
        // Then the result should be an empty Class array
        assertArrayEquals(ArrayUtils.EMPTY_CLASS_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_withEmptyArray() {
        // Given an empty array
        Class<?>[] input = new Class<?>[0];
        // When calling nullToEmpty
        Class<?>[] result = ArrayUtils.nullToEmpty(input);
        // Then the result should be the same empty Class array
        assertArrayEquals(input, result);
    }

    @Test
    public void testNullToEmpty_withNonEmptyArray() {
        // Given a non-empty array
        Class<?>[] input = { String.class, Integer.class };
        // When calling nullToEmpty
        Class<?>[] result = ArrayUtils.nullToEmpty(input);
        // Then the result should be the same non-empty Class array
        assertArrayEquals(input, result);
    }
}

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

public class ArrayUtils_nullToEmpty_188_1_Test {

    @Test
    public void testNullToEmpty_withNullArray() {
        // Given
        Class<?>[] inputArray = null;
        // When
        Class<?>[] result = ArrayUtils.nullToEmpty(inputArray);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_CLASS_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_withEmptyArray() {
        // Given
        Class<?>[] inputArray = new Class<?>[0];
        // When
        Class<?>[] result = ArrayUtils.nullToEmpty(inputArray);
        // Then
        assertArrayEquals(inputArray, result);
    }

    @Test
    public void testNullToEmpty_withNonEmptyArray() {
        // Given
        Class<?>[] inputArray = { String.class, Integer.class };
        // When
        Class<?>[] result = ArrayUtils.nullToEmpty(inputArray);
        // Then
        assertArrayEquals(inputArray, result);
    }
}

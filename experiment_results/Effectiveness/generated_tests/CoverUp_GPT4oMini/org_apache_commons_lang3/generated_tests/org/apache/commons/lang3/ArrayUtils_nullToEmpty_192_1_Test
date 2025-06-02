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

public class ArrayUtils_nullToEmpty_192_1_Test {

    @Test
    public void testNullToEmpty_WithNullArray() {
        // Given
        Float[] input = null;
        // When
        Float[] result = ArrayUtils.nullToEmpty(input);
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_WithEmptyArray() {
        // Given
        Float[] input = new Float[0];
        // When
        Float[] result = ArrayUtils.nullToEmpty(input);
        // Then
        assertArrayEquals(new Float[0], result);
    }

    @Test
    public void testNullToEmpty_WithNonEmptyArray() {
        // Given
        Float[] input = new Float[] { 1.0f, 2.0f, 3.0f };
        // When
        Float[] result = ArrayUtils.nullToEmpty(input);
        // Then
        assertArrayEquals(input, result);
    }
}

package org.apache.commons.lang3;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
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

public class ArrayUtils_nullToEmpty_197_2_Test {

    @Test
    public void testNullToEmpty_withNullArray() {
        Object[] result = ArrayUtils.nullToEmpty((Object[]) null);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_withEmptyArray() {
        Object[] result = ArrayUtils.nullToEmpty(new Object[0]);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_withNonEmptyArray() {
        Object[] inputArray = new Object[] { "element1", "element2" };
        Object[] result = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(inputArray, result);
    }

    @Test
    public void testNullToEmpty_withEmptyStringArray() {
        Object[] result = ArrayUtils.nullToEmpty((Object[]) new String[0]);
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmpty_withMixedTypeArray() {
        Object[] inputArray = new Object[] { 1, "string", null };
        Object[] result = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(inputArray, result);
    }

    @Test
    public void testNullToEmpty_withSingleElementArray() {
        Object[] inputArray = new Object[] { "singleElement" };
        Object[] result = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(inputArray, result);
    }
}

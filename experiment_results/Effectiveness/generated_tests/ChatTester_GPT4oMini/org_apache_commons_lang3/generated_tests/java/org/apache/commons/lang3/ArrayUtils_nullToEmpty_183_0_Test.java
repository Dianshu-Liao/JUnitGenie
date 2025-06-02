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

public class ArrayUtils_nullToEmpty_183_0_Test {

    @Test
    public void testNullToEmpty_withNullArray() {
        Boolean[] input = null;
        Boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        Boolean[] actual = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNullToEmpty_withEmptyArray() {
        Boolean[] input = {};
        Boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        Boolean[] actual = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNullToEmpty_withNonEmptyArray() {
        Boolean[] input = { true, false, null };
        Boolean[] expected = { true, false, null };
        Boolean[] actual = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, actual);
    }
}

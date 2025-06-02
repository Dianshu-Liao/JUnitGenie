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

public class ArrayUtils_nullToEmpty_194_0_Test {

    @Test
    public void testNullToEmpty() {
        // Test case 1: Input is null
        Integer[] input1 = null;
        Integer[] expected1 = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        Integer[] result1 = ArrayUtils.nullToEmpty(input1);
        assertArrayEquals(expected1, result1);
        // Test case 2: Input is an empty array
        Integer[] input2 = {};
        Integer[] expected2 = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        Integer[] result2 = ArrayUtils.nullToEmpty(input2);
        assertArrayEquals(expected2, result2);
        // Test case 3: Input is a non-empty array
        Integer[] input3 = { 1, 2, 3 };
        Integer[] expected3 = { 1, 2, 3 };
        Integer[] result3 = ArrayUtils.nullToEmpty(input3);
        assertArrayEquals(expected3, result3);
    }
}

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

public class ArrayUtils_nullToEmpty_185_1_Test {

    @Test
    public void testNullToEmpty() {
        // Test case 1: Input is null
        Byte[] input = null;
        Byte[] expected = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        assertArrayEquals(expected, ArrayUtils.nullToEmpty(input));
        // Test case 2: Input is an empty array
        input = new Byte[0];
        expected = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        assertArrayEquals(expected, ArrayUtils.nullToEmpty(input));
        // Test case 3: Input is a non-empty array
        input = new Byte[] { 1, 2, 3 };
        expected = new Byte[] { 1, 2, 3 };
        assertArrayEquals(expected, ArrayUtils.nullToEmpty(input));
    }
}

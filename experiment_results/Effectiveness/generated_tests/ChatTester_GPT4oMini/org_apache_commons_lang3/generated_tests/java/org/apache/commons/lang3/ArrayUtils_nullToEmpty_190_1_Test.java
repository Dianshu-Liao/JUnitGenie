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

public class ArrayUtils_nullToEmpty_190_1_Test {

    @Test
    public void testNullToEmpty() {
        // Fixing the ambiguous reference by explicitly specifying the type
        Short[] result = ArrayUtils.nullToEmpty((Short[]) null);
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result);
        // Test with empty array input
        result = ArrayUtils.nullToEmpty(new Short[] {});
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result);
        // Test with non-empty array input
        Short[] input = { 1, 2, 3 };
        result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(input, result);
    }
}

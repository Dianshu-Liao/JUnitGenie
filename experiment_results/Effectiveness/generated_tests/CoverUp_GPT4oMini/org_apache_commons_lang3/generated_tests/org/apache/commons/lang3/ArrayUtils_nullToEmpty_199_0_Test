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

public class ArrayUtils_nullToEmpty_199_0_Test {

    @Test
    public void testNullToEmpty() throws Exception {
        // Test with null input
        Short[] result = invokeNullToEmpty(null);
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmptyWithEmptyArray() throws Exception {
        // Test with an empty Short array
        Short[] result = invokeNullToEmpty(new Short[0]);
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmptyWithNonEmptyArray() throws Exception {
        // Test with a non-empty Short array
        Short[] input = new Short[] { 1, 2, 3 };
        Short[] result = invokeNullToEmpty(input);
        assertArrayEquals(input, result);
    }

    private Short[] invokeNullToEmpty(Short[] array) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("nullToEmpty", Short[].class);
        method.setAccessible(true);
        return (Short[]) method.invoke(null, (Object) array);
    }
}

// Test method
package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class ArrayUtils_nullToEmpty_187_0_Test {

    @Test
    public void testNullToEmptyWithNullArray() throws Exception {
        // Fixed: Changed the expected type to match the method's return type
        Character[] result = ArrayUtils.nullToEmpty((Character[]) null);
        assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, result);
    }

    @Test
    public void testNullToEmptyWithNonNullArray() throws Exception {
        Character[] input = { 'a', 'b', 'c' };
        Character[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(input, result);
    }

    @Test
    public void testNullToEmptyWithEmptyArray() throws Exception {
        Character[] input = {};
        Character[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(input, result);
    }

    // Reflection test to invoke private methods if needed
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}

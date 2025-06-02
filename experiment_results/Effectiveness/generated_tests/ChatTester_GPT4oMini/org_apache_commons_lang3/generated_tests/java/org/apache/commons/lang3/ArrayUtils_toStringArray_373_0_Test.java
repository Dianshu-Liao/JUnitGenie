package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class ArrayUtils_toStringArray_373_0_Test {

    @Test
    public void testToStringArrayWithNullArray() throws Exception {
        Object[] input = null;
        String[] result = invokeToStringArray(input);
        assertArrayEquals(new String[] { "null" }, result);
    }

    @Test
    public void testToStringArrayWithEmptyArray() throws Exception {
        Object[] input = {};
        String[] result = invokeToStringArray(input);
        assertArrayEquals(new String[] { "null" }, result);
    }

    @Test
    public void testToStringArrayWithNonEmptyArray() throws Exception {
        Object[] input = { "test", null, 123, new Object() };
        String[] result = invokeToStringArray(input);
        assertArrayEquals(new String[] { "test", "null", "123", "java.lang.Object@*" }, result);
    }

    @Test
    public void testToStringArrayWithMixedTypes() throws Exception {
        Object[] input = { "string", 42, null, new int[] { 1, 2, 3 } };
        String[] result = invokeToStringArray(input);
        assertArrayEquals(new String[] { "string", "42", "null", "int[3]" }, result);
    }

    private String[] invokeToStringArray(Object[] array) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("toStringArray", Object[].class);
        method.setAccessible(true);
        return (String[]) method.invoke(null, (Object) array);
    }
}

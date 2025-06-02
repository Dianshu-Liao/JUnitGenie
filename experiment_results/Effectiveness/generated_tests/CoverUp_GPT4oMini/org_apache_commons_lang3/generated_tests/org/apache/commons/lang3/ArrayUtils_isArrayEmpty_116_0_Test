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

public class ArrayUtils_isArrayEmpty_116_0_Test {

    @Test
    public void testIsArrayEmpty_WithNullArray() throws Exception {
        // Invoke private method isArrayEmpty with null
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, (Object) null);
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyArray() throws Exception {
        // Invoke private method isArrayEmpty with an empty array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new int[] {} });
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyArray() throws Exception {
        // Invoke private method isArrayEmpty with a non-empty array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new int[] { 1 } });
        assertFalse(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyObjectArray() throws Exception {
        // Invoke private method isArrayEmpty with an empty Object array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new Object[] {} });
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyObjectArray() throws Exception {
        // Invoke private method isArrayEmpty with a non-empty Object array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new Object[] { "test" } });
        assertFalse(result);
    }

    @Test
    public void testIsArrayEmpty_WithEmptyStringArray() throws Exception {
        // Invoke private method isArrayEmpty with an empty String array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new String[] {} });
        assertTrue(result);
    }

    @Test
    public void testIsArrayEmpty_WithNonEmptyStringArray() throws Exception {
        // Invoke private method isArrayEmpty with a non-empty String array
        Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, new Object[] { new String[] { "hello" } });
        assertFalse(result);
    }
}

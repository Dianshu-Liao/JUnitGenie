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

public class ArrayUtils_toStringArray_373_0_Test {

    @Test
    public void testToStringArray_NullArray() {
        // Test with null input
        String[] result = ArrayUtils.toStringArray(null);
        assertNull(result);
    }

    @Test
    public void testToStringArray_EmptyArray() {
        // Test with empty array
        String[] result = ArrayUtils.toStringArray(new Object[] {});
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test
    public void testToStringArray_SingleElement() {
        // Test with single element array
        String[] result = ArrayUtils.toStringArray(new Object[] { "test" });
        assertArrayEquals(new String[] { "test" }, result);
    }

    @Test
    public void testToStringArray_MultipleElements() {
        // Test with multiple elements
        String[] result = ArrayUtils.toStringArray(new Object[] { "test", 1, null });
        assertArrayEquals(new String[] { "test", "1", "null" }, result);
    }

    @Test
    public void testToStringArray_NullElement() {
        // Test with an array containing a null element
        String[] result = ArrayUtils.toStringArray(new Object[] { null, "hello" });
        assertArrayEquals(new String[] { "null", "hello" }, result);
    }

    @Test
    public void testToStringArray_NumericElement() {
        // Test with an array containing numeric elements
        String[] result = ArrayUtils.toStringArray(new Object[] { 123, 456.78 });
        assertArrayEquals(new String[] { "123", "456.78" }, result);
    }

    @Test
    public void testToStringArray_BooleanElement() {
        // Test with an array containing boolean elements
        String[] result = ArrayUtils.toStringArray(new Object[] { true, false });
        assertArrayEquals(new String[] { "true", "false" }, result);
    }
}

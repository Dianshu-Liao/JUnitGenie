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

public class ArrayUtils_toStringArray_374_0_Test {

    @Test
    public void testToStringArray_NullArray() {
        String[] result = ArrayUtils.toStringArray(null, "null");
        assertNull(result);
    }

    @Test
    public void testToStringArray_EmptyArray() {
        String[] result = ArrayUtils.toStringArray(new Object[0], "null");
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test
    public void testToStringArray_ArrayWithNullElements() {
        Object[] input = { null, "test", null };
        String[] result = ArrayUtils.toStringArray(input, "null");
        assertArrayEquals(new String[] { "null", "test", "null" }, result);
    }

    @Test
    public void testToStringArray_ArrayWithNonNullElements() {
        Object[] input = { "hello", "world", 123 };
        String[] result = ArrayUtils.toStringArray(input, "null");
        assertArrayEquals(new String[] { "hello", "world", "123" }, result);
    }

    @Test
    public void testToStringArray_ArrayWithMixedElements() {
        Object[] input = { 1, null, "string", new Object() };
        String[] result = ArrayUtils.toStringArray(input, "null");
        assertArrayEquals(new String[] { "1", "null", "string", "java.lang.Object@<hashcode>" }, result);
    }

    @Test
    public void testToStringArray_ArrayWithCustomObject() throws Exception {
        Object[] input = { new CustomObject("test"), null };
        String[] result = ArrayUtils.toStringArray(input, "null");
        assertArrayEquals(new String[] { "CustomObject{name='test'}", "null" }, result);
    }

    private static class CustomObject {

        private final String name;

        CustomObject(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "CustomObject{name='" + name + "'}";
        }
    }
}

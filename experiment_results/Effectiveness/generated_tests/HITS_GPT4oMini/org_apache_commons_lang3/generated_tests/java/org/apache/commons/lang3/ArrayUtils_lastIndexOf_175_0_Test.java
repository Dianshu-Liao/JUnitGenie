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

public class ArrayUtils_lastIndexOf_175_0_Test {

    @Test
    public void testLastIndexOf_NullArray() {
        Object[] array = null;
        int result = ArrayUtils.lastIndexOf(array, "test", 0);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_NegativeStartIndex() {
        Object[] array = { "test", "example" };
        int result = ArrayUtils.lastIndexOf(array, "test", -1);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_StartIndexOutOfBounds() {
        Object[] array = { "test", "example" };
        int result = ArrayUtils.lastIndexOf(array, "test", 5);
        // Should return the last index of "test"
        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_ObjectFound() {
        Object[] array = { "test", "example", "test" };
        int result = ArrayUtils.lastIndexOf(array, "test", 2);
        assertEquals(2, result);
    }

    @Test
    public void testLastIndexOf_ObjectNotFound() {
        Object[] array = { "test", "example", "sample" };
        int result = ArrayUtils.lastIndexOf(array, "notfound", 2);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_NullObjectInArray() {
        Object[] array = { "test", null, "example" };
        int result = ArrayUtils.lastIndexOf(array, null, 2);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_NullObjectToFind() {
        Object[] array = { "test", "example", null };
        int result = ArrayUtils.lastIndexOf(array, null, 2);
        assertEquals(2, result);
    }

    @Test
    public void testLastIndexOf_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        int result = ArrayUtils.lastIndexOf(array, "test", 0);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptyArrayWithNegativeStart() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        int result = ArrayUtils.lastIndexOf(array, "test", -1);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }
}

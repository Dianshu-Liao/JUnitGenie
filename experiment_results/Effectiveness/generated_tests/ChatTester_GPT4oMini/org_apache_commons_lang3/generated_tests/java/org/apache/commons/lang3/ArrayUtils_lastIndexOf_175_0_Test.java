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
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.lastIndexOf(null, "test", 0));
    }

    @Test
    public void testLastIndexOf_NegativeStartIndex() {
        String[] array = { "a", "b", "c" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.lastIndexOf(array, "b", -1));
    }

    @Test
    public void testLastIndexOf_StartIndexOutOfBounds() {
        String[] array = { "a", "b", "c" };
        assertEquals(2, ArrayUtils.lastIndexOf(array, "c", 5));
    }

    @Test
    public void testLastIndexOf_ObjectFound() {
        String[] array = { "a", "b", "c", "b" };
        assertEquals(3, ArrayUtils.lastIndexOf(array, "b", 3));
    }

    @Test
    public void testLastIndexOf_ObjectNotFound() {
        String[] array = { "a", "b", "c" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.lastIndexOf(array, "d", 2));
    }

    @Test
    public void testLastIndexOf_NullObjectFound() {
        String[] array = { "a", null, "c", null };
        assertEquals(3, ArrayUtils.lastIndexOf(array, null, 3));
    }

    @Test
    public void testLastIndexOf_NullObjectNotFound() {
        String[] array = { "a", "b", "c" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.lastIndexOf(array, null, 2));
    }

    @Test
    public void testLastIndexOf_MixedObjectTypes() {
        Object[] array = { "a", 1, "b", 2 };
        assertEquals(2, ArrayUtils.lastIndexOf(array, "b", 3));
    }

    @Test
    public void testLastIndexOf_ObjectToFindIsNullWithMixedTypes() {
        Object[] array = { 1, "test", null, "sample", null };
        assertEquals(4, ArrayUtils.lastIndexOf(array, null, 4));
    }

    @Test
    public void testLastIndexOf_ObjectToFindIsNullWithNoNulls() {
        Object[] array = { 1, "test", "sample" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.lastIndexOf(array, null, 2));
    }
}

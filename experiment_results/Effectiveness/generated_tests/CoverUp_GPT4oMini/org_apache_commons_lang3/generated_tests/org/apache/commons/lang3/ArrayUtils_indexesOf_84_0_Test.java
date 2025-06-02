package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import java.util.BitSet;
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

public class ArrayUtils_indexesOf_84_0_Test {

    @Test
    public void testIndexesOf_NullArray() {
        BitSet result = ArrayUtils.indexesOf(null, "test", 0);
        assertEquals(new BitSet(), result);
    }

    @Test
    public void testIndexesOf_EmptyArray() {
        BitSet result = ArrayUtils.indexesOf(new Object[] {}, "test", 0);
        assertEquals(new BitSet(), result);
    }

    @Test
    public void testIndexesOf_ObjectFound() {
        Object[] array = { "test", "example", "test" };
        BitSet result = ArrayUtils.indexesOf(array, "test", 0);
        BitSet expected = new BitSet();
        expected.set(0);
        expected.set(2);
        assertEquals(expected, result);
    }

    @Test
    public void testIndexesOf_ObjectNotFound() {
        Object[] array = { "example", "sample", "test" };
        BitSet result = ArrayUtils.indexesOf(array, "notfound", 0);
        assertEquals(new BitSet(), result);
    }

    @Test
    public void testIndexesOf_StartIndexOutOfBounds() {
        Object[] array = { "test", "example", "test" };
        BitSet result = ArrayUtils.indexesOf(array, "test", 5);
        assertEquals(new BitSet(), result);
    }

    @Test
    public void testIndexesOf_NullObjectToFind() {
        Object[] array = { "test", null, "example", null };
        BitSet result = ArrayUtils.indexesOf(array, null, 0);
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(3);
        assertEquals(expected, result);
    }

    @Test
    public void testIndexesOf_SequentialCalls() {
        Object[] array = { "test", "example", "test", "example" };
        BitSet result1 = ArrayUtils.indexesOf(array, "test", 0);
        BitSet result2 = ArrayUtils.indexesOf(array, "example", 0);
        BitSet expected1 = new BitSet();
        expected1.set(0);
        expected1.set(2);
        BitSet expected2 = new BitSet();
        expected2.set(1);
        expected2.set(3);
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }
}

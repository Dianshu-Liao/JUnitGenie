package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.BitSet;
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
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testIndexesOf_EmptyArray() {
        BitSet result = ArrayUtils.indexesOf(new Object[] {}, "test", 0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testIndexesOf_NoMatch() {
        Object[] array = { "one", "two", "three" };
        BitSet result = ArrayUtils.indexesOf(array, "four", 0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testIndexesOf_SingleMatch() {
        Object[] array = { "one", "two", "three", "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two", 0);
        assertNotNull(result);
        assertEquals(1, result.cardinality());
        assertTrue(result.get(1));
    }

    @Test
    public void testIndexesOf_MultipleMatches() {
        Object[] array = { "one", "two", "three", "two", "four", "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two", 0);
        assertNotNull(result);
        assertEquals(3, result.cardinality());
        assertTrue(result.get(1));
        assertTrue(result.get(3));
        assertTrue(result.get(5));
    }

    @Test
    public void testIndexesOf_StartIndex() {
        Object[] array = { "one", "two", "three", "two", "four", "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two", 2);
        assertNotNull(result);
        assertEquals(2, result.cardinality());
        assertFalse(result.get(1));
        assertTrue(result.get(3));
        assertTrue(result.get(5));
    }

    @Test
    public void testIndexesOf_StartIndexOutOfBounds() {
        Object[] array = { "one", "two", "three" };
        BitSet result = ArrayUtils.indexesOf(array, "one", 5);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}

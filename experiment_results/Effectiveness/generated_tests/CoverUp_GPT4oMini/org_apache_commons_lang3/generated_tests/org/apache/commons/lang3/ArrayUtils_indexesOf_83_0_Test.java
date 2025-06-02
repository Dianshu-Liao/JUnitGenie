package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

public class ArrayUtils_indexesOf_83_0_Test {

    @Test
    public void testIndexesOf_WithNullArray() {
        BitSet result = ArrayUtils.indexesOf(null, "test");
        assertTrue(result.isEmpty(), "Expected empty BitSet for null array");
    }

    @Test
    public void testIndexesOf_WithEmptyArray() {
        BitSet result = ArrayUtils.indexesOf(new Object[] {}, "test");
        assertTrue(result.isEmpty(), "Expected empty BitSet for empty array");
    }

    @Test
    public void testIndexesOf_WithNoMatches() {
        Object[] array = { "one", "two", "three" };
        BitSet result = ArrayUtils.indexesOf(array, "four");
        assertTrue(result.isEmpty(), "Expected empty BitSet when there are no matches");
    }

    @Test
    public void testIndexesOf_WithSingleMatch() {
        Object[] array = { "one", "two", "three", "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two");
        assertEquals(2, result.cardinality(), "Expected 2 matches for 'two'");
        assertTrue(result.get(1), "Expected match at index 1");
        assertTrue(result.get(3), "Expected match at index 3");
    }

    @Test
    public void testIndexesOf_WithMultipleMatches() {
        Object[] array = { "one", "two", "two", "three", "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two");
        assertEquals(3, result.cardinality(), "Expected 3 matches for 'two'");
        assertTrue(result.get(1), "Expected match at index 1");
        assertTrue(result.get(2), "Expected match at index 2");
        assertTrue(result.get(4), "Expected match at index 4");
    }

    @Test
    public void testIndexesOf_WithNullObjectToFind() {
        Object[] array = { "one", null, "three", null };
        BitSet result = ArrayUtils.indexesOf(array, null);
        assertEquals(2, result.cardinality(), "Expected 2 matches for null");
        assertTrue(result.get(1), "Expected match at index 1");
        assertTrue(result.get(3), "Expected match at index 3");
    }

    @Test
    public void testIndexesOf_WithDifferentObjectTypes() {
        Object[] array = { 1, "two", 3.0, "two" };
        BitSet result = ArrayUtils.indexesOf(array, "two");
        assertEquals(2, result.cardinality(), "Expected 2 matches for 'two'");
        assertTrue(result.get(1), "Expected match at index 1");
        assertTrue(result.get(3), "Expected match at index 3");
    }
}

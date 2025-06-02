package org.apache.commons.lang3;

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

public class ArrayUtils_indexesOf_83_0_Test {

    @Test
    public void testIndexesOf_NullArray() {
        BitSet result = ArrayUtils.indexesOf(null, "test");
        assertEquals(0, result.cardinality(), "Expected empty BitSet for null array");
    }

    @Test
    public void testIndexesOf_EmptyArray() {
        BitSet result = ArrayUtils.indexesOf(new Object[] {}, "test");
        assertEquals(0, result.cardinality(), "Expected empty BitSet for empty array");
    }

    @Test
    public void testIndexesOf_NoMatch() {
        Object[] array = { "apple", "banana", "cherry" };
        BitSet result = ArrayUtils.indexesOf(array, "orange");
        assertEquals(0, result.cardinality(), "Expected empty BitSet for no matches");
    }

    @Test
    public void testIndexesOf_SingleMatch() {
        Object[] array = { "apple", "banana", "cherry", "banana" };
        BitSet result = ArrayUtils.indexesOf(array, "banana");
        assertEquals(2, result.cardinality(), "Expected BitSet to contain index of the match");
        assertEquals(true, result.get(1), "Expected index 1 to be set");
        assertEquals(true, result.get(3), "Expected index 3 to be set");
    }

    @Test
    public void testIndexesOf_MultipleMatches() {
        Object[] array = { "test", "test", "test", "example" };
        BitSet result = ArrayUtils.indexesOf(array, "test");
        assertEquals(3, result.cardinality(), "Expected BitSet to contain multiple matches");
        assertEquals(true, result.get(0), "Expected index 0 to be set");
        assertEquals(true, result.get(1), "Expected index 1 to be set");
        assertEquals(true, result.get(2), "Expected index 2 to be set");
    }

    @Test
    public void testIndexesOf_MatchingNulls() {
        Object[] array = { null, "test", null, "example" };
        BitSet result = ArrayUtils.indexesOf(array, null);
        assertEquals(2, result.cardinality(), "Expected BitSet to contain indices of null matches");
        assertEquals(true, result.get(0), "Expected index 0 to be set");
        assertEquals(true, result.get(2), "Expected index 2 to be set");
    }
}

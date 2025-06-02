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

public class ArrayUtils_indexesOf_83_0_Test {

    @Test
    public void testIndexesOf_WithNullArray() {
        BitSet result = ArrayUtils.indexesOf(null, "test");
        assertEquals(0, result.length());
    }

    @Test
    public void testIndexesOf_WithEmptyArray() {
        BitSet result = ArrayUtils.indexesOf(new Object[] {}, "test");
        assertEquals(0, result.length());
    }

    @Test
    public void testIndexesOf_WithObjectNotFound() {
        Object[] array = { "a", "b", "c" };
        BitSet result = ArrayUtils.indexesOf(array, "d");
        assertEquals(0, result.length());
    }

    @Test
    public void testIndexesOf_WithObjectFoundOnce() {
        Object[] array = { "a", "b", "c", "b" };
        BitSet result = ArrayUtils.indexesOf(array, "c");
        assertEquals(1, result.length());
        assertEquals(2, result.nextSetBit(0));
    }

    @Test
    public void testIndexesOf_WithObjectFoundMultipleTimes() {
        Object[] array = { "a", "b", "c", "b" };
        BitSet result = ArrayUtils.indexesOf(array, "b");
        assertEquals(2, result.length());
        assertEquals(1, result.nextSetBit(0));
        assertEquals(3, result.nextSetBit(2));
    }

    @Test
    public void testIndexesOf_WithNullObjectToFind() {
        Object[] array = { "a", null, "c", null };
        BitSet result = ArrayUtils.indexesOf(array, null);
        assertEquals(2, result.length());
        assertEquals(1, result.nextSetBit(0));
        assertEquals(3, result.nextSetBit(2));
    }

    // Reflection method to test private method if it exists
    private BitSet invokePrivateIndexesOf(Object[] array, Object objectToFind, int startIndex) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("indexesOf", Object[].class, Object.class, int.class);
        method.setAccessible(true);
        return (BitSet) method.invoke(null, array, objectToFind, startIndex);
    }

    @Test
    public void testIndexesOf_WithPrivateMethod() throws Exception {
        Object[] array = { "x", "y", "z", "x" };
        BitSet result = invokePrivateIndexesOf(array, "x", 0);
        assertEquals(2, result.length());
        assertEquals(0, result.nextSetBit(0));
        assertEquals(3, result.nextSetBit(1));
    }
}

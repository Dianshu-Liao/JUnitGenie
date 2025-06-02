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

public class ArrayUtils_lastIndexOf_174_0_Test {

    @Test
    public void testLastIndexOf_WithNullArray() {
        int result = ArrayUtils.lastIndexOf(null, "test");
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_WithEmptyArray() {
        int result = ArrayUtils.lastIndexOf(ArrayUtils.EMPTY_OBJECT_ARRAY, "test");
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_WithElementNotFound() {
        Object[] array = { "a", "b", "c" };
        int result = ArrayUtils.lastIndexOf(array, "d");
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_WithElementFoundAtEnd() {
        Object[] array = { "a", "b", "c", "d" };
        int result = ArrayUtils.lastIndexOf(array, "d");
        assertEquals(3, result);
    }

    @Test
    public void testLastIndexOf_WithElementFoundAtBeginning() {
        Object[] array = { "a", "b", "c", "a" };
        int result = ArrayUtils.lastIndexOf(array, "a");
        assertEquals(3, result);
    }

    @Test
    public void testLastIndexOf_WithMultipleOccurrences() {
        Object[] array = { "a", "b", "c", "a", "b" };
        int result = ArrayUtils.lastIndexOf(array, "b");
        assertEquals(4, result);
    }

    @Test
    public void testLastIndexOf_WithNullElement() {
        Object[] array = { null, "b", null };
        int result = ArrayUtils.lastIndexOf(array, null);
        assertEquals(2, result);
    }
}

package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

public class ArrayUtils_contains_57_0_Test {

    @Test
    public void testContains_ObjectArrayContainsElement() {
        Object[] array = { "apple", "banana", "cherry" };
        assertTrue(ArrayUtils.contains(array, "banana"));
    }

    @Test
    public void testContains_ObjectArrayDoesNotContainElement() {
        Object[] array = { "apple", "banana", "cherry" };
        assertFalse(ArrayUtils.contains(array, "date"));
    }

    @Test
    public void testContains_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        assertFalse(ArrayUtils.contains(array, "anyObject"));
    }

    @Test
    public void testContains_NullArray() {
        Object[] array = null;
        assertFalse(ArrayUtils.contains(array, "anyObject"));
    }

    @Test
    public void testContains_NullObjectToFind() {
        Object[] array = { "apple", "banana", "cherry" };
        assertTrue(ArrayUtils.contains(array, null));
    }

    @Test
    public void testContains_ObjectArrayContainsNullElement() {
        Object[] array = { null, "banana", "cherry" };
        assertTrue(ArrayUtils.contains(array, null));
    }

    @Test
    public void testContains_SingleElementArrayContainsElement() {
        Object[] array = { "apple" };
        assertTrue(ArrayUtils.contains(array, "apple"));
    }

    @Test
    public void testContains_SingleElementArrayDoesNotContainElement() {
        Object[] array = { "apple" };
        assertFalse(ArrayUtils.contains(array, "banana"));
    }

    @Test
    public void testContains_SingleElementArrayContainsNull() {
        Object[] array = { null };
        assertTrue(ArrayUtils.contains(array, null));
    }

    @Test
    public void testContains_SingleElementArrayDoesNotContainNull() {
        Object[] array = { "apple" };
        assertFalse(ArrayUtils.contains(array, null));
    }
}

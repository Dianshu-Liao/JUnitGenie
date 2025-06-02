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

public class ArrayUtils_contains_57_0_Test {

    @Test
    public void testContains_WithNullArray_ReturnsFalse() {
        Object[] array = null;
        Object objectToFind = new Object();
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithEmptyArray_ReturnsFalse() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        Object objectToFind = new Object();
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithSingleElementArray_ContainingElement_ReturnsTrue() {
        Object[] array = new Object[] { "test" };
        Object objectToFind = "test";
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithSingleElementArray_NotContainingElement_ReturnsFalse() {
        Object[] array = new Object[] { "test" };
        Object objectToFind = "not found";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithMultipleElementsArray_ContainingElement_ReturnsTrue() {
        Object[] array = new Object[] { "first", "second", "third" };
        Object objectToFind = "second";
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithMultipleElementsArray_NotContainingElement_ReturnsFalse() {
        Object[] array = new Object[] { "first", "second", "third" };
        Object objectToFind = "fourth";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithNullElement_InArray_ReturnsTrue() {
        Object[] array = new Object[] { "first", null, "third" };
        Object objectToFind = null;
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_WithNullElement_NotInArray_ReturnsFalse() {
        Object[] array = new Object[] { "first", "second", "third" };
        Object objectToFind = null;
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }
}

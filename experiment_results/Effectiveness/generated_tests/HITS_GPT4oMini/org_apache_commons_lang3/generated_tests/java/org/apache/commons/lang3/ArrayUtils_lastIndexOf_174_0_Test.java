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
    public void testLastIndexOf_withNullArray() {
        Object[] array = null;
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_withEmptyArray() {
        Object[] array = {};
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_withSingleElementArray_elementFound() {
        Object[] array = { new Object() };
        Object objectToFind = array[0];
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_withSingleElementArray_elementNotFound() {
        Object[] array = { new Object() };
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_withMultipleElements_arrayContainsObject() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_withMultipleElements_objectNotFound() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_withMultipleElements_objectFoundAtLastIndex() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[2];
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(2, result);
    }

    @Test
    public void testLastIndexOf_withNullObjectToFind() {
        Object[] array = { null, new Object(), null };
        int result = ArrayUtils.lastIndexOf(array, null);
        assertEquals(2, result);
    }

    @Test
    public void testLastIndexOf_withStartIndexOutOfBounds() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind, 5);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_withNegativeStartIndex() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind, -1);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }
}

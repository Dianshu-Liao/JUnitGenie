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

public class ArrayUtils_lastIndexOf_174_0_Test {

    @Test
    public void testLastIndexOf_NullArray() {
        Object[] array = null;
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptyArray() {
        Object[] array = {};
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_ObjectFound() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_ObjectNotFound() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = new Object();
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_NullObjectFound() {
        Object[] array = { new Object(), null, new Object() };
        Object objectToFind = null;
        int result = ArrayUtils.lastIndexOf(array, objectToFind);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_StartIndexOutOfBounds() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind, 5);
        assertEquals(1, result);
    }

    @Test
    public void testLastIndexOf_StartIndexNegative() {
        Object[] array = { new Object(), new Object(), new Object() };
        Object objectToFind = array[1];
        int result = ArrayUtils.lastIndexOf(array, objectToFind, -1);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }
}

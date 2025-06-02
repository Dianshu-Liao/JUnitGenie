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

public class ArrayUtils_indexOf_104_0_Test {

    @Test
    public void testIndexOf_NullArray() {
        Object[] array = null;
        Object objectToFind = "test";
        int startIndex = 0;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_EmptyArray() {
        Object[] array = {};
        Object objectToFind = "test";
        int startIndex = 0;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_ObjectFound() {
        Object[] array = { "test", "example", "sample" };
        Object objectToFind = "example";
        int startIndex = 0;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOf_ObjectNotFound() {
        Object[] array = { "test", "example", "sample" };
        Object objectToFind = "notfound";
        int startIndex = 0;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_StartIndexOutOfBounds() {
        Object[] array = { "test", "example", "sample" };
        Object objectToFind = "sample";
        // Out of bounds
        int startIndex = 5;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_NullObjectToFind() {
        Object[] array = { "test", null, "sample" };
        Object objectToFind = null;
        int startIndex = 0;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOf_NegativeStartIndex() {
        Object[] array = { "test", "example", "sample" };
        Object objectToFind = "test";
        // Negative start index
        int startIndex = -1;
        int result = ArrayUtils.indexOf(array, objectToFind, startIndex);
        assertEquals(0, result);
    }
}

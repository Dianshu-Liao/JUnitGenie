package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
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

public class ArrayUtils_indexOf_103_0_Test {

    @Test
    public void testIndexOf_NullArray() {
        Object[] array = null;
        Object objectToFind = new Object();
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_EmptyArray() {
        Object[] array = {};
        Object objectToFind = new Object();
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_ObjectFound() {
        Object[] array = { new Object(), new Object(), "test" };
        Object objectToFind = "test";
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(2, result);
    }

    @Test
    public void testIndexOf_ObjectNotFound() {
        Object[] array = { new Object(), new Object(), "test" };
        Object objectToFind = "not found";
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_NullObjectFound() {
        Object[] array = { new Object(), null, "test" };
        Object objectToFind = null;
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOf_NullObjectNotFound() {
        Object[] array = { new Object(), new Object(), "test" };
        Object objectToFind = null;
        int result = ArrayUtils.indexOf(array, objectToFind);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOf_StartIndex() {
        Object[] array = { new Object(), new Object(), "test", "test" };
        Object objectToFind = "test";
        int result = ArrayUtils.indexOf(array, objectToFind, 2);
        assertEquals(3, result);
    }

    @Test
    public void testIndexOf_StartIndexOutOfBounds() {
        Object[] array = { new Object(), new Object(), "test" };
        Object objectToFind = "test";
        int result = ArrayUtils.indexOf(array, objectToFind, 5);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, result);
    }
}

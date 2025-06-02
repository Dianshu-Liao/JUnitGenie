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
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(null, "test", 0));
    }

    @Test
    public void testIndexOf_ObjectFound() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(2, ArrayUtils.indexOf(array, "c", 0));
    }

    @Test
    public void testIndexOf_ObjectNotFound() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(array, "e", 0));
    }

    @Test
    public void testIndexOf_StartIndexOutOfBounds() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(array, "a", 5));
    }

    @Test
    public void testIndexOf_NullObjectToFind() {
        Object[] array = { "a", null, "c", "d" };
        assertEquals(1, ArrayUtils.indexOf(array, null, 0));
    }

    @Test
    public void testIndexOf_NullObjectToFind_NoNullInArray() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(array, null, 0));
    }

    @Test
    public void testIndexOf_StartIndexNegative() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(0, ArrayUtils.indexOf(array, "a", -1));
    }

    @Test
    public void testIndexOf_StartIndexWithinBounds() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(1, ArrayUtils.indexOf(array, "b", 1));
    }

    @Test
    public void testIndexOf_EmptyArray() {
        Object[] array = {};
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(array, "a", 0));
    }
}

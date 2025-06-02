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

public class ArrayUtils_indexOf_103_0_Test {

    @Test
    public void testIndexOf_ObjectFound() {
        Object[] array = { "apple", "banana", "cherry" };
        int index = ArrayUtils.indexOf(array, "banana");
        assertEquals(1, index);
    }

    @Test
    public void testIndexOf_ObjectNotFound() {
        Object[] array = { "apple", "banana", "cherry" };
        int index = ArrayUtils.indexOf(array, "date");
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, index);
    }

    @Test
    public void testIndexOf_NullObjectFound() {
        Object[] array = { null, "banana", "cherry" };
        int index = ArrayUtils.indexOf(array, null);
        assertEquals(0, index);
    }

    @Test
    public void testIndexOf_EmptyArray() {
        Object[] array = {};
        int index = ArrayUtils.indexOf(array, "banana");
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, index);
    }

    @Test
    public void testIndexOf_NullArray() {
        int index = ArrayUtils.indexOf(null, "banana");
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, index);
    }

    @Test
    public void testIndexOf_ObjectFoundAtStart() {
        Object[] array = { "apple", "banana", "cherry" };
        int index = ArrayUtils.indexOf(array, "apple");
        assertEquals(0, index);
    }

    @Test
    public void testIndexOf_ObjectFoundAtEnd() {
        Object[] array = { "apple", "banana", "cherry" };
        int index = ArrayUtils.indexOf(array, "cherry");
        assertEquals(2, index);
    }
}

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
    public void testIndexOf_EmptyArray() {
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(new Object[] {}, "test", 0));
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
    public void testIndexOf_NullObjectToFind() {
        Object[] array = { "a", null, "c", "d" };
        assertEquals(1, ArrayUtils.indexOf(array, null, 0));
    }

    @Test
    public void testIndexOf_StartIndexOutOfBounds() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, ArrayUtils.indexOf(array, "a", 5));
    }

    @Test
    public void testIndexOf_StartIndexNegative() {
        Object[] array = { "a", "b", "c", "d" };
        // should start at index 0
        assertEquals(0, ArrayUtils.indexOf(array, "a", -1));
    }

    @Test
    public void testIndexOf_ObjectFoundAfterStartIndex() {
        Object[] array = { "a", "b", "c", "d" };
        assertEquals(3, ArrayUtils.indexOf(array, "d", 2));
    }

    @Test
    public void testIndexOf_NullInArray() {
        Object[] array = { null, "b", "c" };
        assertEquals(0, ArrayUtils.indexOf(array, null, 0));
    }

    @Test
    public void testIndexOf_ObjectEqualsMethod() {
        Object[] array = { new TestObject("test"), new TestObject("test2") };
        assertEquals(0, ArrayUtils.indexOf(array, new TestObject("test"), 0));
    }

    private static class TestObject {

        private String value;

        public TestObject(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            TestObject that = (TestObject) obj;
            return value.equals(that.value);
        }
    }
}

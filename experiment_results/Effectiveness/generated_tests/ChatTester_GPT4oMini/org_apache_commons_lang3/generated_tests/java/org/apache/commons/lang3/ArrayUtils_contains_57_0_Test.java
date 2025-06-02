package org.apache.commons.lang3;

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

public class ArrayUtils_contains_57_0_Test {

    @Test
    public void testContains_ObjectFound() {
        Object[] array = { "apple", "banana", "orange" };
        Object objectToFind = "banana";
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_ObjectNotFound() {
        Object[] array = { "apple", "banana", "orange" };
        Object objectToFind = "grape";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_EmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        Object objectToFind = "apple";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_NullArray() {
        Object[] array = null;
        Object objectToFind = "apple";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_NullObjectToFind() {
        Object[] array = { "apple", "banana", "orange" };
        Object objectToFind = null;
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_NullInArray() {
        Object[] array = { "apple", null, "orange" };
        Object objectToFind = null;
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_ObjectWithDifferentType() {
        Object[] array = { 1, 2, 3 };
        // String
        Object objectToFind = "1";
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_ObjectFoundWithCustomObject() {
        Object[] array = { new CustomObject("test"), new CustomObject("hello") };
        Object objectToFind = new CustomObject("test");
        assertTrue(ArrayUtils.contains(array, objectToFind));
    }

    @Test
    public void testContains_ObjectNotFoundWithCustomObject() {
        Object[] array = { new CustomObject("test"), new CustomObject("hello") };
        Object objectToFind = new CustomObject("world");
        assertFalse(ArrayUtils.contains(array, objectToFind));
    }

    private static class CustomObject {

        private String name;

        public CustomObject(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            CustomObject that = (CustomObject) obj;
            return name.equals(that.name);
        }
    }
}

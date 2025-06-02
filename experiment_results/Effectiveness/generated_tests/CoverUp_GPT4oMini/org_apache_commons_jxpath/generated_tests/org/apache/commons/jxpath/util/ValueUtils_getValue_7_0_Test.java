package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ValueUtils_getValue_7_0_Test {

    @Test
    void testGetValueWithArray() {
        Object array = new String[] { "a", "b", "c" };
        assertEquals("a", ValueUtils.getValue(array, 0));
        assertEquals("b", ValueUtils.getValue(array, 1));
        assertEquals("c", ValueUtils.getValue(array, 2));
        assertNull(ValueUtils.getValue(array, 3));
        assertNull(ValueUtils.getValue(array, -1));
    }

    @Test
    void testGetValueWithList() {
        List<String> list = Arrays.asList("x", "y", "z");
        assertEquals("x", ValueUtils.getValue(list, 0));
        assertEquals("y", ValueUtils.getValue(list, 1));
        assertEquals("z", ValueUtils.getValue(list, 2));
        assertNull(ValueUtils.getValue(list, 3));
        assertNull(ValueUtils.getValue(list, -1));
    }

    @Test
    void testGetValueWithCollection() {
        Collection<String> collection = Arrays.asList("one", "two", "three");
        assertEquals("one", ValueUtils.getValue(collection, 0));
        assertEquals("two", ValueUtils.getValue(collection, 1));
        assertEquals("three", ValueUtils.getValue(collection, 2));
        assertNull(ValueUtils.getValue(collection, 3));
        assertNull(ValueUtils.getValue(collection, -1));
    }

    @Test
    void testGetValueWithNull() {
        assertNull(ValueUtils.getValue(null, 0));
    }

    @Test
    void testGetValueWithEmptyArray() {
        Object emptyArray = new String[] {};
        assertNull(ValueUtils.getValue(emptyArray, 0));
    }

    @Test
    void testGetValueWithEmptyList() {
        List<String> emptyList = Arrays.asList();
        assertNull(ValueUtils.getValue(emptyList, 0));
    }

    @Test
    void testGetValueWithEmptyCollection() {
        Collection<String> emptyCollection = Arrays.asList();
        assertNull(ValueUtils.getValue(emptyCollection, 0));
    }

    @Test
    void testGetValueWithNegativeIndex() {
        Object array = new String[] { "a", "b", "c" };
        assertNull(ValueUtils.getValue(array, -1));
        List<String> list = Arrays.asList("x", "y", "z");
        assertNull(ValueUtils.getValue(list, -1));
        Collection<String> collection = Arrays.asList("one", "two", "three");
        assertNull(ValueUtils.getValue(collection, -1));
    }

    @Test
    void testGetValueWithOutOfBoundsIndex() {
        Object array = new String[] { "a", "b", "c" };
        assertNull(ValueUtils.getValue(array, 3));
        List<String> list = Arrays.asList("x", "y", "z");
        assertNull(ValueUtils.getValue(list, 3));
        Collection<String> collection = Arrays.asList("one", "two", "three");
        assertNull(ValueUtils.getValue(collection, 3));
    }
}

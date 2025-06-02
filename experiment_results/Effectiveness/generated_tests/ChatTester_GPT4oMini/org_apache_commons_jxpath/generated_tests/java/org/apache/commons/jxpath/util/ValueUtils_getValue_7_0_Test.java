package org.apache.commons.jxpath.util;

import java.lang.reflect.Array;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getValue_7_0_Test {

    @Test
    public void testGetValueWithArray() {
        Object array = new String[] { "a", "b", "c" };
        assertEquals("a", ValueUtils.getValue(array, 0));
        assertEquals("b", ValueUtils.getValue(array, 1));
        assertEquals("c", ValueUtils.getValue(array, 2));
        assertNull(ValueUtils.getValue(array, 3));
        assertNull(ValueUtils.getValue(array, -1));
    }

    @Test
    public void testGetValueWithList() {
        List<String> list = Arrays.asList("x", "y", "z");
        assertEquals("x", ValueUtils.getValue(list, 0));
        assertEquals("y", ValueUtils.getValue(list, 1));
        assertEquals("z", ValueUtils.getValue(list, 2));
        assertNull(ValueUtils.getValue(list, 3));
        assertNull(ValueUtils.getValue(list, -1));
    }

    @Test
    public void testGetValueWithCollection() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("one", "two", "three"));
        assertEquals("one", ValueUtils.getValue(collection, 0));
        assertEquals("two", ValueUtils.getValue(collection, 1));
        assertEquals("three", ValueUtils.getValue(collection, 2));
        assertNull(ValueUtils.getValue(collection, 3));
        assertNull(ValueUtils.getValue(collection, -1));
    }

    @Test
    public void testGetValueWithNullCollection() {
        assertNull(ValueUtils.getValue(null, 0));
    }

    @Test
    public void testGetValueWithInvalidIndex() {
        Object array = new String[] { "a", "b", "c" };
        assertNull(ValueUtils.getValue(array, 5));
        assertNull(ValueUtils.getValue(array, -1));
        List<String> list = Arrays.asList("x", "y", "z");
        assertNull(ValueUtils.getValue(list, 5));
        assertNull(ValueUtils.getValue(list, -1));
        Collection<String> collection = new ArrayList<>(Arrays.asList("one", "two", "three"));
        assertNull(ValueUtils.getValue(collection, 5));
        assertNull(ValueUtils.getValue(collection, -1));
    }
}

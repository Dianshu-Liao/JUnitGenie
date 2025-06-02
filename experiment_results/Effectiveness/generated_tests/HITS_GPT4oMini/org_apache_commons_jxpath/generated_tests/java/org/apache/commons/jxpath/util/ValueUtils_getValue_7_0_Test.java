package org.apache.commons.jxpath.util;

import java.util.ArrayList;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getValue_7_0_Test {

    @Test
    public void testGetValue_ArrayValidIndex() {
        Object array = new String[] { "a", "b", "c" };
        assertEquals("b", ValueUtils.getValue(array, 1));
    }

    @Test
    public void testGetValue_ArrayInvalidIndex() {
        Object array = new String[] { "a", "b", "c" };
        assertNull(ValueUtils.getValue(array, 3));
        assertNull(ValueUtils.getValue(array, -1));
    }

    @Test
    public void testGetValue_ListValidIndex() {
        List<String> list = Arrays.asList("x", "y", "z");
        assertEquals("y", ValueUtils.getValue(list, 1));
    }

    @Test
    public void testGetValue_ListInvalidIndex() {
        List<String> list = Arrays.asList("x", "y", "z");
        assertNull(ValueUtils.getValue(list, 3));
        assertNull(ValueUtils.getValue(list, -1));
    }

    @Test
    public void testGetValue_CollectionValidIndex() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("one", "two", "three"));
        assertEquals("two", ValueUtils.getValue(collection, 1));
    }

    @Test
    public void testGetValue_CollectionInvalidIndex() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("one", "two", "three"));
        assertNull(ValueUtils.getValue(collection, 3));
        assertNull(ValueUtils.getValue(collection, -1));
    }

    @Test
    public void testGetValue_NullCollection() {
        assertNull(ValueUtils.getValue(null, 0));
    }

    @Test
    public void testGetValue_EmptyArray() {
        Object emptyArray = new String[] {};
        assertNull(ValueUtils.getValue(emptyArray, 0));
    }

    @Test
    public void testGetValue_EmptyList() {
        List<String> emptyList = new ArrayList<>();
        assertNull(ValueUtils.getValue(emptyList, 0));
    }

    @Test
    public void testGetValue_EmptyCollection() {
        Collection<String> emptyCollection = new ArrayList<>();
        assertNull(ValueUtils.getValue(emptyCollection, 0));
    }
}

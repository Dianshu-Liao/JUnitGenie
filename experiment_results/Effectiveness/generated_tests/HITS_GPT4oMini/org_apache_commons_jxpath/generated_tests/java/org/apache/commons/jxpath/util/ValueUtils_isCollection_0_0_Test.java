package org.apache.commons.jxpath.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_isCollection_0_0_Test {

    @Test
    public void testIsCollectionWithNull() {
        // Test with null value
        Object value = null;
        assertFalse(ValueUtils.isCollection(value), "Expected isCollection to return false for null");
    }

    @Test
    public void testIsCollectionWithArray() {
        // Test with an array
        Object value = new int[] { 1, 2, 3 };
        assertTrue(ValueUtils.isCollection(value), "Expected isCollection to return true for an array");
        // Test with an empty array
        Object emptyArray = new String[] {};
        assertTrue(ValueUtils.isCollection(emptyArray), "Expected isCollection to return true for an empty array");
    }

    @Test
    public void testIsCollectionWithCollection() {
        // Test with a List
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        assertTrue(ValueUtils.isCollection(list), "Expected isCollection to return true for a List");
        // Test with a Set
        Collection<String> set = new HashSet<>();
        set.add("test");
        assertTrue(ValueUtils.isCollection(set), "Expected isCollection to return true for a Set");
    }

    @Test
    public void testIsCollectionWithNonCollectionObject() {
        // Test with a non-collection object
        Object value = "Not a collection";
        assertFalse(ValueUtils.isCollection(value), "Expected isCollection to return false for a non-collection object");
        // Test with an Integer
        value = 42;
        assertFalse(ValueUtils.isCollection(value), "Expected isCollection to return false for an Integer");
        // Test with a custom object
        value = new Object();
        assertFalse(ValueUtils.isCollection(value), "Expected isCollection to return false for a custom object");
    }
}

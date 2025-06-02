package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

class ValueUtils_isCollection_0_0_Test {

    @Test
    void testIsCollection_NullValue() {
        assertFalse(ValueUtils.isCollection(null));
    }

    @Test
    void testIsCollection_Array() {
        Object array = new String[] { "one", "two", "three" };
        assertTrue(ValueUtils.isCollection(array));
    }

    @Test
    void testIsCollection_Collection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        assertTrue(ValueUtils.isCollection(collection));
    }

    @Test
    void testIsCollection_NotACollection() {
        Object notACollection = new HashMap<>();
        assertFalse(ValueUtils.isCollection(notACollection));
    }

    @Test
    void testIsCollection_EmptyCollection() {
        Collection<String> emptyCollection = new ArrayList<>();
        assertTrue(ValueUtils.isCollection(emptyCollection));
    }

    @Test
    void testIsCollection_CollectionWithElements() {
        Collection<Integer> intCollection = new ArrayList<>();
        intCollection.add(1);
        intCollection.add(2);
        assertTrue(ValueUtils.isCollection(intCollection));
    }

    @Test
    void testIsCollection_String() {
        String str = "not a collection";
        assertFalse(ValueUtils.isCollection(str));
    }

    @Test
    void testIsCollection_EmptyArray() {
        Object emptyArray = new String[0];
        assertTrue(ValueUtils.isCollection(emptyArray));
    }

    @Test
    void testIsCollection_Object() {
        Object obj = new Object();
        assertFalse(ValueUtils.isCollection(obj));
    }
}

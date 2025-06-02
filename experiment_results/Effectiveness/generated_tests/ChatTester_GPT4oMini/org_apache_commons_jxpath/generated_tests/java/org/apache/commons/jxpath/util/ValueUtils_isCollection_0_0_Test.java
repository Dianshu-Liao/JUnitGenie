package org.apache.commons.jxpath.util;

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

public class ValueUtils_isCollection_0_0_Test {

    @Test
    public void testIsCollection_NullValue() {
        assertFalse(ValueUtils.isCollection(null));
    }

    @Test
    public void testIsCollection_Array() {
        Object array = new int[] { 1, 2, 3 };
        assertTrue(ValueUtils.isCollection(array));
    }

    @Test
    public void testIsCollection_Collection() {
        Collection<Object> collection = new ArrayList<>();
        assertTrue(ValueUtils.isCollection(collection));
    }

    @Test
    public void testIsCollection_NotACollection() {
        Object notACollection = "Not a collection";
        assertFalse(ValueUtils.isCollection(notACollection));
    }

    @Test
    public void testIsCollection_EmptyCollection() {
        Collection<Object> emptyCollection = new ArrayList<>();
        assertTrue(ValueUtils.isCollection(emptyCollection));
    }

    @Test
    public void testIsCollection_Map() {
        HashMap<Object, Object> map = new HashMap<>();
        assertFalse(ValueUtils.isCollection(map));
    }

    // Assuming getValue is a private method, we will use reflection to test it
    @Test
    public void testGetValue() throws Exception {
        Method method = ValueUtils.class.getDeclaredMethod("getValue", Object.class);
        method.setAccessible(true);
        // Assuming getValue returns the same object if it's not null
        Object input = "test";
        Object result = method.invoke(null, input);
        assertEquals(input, result);
        // Assuming getValue returns null for null input
        assertNull(method.invoke(null, null));
    }
}

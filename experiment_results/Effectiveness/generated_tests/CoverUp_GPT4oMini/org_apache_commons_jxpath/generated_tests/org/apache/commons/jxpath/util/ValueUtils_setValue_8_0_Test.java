package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ValueUtils_setValue_8_0_Test {

    @Test
    void testSetValue_array() {
        int[] array = new int[] { 1, 2, 3 };
        ValueUtils.setValue(array, 1, 20);
        assertEquals(20, array[1]);
    }

    @Test
    void testSetValue_list() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        ValueUtils.setValue(list, 1, "C");
        assertEquals("C", list.get(1));
    }

    @Test
    void testSetValue_collection_unsupported() {
        Collection<String> collection = new ArrayList<>();
        assertThrows(UnsupportedOperationException.class, () -> {
            ValueUtils.setValue(collection, 0, "value");
        });
    }

    @Test
    void testSetValue_nullCollection() {
        assertThrows(NullPointerException.class, () -> {
            ValueUtils.setValue(null, 0, "value");
        });
    }

    @Test
    void testSetValue_invalidIndex() {
        List<String> list = new ArrayList<>();
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ValueUtils.setValue(list, 1, "B");
        });
    }

    @Test
    void testSetValue_array_withConversion() {
        Object array = Array.newInstance(String.class, 3);
        ValueUtils.setValue(array, 0, "Hello");
        assertEquals("Hello", Array.get(array, 0));
    }

    @Test
    void testSetValue_invalidType() {
        int[] array = new int[] { 1, 2, 3 };
        assertThrows(ArrayStoreException.class, () -> {
            ValueUtils.setValue(array, 0, "String");
        });
    }

    // Reflection test to invoke private methods if needed
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = ValueUtils.class.getDeclaredMethod(methodName, Object.class, int.class, Object.class);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}

package org.apache.commons.jxpath.util;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_setValue_8_0_Test {

    @Test
    public void testSetValue_Array() {
        int[] array = new int[] { 1, 2, 3 };
        ValueUtils.setValue(array, 1, 5);
        assertEquals(5, array[1]);
    }

    @Test
    public void testSetValue_List() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ValueUtils.setValue(list, 1, "z");
        assertEquals("z", list.get(1));
    }

    @Test
    public void testSetValue_UnsupportedOperationException() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("x", "y", "z"));
        assertThrows(UnsupportedOperationException.class, () -> {
            ValueUtils.setValue(collection, 1, "new value");
        });
    }

    @Test
    public void testSetValue_NullCollection() {
        Object collection = null;
        assertDoesNotThrow(() -> {
            ValueUtils.setValue(collection, 0, "value");
        });
    }

    @Test
    public void testSetValue_InvalidIndex() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ValueUtils.setValue(list, 5, 10);
        });
    }

    @Test
    public void testSetValue_ArrayBounds() {
        Integer[] array = new Integer[] { 10, 20, 30 };
        ValueUtils.setValue(array, 0, 99);
        assertEquals(Integer.valueOf(99), array[0]);
    }

    @Test
    public void testSetValue_ListBounds() {
        List<Double> list = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3));
        ValueUtils.setValue(list, 2, 4.4);
        assertEquals(4.4, list.get(2));
    }
}

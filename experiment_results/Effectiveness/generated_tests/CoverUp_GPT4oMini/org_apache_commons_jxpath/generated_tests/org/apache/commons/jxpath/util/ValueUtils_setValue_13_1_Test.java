package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ValueUtils_setValue_13_1_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("list", TestBean.class);
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("list", TestBean.class);
    }

    @Test
    void testSetValue_IndexedPropertyDescriptor() throws Exception {
        Method method = indexedPropertyDescriptor.getIndexedWriteMethod();
        method.setAccessible(true);
        testBean.setList(new ArrayList<>());
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "New Value");
        assertEquals("New Value", testBean.getList().get(0));
    }

    @Test
    void testSetValue_NonIndexedPropertyDescriptor() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 1, "Value");
        });
    }

    @Test
    void testSetValue_Collection() throws Exception {
        testBean.setList(new ArrayList<>());
        testBean.getList().add("Old Value");
        ValueUtils.setValue(testBean, propertyDescriptor, 0, "Updated Value");
        assertEquals("Updated Value", testBean.getList().get(0));
    }

    @Test
    void testSetValue_IndexOutOfBounds() {
        testBean.setList(new ArrayList<>());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 1, "Value");
        });
    }

    @Test
    void testSetValue_NonCollection() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 1, "Value");
        });
    }

    private static class TestBean {

        private List<String> list = new ArrayList<>();

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}

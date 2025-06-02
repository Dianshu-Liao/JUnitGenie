package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ValueUtils_getValue_12_1_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    public void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("list", TestBean.class);
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("list", TestBean.class);
    }

    @Test
    public void testGetValueFromIndexedProperty() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        testBean.setList(list);
        Object result = ValueUtils.getValue(testBean, indexedPropertyDescriptor, 1);
        assertEquals("value2", result);
    }

    @Test
    public void testGetValueFromIndexedProperty_IndexOutOfBounds() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("value1");
        testBean.setList(list);
        Object result = ValueUtils.getValue(testBean, indexedPropertyDescriptor, 5);
        assertNull(result);
    }

    @Test
    public void testGetValueFromNonIndexedProperty() throws Exception {
        testBean.setName("testName");
        PropertyDescriptor nameDescriptor = new PropertyDescriptor("name", TestBean.class);
        Object result = ValueUtils.getValue(testBean, nameDescriptor);
        assertEquals("testName", result);
    }

    @Test
    public void testGetValueThrowsJXPathException() throws Exception {
        when(indexedPropertyDescriptor.getIndexedReadMethod()).thenThrow(new RuntimeException());
        assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(testBean, indexedPropertyDescriptor, 0);
        });
    }

    @Test
    public void testGetValueWithNullBean() throws Exception {
        Object result = ValueUtils.getValue(null, indexedPropertyDescriptor, 0);
        assertNull(result);
    }

    private class TestBean {

        private List<String> list;

        private String name;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

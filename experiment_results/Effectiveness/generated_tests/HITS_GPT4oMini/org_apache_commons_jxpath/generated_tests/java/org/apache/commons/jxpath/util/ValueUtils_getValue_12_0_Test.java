package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getValue_12_0_Test {

    private static class TestBean {

        private List<String> values;

        public TestBean() {
            values = new ArrayList<>();
        }

        public void setValues(List<String> values) {
            this.values = values;
        }

        public List<String> getValues() {
            return values;
        }
    }

    @Test
    public void testGetValue_WithIndexedProperty() throws Exception {
        // Setup
        TestBean bean = new TestBean();
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        bean.setValues(values);
        PropertyDescriptor propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        // Test
        Object result = ValueUtils.getValue(bean, propertyDescriptor, 1);
        // Verify
        assertEquals("value2", result);
    }

    @Test
    public void testGetValue_WithIndexOutOfBounds() throws Exception {
        // Setup
        TestBean bean = new TestBean();
        List<String> values = new ArrayList<>();
        values.add("value1");
        bean.setValues(values);
        PropertyDescriptor propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        // Test
        Object result = ValueUtils.getValue(bean, propertyDescriptor, 5);
        // Verify
        assertNull(result);
    }

    @Test
    public void testGetValue_WithNullBean() throws Exception {
        // Setup
        PropertyDescriptor propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        // Test
        Object result = ValueUtils.getValue(null, propertyDescriptor, 0);
        // Verify
        assertNull(result);
    }

    @Test
    public void testGetValue_WithNonIndexedProperty() throws Exception {
        // Setup
        TestBean bean = new TestBean();
        bean.setValues(new ArrayList<>());
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("values", TestBean.class);
        // Test
        Object result = ValueUtils.getValue(bean, propertyDescriptor);
        // Verify
        assertNotNull(result);
        assertTrue(result instanceof List);
    }

    @Test
    public void testGetValue_WithNullPropertyDescriptor() throws Exception {
        // Setup
        TestBean bean = new TestBean();
        // Test
        assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(bean, null, 0);
        });
    }
}

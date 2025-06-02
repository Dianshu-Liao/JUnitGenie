package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_setValue_13_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    public void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
    }

    @Test
    public void testSetValueIndexedProperty() throws Exception {
        Method indexedWriteMethod = indexedPropertyDescriptor.getIndexedWriteMethod();
        assertNotNull(indexedWriteMethod);
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "Test Value");
        assertEquals("Test Value", testBean.getValues()[0]);
    }

    @Test
    public void testSetValueWithNullIndexedProperty() throws Exception {
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, null);
        assertNull(testBean.getValues()[0]);
    }

    @Test
    public void testSetValueNonIndexedProperty() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 1, "Test Value");
        });
    }

    @Test
    public void testSetValueWithInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, indexedPropertyDescriptor, 1, "Test Value");
        });
    }

    @Test
    public void testSetValueOnCollection() throws Exception {
        testBean.setValues(new String[] { "Initial Value", "Another Value" });
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 1, "Updated Value");
        assertEquals("Updated Value", testBean.getValues()[1]);
    }

    @Test
    public void testSetValueOnNonCollection() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 0, "Test Value");
        });
    }

    @Test
    public void testSetValueWithExceptionInMethodInvocation() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, new Object());
        });
    }

    public static class TestBean {

        private String value;

        private String[] values = new String[2];

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String[] getValues() {
            return values;
        }

        public void setValues(String[] values) {
            this.values = values;
        }
    }
}

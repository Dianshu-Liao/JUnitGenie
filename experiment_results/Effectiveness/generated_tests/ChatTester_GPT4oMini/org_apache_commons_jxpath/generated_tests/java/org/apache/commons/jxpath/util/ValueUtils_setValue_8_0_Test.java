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

class ValueUtils_setValue_8_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("values", TestBean.class);
    }

    @Test
    void testSetValue_indexedProperty_success() throws Exception {
        IndexedPropertyDescriptor indexedPropertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        indexedPropertyDescriptor.setIndexedWriteMethod(TestBean.class.getMethod("setValueAtIndex", int.class, String.class));
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "First");
        assertEquals("First", testBean.getValueAtIndex(0));
    }

    @Test
    void testSetValue_nonIndexedProperty_success() throws Exception {
        ValueUtils.setValue(testBean, propertyDescriptor, "New Value");
        assertEquals("New Value", testBean.getValues());
    }

    @Test
    void testSetValue_invalidIndexedProperty() throws Exception {
        IndexedPropertyDescriptor indexedPropertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        indexedPropertyDescriptor.setIndexedWriteMethod(null);
        Exception exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "Value");
        });
        assertTrue(exception.getMessage().contains("No write method"));
    }

    @Test
    void testSetValue_notACollection() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 1, "Value");
        });
        assertTrue(exception.getMessage().contains("Not a collection: values"));
    }

    @Test
    void testSetValue_nullBean() throws Exception {
        Exception exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(null, propertyDescriptor, "Value");
        });
        assertTrue(exception.getMessage().contains("Cannot modify property: null"));
    }

    static class TestBean {

        private String[] values = new String[5];

        public String getValues() {
            // Just for testing purposes
            return values[0];
        }

        public void setValueAtIndex(int index, String value) {
            values[index] = value;
        }

        public String getValueAtIndex(int index) {
            return values[index];
        }
    }
}

package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.apache.commons.jxpath.JXPathException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
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

class ValueUtils_setValue_10_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
    }

    @Test
    void testSetValueWithValidProperty() throws Exception {
        ValueUtils.setValue(testBean, propertyDescriptor, "testValue");
        assertEquals("testValue", testBean.getValue());
    }

    @Test
    void testSetValueWithNullBean() {
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(null, propertyDescriptor, "testValue");
        });
    }

    @Test
    void testSetValueWithNoWriteMethod() throws Exception {
        PropertyDescriptor noWriteMethodDescriptor = new PropertyDescriptor("noWriteMethod", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, noWriteMethodDescriptor, "testValue");
        });
    }

    @Test
    void testSetValueWithConversionError() throws Exception {
        // Assuming convert will throw an exception for invalid conversion
        PropertyDescriptor invalidTypeDescriptor = new PropertyDescriptor("value", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, invalidTypeDescriptor, new Object());
        });
    }

    // Test for indexed property
    @Test
    void testSetValueWithIndexedProperty() throws Exception {
        PropertyDescriptor indexedPropertyDescriptor = new PropertyDescriptor("indexedValue", TestBean.class);
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "firstValue");
        assertEquals("firstValue", testBean.getIndexedValue(0));
    }

    @Test
    void testSetValueWithInvalidIndexedProperty() throws Exception {
        PropertyDescriptor invalidIndexedDescriptor = new PropertyDescriptor("indexedValue", TestBean.class);
        assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, invalidIndexedDescriptor, 1, "invalidValue");
        });
    }

    // Test for collection property
    @Test
    void testSetValueWithCollectionProperty() throws Exception {
        PropertyDescriptor collectionDescriptor = new PropertyDescriptor("collectionValue", TestBean.class);
        ValueUtils.setValue(testBean, collectionDescriptor, 0, "collectionValue");
        assertEquals("collectionValue", testBean.getCollectionValue().get(0));
    }

    // Mock TestBean class
    public static class TestBean {

        private String value;

        private String[] indexedValue = new String[1];

        private List<String> collectionValue = new ArrayList<>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getIndexedValue(int index) {
            return indexedValue[index];
        }

        public void setIndexedValue(int index, String value) {
            indexedValue[index] = value;
        }

        public List<String> getCollectionValue() {
            return collectionValue;
        }

        public void setCollectionValue(List<String> collectionValue) {
            this.collectionValue = collectionValue;
        }
    }
}

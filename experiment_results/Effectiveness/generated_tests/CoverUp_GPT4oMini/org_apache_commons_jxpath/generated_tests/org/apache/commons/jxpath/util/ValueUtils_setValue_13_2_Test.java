package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ValueUtils;
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

class ValueUtils_setValue_13_2_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        // Create an indexed property descriptor for the list property
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("items", TestBean.class);
    }

    @Test
    void testSetValueWithIndexedPropertyDescriptor() throws Exception {
        Method indexedWriteMethod = indexedPropertyDescriptor.getIndexedWriteMethod();
        assertNotNull(indexedWriteMethod);
        // Set up the initial state
        testBean.setItems(new ArrayList<>());
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "testValue");
        // Verify the value was set
        assertEquals("testValue", testBean.getItems().get(0));
    }

    @Test
    void testSetValueWithNonIndexedProperty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 0, "testValue");
        });
        String expectedMessage = "Not a collection: value";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSetValueWithCollection() {
        List<String> list = new ArrayList<>();
        list.add("initialValue");
        testBean.setItems(list);
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "newValue");
        assertEquals("newValue", testBean.getItems().get(0));
    }

    @Test
    void testSetValueWithInvalidIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, indexedPropertyDescriptor, 1, "outOfBoundsValue");
        });
        String expectedMessage = "Not a collection: items";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSetValueWithNullPropertyDescriptor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(testBean, null, 0, "testValue");
        });
        String expectedMessage = "Cannot access property: null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test bean class
    public static class TestBean {

        private List<String> items;

        private String value;

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

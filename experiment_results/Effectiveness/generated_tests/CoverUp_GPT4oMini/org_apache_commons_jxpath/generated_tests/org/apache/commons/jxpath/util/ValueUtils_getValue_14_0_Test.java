package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.JXPathException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ValueUtils_getValue_14_0_Test {

    private static class TestContainer implements Container {

        private Object value;

        public TestContainer(Object value) {
            this.value = value;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setValue(Object value) {
            this.value = value;
        }
    }

    @Test
    void testGetValueWithContainer() {
        TestContainer container = new TestContainer("Test Value");
        Object result = ValueUtils.getValue(container);
        assertEquals("Test Value", result);
    }

    @Test
    void testGetValueWithNestedContainer() {
        TestContainer nestedContainer = new TestContainer(new TestContainer("Nested Value"));
        Object result = ValueUtils.getValue(nestedContainer);
        assertEquals("Nested Value", result);
    }

    @Test
    void testGetValueWithNonContainer() {
        String nonContainerValue = "Non-container Value";
        Object result = ValueUtils.getValue(nonContainerValue);
        assertEquals("Non-container Value", result);
    }

    @Test
    void testGetValueWithNull() {
        Object result = ValueUtils.getValue(null);
        assertNull(result);
    }

    @Test
    void testGetValueWithEmptyContainer() {
        TestContainer emptyContainer = new TestContainer(null);
        Object result = ValueUtils.getValue(emptyContainer);
        assertNull(result);
    }

    @Test
    void testGetValueWithMultipleContainers() {
        TestContainer container1 = new TestContainer(new TestContainer(new TestContainer("Deep Value")));
        Object result = ValueUtils.getValue(container1);
        assertEquals("Deep Value", result);
    }

    @Test
    void testGetValueWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        Object result = ValueUtils.getValue(map);
        assertEquals(map, result);
    }

    @Test
    void testGetValueWithCollection() {
        // Assuming we have a collection implementation that is a Container
        TestContainer collectionContainer = new TestContainer(new TestContainer("Collection Value"));
        Object result = ValueUtils.getValue(collectionContainer);
        assertEquals("Collection Value", result);
    }

    @Test
    void testGetValueWithComplexObject() {
        Object complexObject = new Object() {

            public Object getValue() {
                return new TestContainer("Complex Value");
            }
        };
        Object result = ValueUtils.getValue(complexObject);
        assertEquals("Complex Value", result);
    }
}

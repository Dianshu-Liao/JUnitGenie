package org.apache.commons.jxpath.util;

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

class ValueUtils_getValue_14_0_Test {

    private static class Container {

        private Object value;

        public Container(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    @BeforeEach
    void setUp() {
        // Any setup can be done here if needed.
    }

    @Test
    void testGetValueWithSingleContainer() {
        Container container = new Container("testValue");
        Object result = ValueUtils.getValue(container);
        assertEquals("testValue", result);
    }

    @Test
    void testGetValueWithMultipleContainers() {
        Container innerContainer = new Container("finalValue");
        Container outerContainer = new Container(innerContainer);
        Object result = ValueUtils.getValue(outerContainer);
        assertEquals("finalValue", result);
    }

    @Test
    void testGetValueWithNull() {
        Object result = ValueUtils.getValue(null);
        assertNull(result);
    }

    @Test
    void testGetValueWithNonContainerObject() {
        Object result = ValueUtils.getValue("nonContainerValue");
        assertEquals("nonContainerValue", result);
    }
}

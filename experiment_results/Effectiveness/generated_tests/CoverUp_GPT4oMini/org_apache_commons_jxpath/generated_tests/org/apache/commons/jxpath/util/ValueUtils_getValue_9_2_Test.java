package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ValueUtils_getValue_9_2_Test {

    private static class TestBean {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    @Test
    void testGetValue_success() throws Exception {
        TestBean bean = new TestBean();
        bean.setValue("testValue");
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        Object result = ValueUtils.getValue(bean, propertyDescriptor);
        assertEquals("testValue", result);
    }

    @Test
    void testGetValue_noReadMethod() throws IntrospectionException {
        TestBean bean = new TestBean();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("nonExistent", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(bean, propertyDescriptor);
        });
        assertTrue(exception.getMessage().contains("No read method"));
    }

    @Test
    void testGetValue_nullBean() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(null, propertyDescriptor);
        });
        assertTrue(exception.getMessage().contains("Cannot access property: null"));
    }

    @Test
    void testGetValue_exceptionThrownInReadMethod() throws Exception {
        TestBean bean = new TestBean() {

            @Override
            public String getValue() {
                throw new RuntimeException("Read method exception");
            }
        };
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(bean, propertyDescriptor);
        });
        assertTrue(exception.getMessage().contains("Cannot access property:"));
    }
}

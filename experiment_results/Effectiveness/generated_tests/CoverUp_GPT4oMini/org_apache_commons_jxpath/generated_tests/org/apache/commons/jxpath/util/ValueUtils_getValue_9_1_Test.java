package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.beans.IndexedPropertyDescriptor;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ValueUtils_getValue_9_1_Test {

    private static class TestBean {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    void testGetValue() throws Exception {
        // Setup
        TestBean bean = new TestBean();
        bean.setName("Test Name");
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        // Test valid case
        Object value = ValueUtils.getValue(bean, propertyDescriptor);
        assertEquals("Test Name", value);
        // Test null bean
        JXPathException thrown = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(null, propertyDescriptor);
        });
        assertEquals("Cannot access property: null.name", thrown.getMessage());
        // Test property with no read method
        PropertyDescriptor noReadMethodDescriptor = new PropertyDescriptor("nonExistentProperty", TestBean.class);
        JXPathException thrownNoReadMethod = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(bean, noReadMethodDescriptor);
        });
        assertEquals("No read method", thrownNoReadMethod.getMessage());
    }

    @Test
    void testGetValueWithException() throws Exception {
        // Setup a bean with a read method that throws an exception
        TestBean beanWithException = new TestBean() {

            @Override
            public String getName() {
                throw new RuntimeException("Read method exception");
            }
        };
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        // Test exception thrown from read method
        JXPathException thrown = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(beanWithException, propertyDescriptor);
        });
        assertEquals("Cannot access property: TestBean.name", thrown.getMessage());
        assertTrue(thrown.getCause() instanceof RuntimeException);
        assertEquals("Read method exception", thrown.getCause().getMessage());
    }
}

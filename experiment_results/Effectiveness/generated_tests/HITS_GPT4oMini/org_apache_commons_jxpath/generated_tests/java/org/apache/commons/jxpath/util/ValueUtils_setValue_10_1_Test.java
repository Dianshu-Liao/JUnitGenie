package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
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

class ValueUtils_setValue_10_1_Test {

    private TestBean testBean;

    @BeforeEach
    void setUp() {
        testBean = new TestBean();
    }

    @Test
    void testSetValue_Success() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        ValueUtils.setValue(testBean, propertyDescriptor, "John Doe");
        assertEquals("John Doe", testBean.getName());
    }

    @Test
    void testSetValue_NoWriteMethod() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("age", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, 30);
        });
    }

    @Test
    void testSetValue_ConvertException() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, new Object());
        });
    }

    @Test
    void testSetValue_NullBean() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(null, propertyDescriptor, "Some Value");
        });
    }

    @Test
    void testSetValue_InvalidPropertyDescriptor() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("invalidProperty", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, "Some Value");
        });
    }

    // TestBean class for testing purposes
    public static class TestBean {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            // No setter for age to test no write method case
            return 0;
        }
    }
}

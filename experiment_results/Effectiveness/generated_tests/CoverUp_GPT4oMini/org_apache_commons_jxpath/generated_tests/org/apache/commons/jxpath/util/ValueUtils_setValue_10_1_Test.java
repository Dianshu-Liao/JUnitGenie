package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
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
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        ValueUtils.setValue(testBean, propertyDescriptor, "New Value");
        assertEquals("New Value", testBean.getValue());
    }

    @Test
    void testSetValue_NullBean() throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(null, propertyDescriptor, "Some Value");
        });
        assertTrue(exception.getMessage().contains("Cannot modify property: null.TestBean.value"));
    }

    @Test
    void testSetValue_NoWriteMethod() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("readonlyValue", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, "Some Value");
        });
        assertEquals("No write method", exception.getCause().getMessage());
    }

    @Test
    void testSetValue_ConversionFailure() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, propertyDescriptor, new Object());
        });
        assertTrue(exception.getMessage().contains("Cannot convert value of class java.lang.Object to type java.lang.String"));
    }

    // TestBean class for testing
    public static class TestBean {

        private String value;

        private String readonlyValue;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getReadonlyValue() {
            return readonlyValue;
        }
    }
}

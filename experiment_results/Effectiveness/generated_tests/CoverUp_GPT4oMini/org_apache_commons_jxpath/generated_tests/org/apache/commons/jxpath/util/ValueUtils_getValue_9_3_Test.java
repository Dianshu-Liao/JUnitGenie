package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
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

class ValueUtils_getValue_9_3_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        testBean.setValue("Test Value");
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
    }

    @Test
    void testGetValue_Success() {
        Object result = ValueUtils.getValue(testBean, propertyDescriptor);
        assertEquals("Test Value", result);
    }

    @Test
    void testGetValue_NullBean() {
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(null, propertyDescriptor);
        });
        assertEquals("Cannot access property: null.value", exception.getMessage());
    }

    @Test
    void testGetValue_NoReadMethod() throws Exception {
        PropertyDescriptor noReadMethodDescriptor = new PropertyDescriptor("noReadMethod", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(testBean, noReadMethodDescriptor);
        });
        assertEquals("No read method", exception.getCause().getMessage());
    }

    @Test
    void testGetValue_ReadMethodThrowsException() throws Exception {
        PropertyDescriptor throwExceptionDescriptor = new PropertyDescriptor("throwException", TestBean.class);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(testBean, throwExceptionDescriptor);
        });
        assertTrue(exception.getCause() instanceof IllegalStateException);
        assertEquals("Exception in getter", exception.getCause().getMessage());
    }

    // TestBean class for testing
    public static class TestBean {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNoReadMethod() {
            // No read method
            return null;
        }

        public String getThrowException() {
            throw new IllegalStateException("Exception in getter");
        }
    }
}

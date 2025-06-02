package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
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
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_setValue_10_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    public void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
    }

    @Test
    public void testSetValue_Success() throws Exception {
        ValueUtils.setValue(testBean, propertyDescriptor, "Test Value");
        assertEquals("Test Value", testBean.getValue());
    }

    @Test
    public void testSetValue_NullBean() {
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(null, propertyDescriptor, "Test Value");
        });
        assertTrue(exception.getMessage().contains("null"));
    }

    @Test
    public void testSetValue_NoWriteMethod() throws Exception {
        PropertyDescriptor noWriteMethodDescriptor = new PropertyDescriptor("noWriteProperty", TestBean.class);
        noWriteMethodDescriptor.setWriteMethod(null);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, noWriteMethodDescriptor, "Test Value");
        });
        assertEquals("No write method", exception.getCause().getMessage());
    }

    @Test
    public void testSetValue_ConversionException() throws Exception {
        // Assuming `convert` method throws an exception for invalid conversion
        PropertyDescriptor invalidDescriptor = new PropertyDescriptor("value", TestBean.class);
        // Use reflection to modify the 'convert' method's behavior
        Method convertMethod = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
        convertMethod.setAccessible(true);
        doThrow(new IllegalArgumentException("Conversion failed")).when(convertMethod).invoke(any(), any());
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(testBean, invalidDescriptor, new Object());
        });
        assertTrue(exception.getMessage().contains("Cannot modify property"));
    }

    // Test bean class for property descriptor
    public static class TestBean {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

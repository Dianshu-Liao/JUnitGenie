package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ValueUtils_setValue_10_1_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
    }

    @Test
    void testSetValue_Success() throws Exception {
        // Arrange
        String expectedValue = "testValue";
        // Act
        ValueUtils.setValue(testBean, propertyDescriptor, expectedValue);
        // Assert
        assertEquals(expectedValue, testBean.getValue());
    }

    @Test
    void testSetValue_NoWriteMethod() throws Exception {
        // Arrange
        PropertyDescriptor noWriteMethodDescriptor = new PropertyDescriptor("noWriteMethod", TestBean.class);
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> ValueUtils.setValue(testBean, noWriteMethodDescriptor, "value"));
        assertTrue(exception.getMessage().contains("No write method"));
    }

    @Test
    void testSetValue_ConvertException() throws Exception {
        // Arrange
        // Assuming the property is of type String.
        Object invalidValue = new Object();
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> ValueUtils.setValue(testBean, propertyDescriptor, invalidValue));
        assertTrue(exception.getMessage().contains("Cannot modify property"));
    }

    @Test
    void testSetValue_NullBean() {
        // Arrange
        Object value = "testValue";
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> ValueUtils.setValue(null, propertyDescriptor, value));
        assertTrue(exception.getMessage().contains("null"));
    }

    // TestBean class for testing purposes
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

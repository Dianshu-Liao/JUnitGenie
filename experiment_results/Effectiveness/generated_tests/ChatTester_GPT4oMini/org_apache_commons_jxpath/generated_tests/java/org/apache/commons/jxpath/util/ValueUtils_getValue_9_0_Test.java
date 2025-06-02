// Test method
package org.apache.commons.jxpath.util;

import org.junit.jupiter.api.function.Executable;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
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

class ValueUtils_getValue_9_0_Test {

    // Sample bean class for testing
    public static class TestBean {

        private String name;

        public TestBean(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    void testGetValue_Success() throws Exception {
        // Arrange
        TestBean bean = new TestBean("TestName");
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        // Act
        Object result = ValueUtils.getValue(bean, propertyDescriptor);
        // Assert
        assertEquals("TestName", result);
    }

    @Test
    void testGetValue_NullBean() throws Exception {
        // Arrange
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
        // Act
        Executable executable = () -> ValueUtils.getValue(null, propertyDescriptor);
        // Assert
        JXPathException exception = assertThrows(JXPathException.class, executable);
        assertTrue(exception.getMessage().contains("null"));
    }

    @Test
    void testGetValue_NoReadMethod() throws Exception {
        // Arrange
        class NoGetterBean {

            private String name;
            // No getter for 'name'
        }
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", NoGetterBean.class);
        // Act
        Executable executable = () -> ValueUtils.getValue(new NoGetterBean(), propertyDescriptor);
        // Assert
        JXPathException exception = assertThrows(JXPathException.class, executable);
        assertTrue(exception.getMessage().contains("No read method"));
    }

    @Test
    void testGetValue_ReadMethodThrowsException() throws Exception {
        // Arrange
        class ExceptionThrowingBean {

            public String getName() {
                throw new RuntimeException("Getter exception");
            }
        }
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", ExceptionThrowingBean.class);
        // Act
        Executable executable = () -> ValueUtils.getValue(new ExceptionThrowingBean(), propertyDescriptor);
        // Assert
        JXPathException exception = assertThrows(JXPathException.class, executable);
        assertTrue(exception.getMessage().contains("Cannot access property:"));
    }
}

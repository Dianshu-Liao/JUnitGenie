package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_setValue_13_1_Test {

    private ValueUtils valueUtils;

    @BeforeEach
    public void setUp() {
        valueUtils = new ValueUtils();
    }

    @Test
    public void testSetValue_WithIndexedPropertyDescriptor_ShouldInvokeMethod() throws Exception {
        // Arrange
        Object bean = new TestBean();
        IndexedPropertyDescriptor indexedPropertyDescriptor = mock(IndexedPropertyDescriptor.class);
        Method writeMethod = TestBean.class.getMethod("setValueAtIndex", int.class, String.class);
        when(indexedPropertyDescriptor.getIndexedWriteMethod()).thenReturn(writeMethod);
        // Act
        ValueUtils.setValue(bean, indexedPropertyDescriptor, 0, "Test Value");
        // Assert
        assertEquals("Test Value", ((TestBean) bean).getValueAtIndex(0));
    }

    @Test
    public void testSetValue_WithCollection_ShouldSetValue() throws Exception {
        // Arrange
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("list", TestBean.class);
        List<String> list = new ArrayList<>();
        ((TestBean) bean).setList(list);
        // Act
        ValueUtils.setValue(bean, propertyDescriptor, 0, "New Value");
        // Assert
        assertEquals("New Value", ((TestBean) bean).getList().get(0));
    }

    @Test
    public void testSetValue_WithInvalidPropertyDescriptor_ShouldThrowIllegalArgumentException() {
        // Arrange
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = mock(PropertyDescriptor.class);
        when(propertyDescriptor.getName()).thenReturn("invalidProperty");
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(bean, propertyDescriptor, 1, "Value");
        });
        assertEquals("Not a collection: invalidProperty", exception.getMessage());
    }

    @Test
    public void testSetValue_WithExceptionInInvoke_ShouldThrowIllegalArgumentException() throws Exception {
        // Arrange
        Object bean = new TestBean();
        IndexedPropertyDescriptor indexedPropertyDescriptor = mock(IndexedPropertyDescriptor.class);
        when(indexedPropertyDescriptor.getIndexedWriteMethod()).thenThrow(new RuntimeException("Access error"));
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ValueUtils.setValue(bean, indexedPropertyDescriptor, 0, "Value");
        });
        assertTrue(exception.getMessage().contains("Cannot access property:"));
    }

    @Test
    public void testSetValue_WithNullCollection_ShouldNotSetValue() throws Exception {
        // Arrange
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("list", TestBean.class);
        ((TestBean) bean).setList(null);
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            ValueUtils.setValue(bean, propertyDescriptor, 0, "Value");
        });
    }

    private static class TestBean {

        private List<String> list = new ArrayList<>();

        private String[] values = new String[10];

        public void setList(List<String> list) {
            this.list = list;
        }

        public List<String> getList() {
            return list;
        }

        public void setValueAtIndex(int index, String value) {
            values[index] = value;
        }

        public String getValueAtIndex(int index) {
            return values[index];
        }
    }
}

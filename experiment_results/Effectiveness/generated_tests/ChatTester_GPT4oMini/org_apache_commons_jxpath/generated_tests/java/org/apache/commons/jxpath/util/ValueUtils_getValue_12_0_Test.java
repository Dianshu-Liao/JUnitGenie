package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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

public class ValueUtils_getValue_12_0_Test {

    private Object bean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    public void setUp() throws Exception {
        bean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("values", TestBean.class);
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
    }

    @Test
    public void testGetValue_WithIndexedPropertyDescriptor_ReturnsValue() throws Exception {
        Method readMethod = indexedPropertyDescriptor.getIndexedReadMethod();
        Mockito.when(readMethod.invoke(bean, 0)).thenReturn("Value at index 0");
        Object result = ValueUtils.getValue(bean, indexedPropertyDescriptor, 0);
        Assertions.assertEquals("Value at index 0", result);
    }

    @Test
    public void testGetValue_WithIndexOutOfBoundsException_ReturnsNull() throws Exception {
        Method readMethod = indexedPropertyDescriptor.getIndexedReadMethod();
        Mockito.when(readMethod.invoke(bean, 0)).thenThrow(new IndexOutOfBoundsException());
        Object result = ValueUtils.getValue(bean, indexedPropertyDescriptor, 0);
        Assertions.assertNull(result);
    }

    @Test
    public void testGetValue_WithInvocationTargetException_ThrowsJXPathException() throws Exception {
        Method readMethod = indexedPropertyDescriptor.getIndexedReadMethod();
        Mockito.when(readMethod.invoke(bean, 0)).thenThrow(new InvocationTargetException(new Exception("Error")));
        Assertions.assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(bean, indexedPropertyDescriptor, 0);
        });
    }

    @Test
    public void testGetValue_WithNonIndexedPropertyDescriptor_CallsRecursiveGetValue() throws Exception {
        PropertyDescriptor nonIndexedPropertyDescriptor = new PropertyDescriptor("nonIndexedValue", TestBean.class);
        Mockito.when(nonIndexedPropertyDescriptor.getReadMethod()).thenReturn(TestBean.class.getMethod("getNonIndexedValue"));
        Object result = ValueUtils.getValue(bean, nonIndexedPropertyDescriptor, 0);
        Assertions.assertEquals("Non-indexed value", result);
    }

    private static class TestBean {

        private String[] values = { "Value at index 0", "Value at index 1" };

        public String[] getValues() {
            return values;
        }

        public String getNonIndexedValue() {
            return "Non-indexed value";
        }
    }
}

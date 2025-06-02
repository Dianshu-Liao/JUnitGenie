package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

class ValueUtils_setValue_13_0_Test {

    private static class TestBean {

        private List<String> items = new ArrayList<>();

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }
    }

    @Test
    void testSetValueIndexedProperty() throws Exception {
        TestBean bean = new TestBean();
        IndexedPropertyDescriptor ipd = new IndexedPropertyDescriptor("items", TestBean.class);
        bean.setItems(new ArrayList<>());
        ValueUtils.setValue(bean, ipd, 0, "Test Item");
        assertEquals("Test Item", bean.getItems().get(0));
    }

    @Test
    void testSetValueCollection() throws Exception {
        TestBean bean = new TestBean();
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class);
        List<String> items = new ArrayList<>();
        items.add("Existing Item");
        bean.setItems(items);
        ValueUtils.setValue(bean, pd, 0, "Updated Item");
        assertEquals("Updated Item", bean.getItems().get(0));
    }

    @Test
    void testSetValueWithUnsupportedCollection() throws Exception {
        TestBean bean = new TestBean();
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class);
        bean.setItems(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValueUtils.setValue(bean, pd, 1, "New Item"));
        assertTrue(exception.getMessage().contains("Not a collection"));
    }

    @Test
    void testSetValueWithNullCollection() throws Exception {
        TestBean bean = new TestBean();
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class);
        bean.setItems(new ArrayList<>());
        ValueUtils.setValue(bean, pd, 0, null);
        assertNull(bean.getItems().get(0));
    }

    @Test
    void testSetValueWithInvalidIndex() throws Exception {
        TestBean bean = new TestBean();
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class);
        bean.setItems(new ArrayList<>());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValueUtils.setValue(bean, pd, 2, "Invalid Index Item"));
        assertTrue(exception.getMessage().contains("Not a collection"));
    }

    @Test
    void testSetValueWithExceptionInInvocation() throws Exception {
        TestBean bean = new TestBean();
        IndexedPropertyDescriptor ipd = new IndexedPropertyDescriptor("items", TestBean.class);
        bean.setItems(new ArrayList<>());
        Method method = ipd.getIndexedWriteMethod();
        // Making the method throw an exception
        Method mockMethod = mock(Method.class);
        when(mockMethod.invoke(any(), any(), any())).thenThrow(new InvocationTargetException(new Exception("Test Exception")));
        setPrivateField(ipd, "indexedWriteMethod", mockMethod);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValueUtils.setValue(bean, ipd, 0, "Test Item"));
        assertTrue(exception.getMessage().contains("Cannot access property"));
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

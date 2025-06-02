package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BeanPropertyPointer_isCollection_9_0_Test {

    private BeanPropertyPointer pointer;

    private JXPathBeanInfo beanInfo;

    @BeforeEach
    public void setUp() {
        beanInfo = Mockito.mock(JXPathBeanInfo.class);
        pointer = new BeanPropertyPointer(null, beanInfo);
    }

    @Test
    public void testIsCollection_WithNullPropertyDescriptor() {
        assertFalse(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithIndexedPropertyDescriptor() throws Exception {
        PropertyDescriptor pd = new IndexedPropertyDescriptor("test", Object.class);
        setPropertyDescriptor(pd);
        assertTrue(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithCollectionHintReturningOne() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("test", Object.class);
        when(ValueUtils.getCollectionHint(Object.class)).thenReturn(1);
        setPropertyDescriptor(pd);
        assertTrue(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithCollectionHintReturningMinusOne() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("test", String.class);
        when(ValueUtils.getCollectionHint(String.class)).thenReturn(-1);
        setPropertyDescriptor(pd);
        assertFalse(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithBaseValueNull() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("test", Object.class);
        setPropertyDescriptor(pd);
        setBaseValue(null);
        assertFalse(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithBaseValueNotCollection() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("test", String.class);
        setPropertyDescriptor(pd);
        setBaseValue("Not a collection");
        assertFalse(pointer.isCollection());
    }

    @Test
    public void testIsCollection_WithBaseValueAsCollection() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("test", List.class);
        setPropertyDescriptor(pd);
        List<String> list = new ArrayList<>();
        list.add("item1");
        setBaseValue(list);
        assertTrue(pointer.isCollection());
    }

    private void setPropertyDescriptor(PropertyDescriptor pd) throws Exception {
        Field field = BeanPropertyPointer.class.getDeclaredField("propertyDescriptor");
        field.setAccessible(true);
        field.set(pointer, pd);
    }

    private void setBaseValue(Object value) throws Exception {
        Field field = BeanPropertyPointer.class.getDeclaredField("baseValue");
        field.setAccessible(true);
        field.set(pointer, value);
    }
}

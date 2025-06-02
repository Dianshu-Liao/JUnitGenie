package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BeanPropertyPointer_isCollection_9_2_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathBeanInfo mockBeanInfo;

    @BeforeEach
    void setUp() {
        mockBeanInfo = new JXPathBeanInfo() {

            @Override
            public PropertyDescriptor[] getPropertyDescriptors() {
                return new PropertyDescriptor[] {};
            }

            @Override
            public boolean isAtomic() {
                return false;
            }

            @Override
            public PropertyDescriptor getPropertyDescriptor(String propertyName) {
                // Implement as needed for your tests
                return null;
            }

            @Override
            public Class<?> getDynamicPropertyHandlerClass() {
                // Implement as needed for your tests
                return null;
            }

            @Override
            public boolean isDynamic() {
                // Implement as needed for your tests
                return false;
            }
        };
        beanPropertyPointer = new BeanPropertyPointer(null, mockBeanInfo);
    }

    @Test
    void testIsCollection_NoPropertyDescriptor() throws Exception {
        assertFalse(beanPropertyPointer.isCollection());
    }

    @Test
    void testIsCollection_IndexedPropertyDescriptor() throws Exception {
        IndexedPropertyDescriptor indexedPropertyDescriptor = new IndexedPropertyDescriptor("property", Object.class, null, null, null, null);
        setPrivateField(beanPropertyPointer, "propertyDescriptor", indexedPropertyDescriptor);
        assertTrue(beanPropertyPointer.isCollection());
    }

    @Test
    void testIsCollection_CollectionHintReturnsNegative() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", Object.class, null, null);
        setPrivateField(beanPropertyPointer, "propertyDescriptor", propertyDescriptor);
        setPrivateField(beanPropertyPointer, "baseValue", new Object());
        Field field = ValueUtils.class.getDeclaredField("collectionHint");
        field.setAccessible(true);
        field.setInt(null, -1);
        assertFalse(beanPropertyPointer.isCollection());
    }

    @Test
    void testIsCollection_CollectionHintReturnsOne() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", Object.class, null, null);
        setPrivateField(beanPropertyPointer, "propertyDescriptor", propertyDescriptor);
        setPrivateField(beanPropertyPointer, "baseValue", new Object());
        Field field = ValueUtils.class.getDeclaredField("collectionHint");
        field.setAccessible(true);
        field.setInt(null, 1);
        assertTrue(beanPropertyPointer.isCollection());
    }

    @Test
    void testIsCollection_ValidCollection() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", Object.class, null, null);
        setPrivateField(beanPropertyPointer, "propertyDescriptor", propertyDescriptor);
        setPrivateField(beanPropertyPointer, "baseValue", new java.util.ArrayList<>());
        assertTrue(beanPropertyPointer.isCollection());
    }

    @Test
    void testIsCollection_NullBaseValue() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", Object.class, null, null);
        setPrivateField(beanPropertyPointer, "propertyDescriptor", propertyDescriptor);
        setPrivateField(beanPropertyPointer, "baseValue", null);
        assertFalse(beanPropertyPointer.isCollection());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

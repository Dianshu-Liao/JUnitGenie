package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.beans.PropertyDescriptor;
import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BeanPropertyPointer_setPropertyIndex_4_0_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathBeanInfo mockBeanInfo;

    @BeforeEach
    void setUp() {
        mockBeanInfo = new JXPathBeanInfo() {

            @Override
            public PropertyDescriptor[] getPropertyDescriptors() {
                return new PropertyDescriptor[0];
            }

            @Override
            public boolean isAtomic() {
                return false;
            }

            @Override
            public Class<?> getDynamicPropertyHandlerClass() {
                return Object.class;
            }

            @Override
            public PropertyDescriptor getPropertyDescriptor(String propertyName) {
                return null;
            }

            @Override
            public boolean isDynamic() {
                // Implementing the abstract method
                return false;
            }
        };
        NodePointer parentNodePointer = null;
        beanPropertyPointer = new BeanPropertyPointer(parentNodePointer, mockBeanInfo);
    }

    @Test
    void testSetPropertyIndex_ChangesIndex() throws Exception {
        invokeSetPropertyIndex(beanPropertyPointer, 1);
        assertEquals(1, invokeGetPropertyIndex(beanPropertyPointer));
        invokeSetPropertyIndex(beanPropertyPointer, 2);
        assertEquals(2, invokeGetPropertyIndex(beanPropertyPointer));
    }

    @Test
    void testSetPropertyIndex_NoChange() throws Exception {
        invokeSetPropertyIndex(beanPropertyPointer, 1);
        invokeSetPropertyIndex(beanPropertyPointer, 1);
        assertEquals(1, invokeGetPropertyIndex(beanPropertyPointer));
    }

    @Test
    void testSetPropertyIndex_ResetsProperties() throws Exception {
        invokeSetPropertyIndex(beanPropertyPointer, 1);
        assertNotNull(invokeGetPropertyDescriptor(beanPropertyPointer));
        assertNotNull(invokeGetBaseValue(beanPropertyPointer));
        invokeSetPropertyIndex(beanPropertyPointer, 2);
        assertNull(invokeGetPropertyDescriptor(beanPropertyPointer));
        assertEquals(getUNINITIALIZED(), invokeGetBaseValue(beanPropertyPointer));
    }

    private void invokeSetPropertyIndex(BeanPropertyPointer pointer, int index) throws Exception {
        Method method = BeanPropertyPointer.class.getDeclaredMethod("setPropertyIndex", int.class);
        method.setAccessible(true);
        method.invoke(pointer, index);
    }

    private int invokeGetPropertyIndex(BeanPropertyPointer pointer) throws Exception {
        Method method = BeanPropertyPointer.class.getDeclaredMethod("getPropertyIndex");
        method.setAccessible(true);
        return (int) method.invoke(pointer);
    }

    private PropertyDescriptor invokeGetPropertyDescriptor(BeanPropertyPointer pointer) throws Exception {
        Method method = BeanPropertyPointer.class.getDeclaredMethod("getPropertyDescriptor");
        method.setAccessible(true);
        return (PropertyDescriptor) method.invoke(pointer);
    }

    private Object invokeGetBaseValue(BeanPropertyPointer pointer) throws Exception {
        Method method = BeanPropertyPointer.class.getDeclaredMethod("getBaseValue");
        method.setAccessible(true);
        return method.invoke(pointer);
    }

    private Object getUNINITIALIZED() throws Exception {
        Field field = BeanPropertyPointer.class.getDeclaredField("UNINITIALIZED");
        field.setAccessible(true);
        return field.get(null);
    }
}

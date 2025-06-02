package org.apache.commons.jxpath.ri.model.dynamic;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DynamicPropertyPointer_createPath_11_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private JXPathContext context;

    private DynamicPropertyHandler handler;

    private NodePointer parent;

    @BeforeEach
    void setUp() {
        handler = Mockito.mock(DynamicPropertyHandler.class);
        parent = Mockito.mock(NodePointer.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(parent, handler);
        context = Mockito.mock(JXPathContext.class);
    }

    @Test
    void testCreatePathWhenCollectionIsNull() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(null);
        AbstractFactory factory = Mockito.mock(AbstractFactory.class);
        // Using reflection to access protected method
        Mockito.when(getProtectedAbstractFactory(dynamicPropertyPointer, context)).thenReturn(factory);
        Mockito.when(dynamicPropertyPointer.getBean()).thenReturn(new Object());
        Mockito.when(dynamicPropertyPointer.getPropertyName()).thenReturn("property");
        Mockito.when(dynamicPropertyPointer.asPath()).thenReturn("testPath");
        Mockito.when(factory.createObject(context, dynamicPropertyPointer, dynamicPropertyPointer.getBean(), "property", 0)).thenReturn(true);
        NodePointer result = dynamicPropertyPointer.createPath(context);
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }

    @Test
    void testCreatePathWhenCollectionIsNotNullAndIndexIsValid() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(new Object());
        Mockito.when(dynamicPropertyPointer.getLength()).thenReturn(2);
        Mockito.when(dynamicPropertyPointer.getIndex()).thenReturn(1);
        NodePointer result = dynamicPropertyPointer.createPath(context);
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }

    @Test
    void testCreatePathWhenIndexIsLessThanZero() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(new Object());
        Mockito.when(dynamicPropertyPointer.getIndex()).thenReturn(-1);
        Exception exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            dynamicPropertyPointer.createPath(context);
        });
        assertEquals("Index is less than 1: testPath", exception.getMessage());
    }

    @Test
    void testCreatePathWhenIndexIsGreaterThanLength() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(new Object());
        Mockito.when(dynamicPropertyPointer.getLength()).thenReturn(2);
        Mockito.when(dynamicPropertyPointer.getIndex()).thenReturn(3);
        Mockito.when(dynamicPropertyPointer.getPropertyName()).thenReturn("property");
        dynamicPropertyPointer.createPath(context);
        Mockito.verify(handler).setProperty(dynamicPropertyPointer.getBean(), "property", Mockito.any());
    }

    @Test
    void testCreatePathWhenFactoryFailsToCreateObject() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(null);
        AbstractFactory factory = Mockito.mock(AbstractFactory.class);
        Mockito.when(getProtectedAbstractFactory(dynamicPropertyPointer, context)).thenReturn(factory);
        Mockito.when(dynamicPropertyPointer.getBean()).thenReturn(new Object());
        Mockito.when(dynamicPropertyPointer.getPropertyName()).thenReturn("property");
        Mockito.when(dynamicPropertyPointer.asPath()).thenReturn("testPath");
        Mockito.when(factory.createObject(context, dynamicPropertyPointer, dynamicPropertyPointer.getBean(), "property", 0)).thenReturn(false);
        Exception exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            dynamicPropertyPointer.createPath(context);
        });
        assertEquals("Factory could not create an object for path: testPath", exception.getMessage());
    }

    // Reflection method to access protected method
    private AbstractFactory getProtectedAbstractFactory(DynamicPropertyPointer dynamicPropertyPointer, JXPathContext context) {
        try {
            java.lang.reflect.Method method = DynamicPropertyPointer.class.getDeclaredMethod("getAbstractFactory", JXPathContext.class);
            method.setAccessible(true);
            return (AbstractFactory) method.invoke(dynamicPropertyPointer, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

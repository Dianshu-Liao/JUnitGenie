package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

class DynamicPropertyPointer_createPath_11_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private DynamicPropertyHandler handler;

    private JXPathContext context;

    @BeforeEach
    void setUp() {
        handler = Mockito.mock(DynamicPropertyHandler.class);
        context = Mockito.mock(JXPathContext.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    void testCreatePathWhenCollectionIsNull() throws Exception {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(null);
        Mockito.when(handler.getProperty(Mockito.any(), Mockito.any())).thenReturn(null);
        Mockito.when(handler.getPropertyNames(Mockito.any())).thenReturn(new String[] {});
        invokeCreatePath();
    }

    @Test
    void testCreatePathWhenFactoryCannotCreateObject() {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(null);
        Mockito.when(handler.getProperty(Mockito.any(), Mockito.any())).thenReturn(null);
        Mockito.when(handler.getPropertyNames(Mockito.any())).thenReturn(new String[] {});
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            invokeCreatePath();
        });
        assertEquals("Factory could not create an object for path: " + dynamicPropertyPointer.asPath(), exception.getMessage());
    }

    @Test
    void testCreatePathWithNegativeIndex() {
        dynamicPropertyPointer.setPropertyIndex(-1);
        JXPathInvalidAccessException exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            invokeCreatePath();
        });
        assertEquals("Index is less than 1: " + dynamicPropertyPointer.asPath(), exception.getMessage());
    }

    @Test
    void testCreatePathWithIndexGreaterThanLength() throws Exception {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(new Object[] {});
        Mockito.when(dynamicPropertyPointer.getLength()).thenReturn(0);
        Mockito.when(handler.getPropertyNames(Mockito.any())).thenReturn(new String[] {});
        dynamicPropertyPointer.setPropertyIndex(1);
        invokeCreatePath();
    }

    @Test
    void testCreatePathWithValidIndex() throws Exception {
        Mockito.when(dynamicPropertyPointer.getBaseValue()).thenReturn(new Object[] {});
        Mockito.when(dynamicPropertyPointer.getLength()).thenReturn(1);
        Mockito.when(handler.getPropertyNames(Mockito.any())).thenReturn(new String[] {});
        dynamicPropertyPointer.setPropertyIndex(0);
        invokeCreatePath();
    }

    private void invokeCreatePath() throws Exception {
        Method method = DynamicPropertyPointer.class.getDeclaredMethod("createPath", JXPathContext.class);
        method.setAccessible(true);
        method.invoke(dynamicPropertyPointer, context);
    }
}

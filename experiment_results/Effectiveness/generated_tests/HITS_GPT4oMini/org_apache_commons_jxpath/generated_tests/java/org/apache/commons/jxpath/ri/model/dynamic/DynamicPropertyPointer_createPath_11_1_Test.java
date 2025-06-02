package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynamicPropertyPointer_createPath_11_1_Test {

    private DynamicPropertyHandler handler;

    private JXPathContext context;

    private DynamicPropertyPointer pointer;

    private AbstractFactory factory;

    @BeforeEach
    public void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        context = mock(JXPathContext.class);
        factory = mock(AbstractFactory.class);
        pointer = new DynamicPropertyPointer(mock(NodePointer.class), handler);
    }

    @Test
    public void testCreatePathWhenBaseValueIsNullAndFactoryCreatesObject() {
        when(handler.getProperty(any(), any())).thenReturn(null);
        when(factory.createObject(any(), any(), any(), any(), any())).thenReturn(true);
        pointer.createPath(context);
        assertNotNull(pointer.getBaseValue());
    }

    @Test
    public void testCreatePathWhenBaseValueIsNullAndFactoryFails() {
        when(handler.getProperty(any(), any())).thenReturn(null);
        when(factory.createObject(any(), any(), any(), any(), any())).thenReturn(false);
        assertThrows(JXPathAbstractFactoryException.class, () -> pointer.createPath(context));
    }

    @Test
    public void testCreatePathWhenIndexIsLessThanZero() {
        pointer.setPropertyIndex(-1);
        assertThrows(JXPathInvalidAccessException.class, () -> pointer.createPath(context));
    }

    @Test
    public void testCreatePathWhenIndexIsGreaterThanLength() {
        when(handler.getProperty(any(), any())).thenReturn(new Object[2]);
        pointer.setPropertyIndex(3);
        assertThrows(JXPathInvalidAccessException.class, () -> pointer.createPath(context));
    }

    @Test
    public void testCreatePathWhenIndexIsValid() {
        Object collection = new Object[5];
        when(handler.getProperty(any(), any())).thenReturn(collection);
        pointer.setPropertyIndex(2);
        pointer.createPath(context);
        verify(handler).setProperty(any(), any(), any());
    }

    @Test
    public void testCreatePathExpandsCollectionWhenIndexIsGreaterThanLength() {
        Object collection = new Object[2];
        when(handler.getProperty(any(), any())).thenReturn(collection);
        pointer.setPropertyIndex(3);
        pointer.createPath(context);
        verify(handler).setProperty(any(), any(), any());
    }
}

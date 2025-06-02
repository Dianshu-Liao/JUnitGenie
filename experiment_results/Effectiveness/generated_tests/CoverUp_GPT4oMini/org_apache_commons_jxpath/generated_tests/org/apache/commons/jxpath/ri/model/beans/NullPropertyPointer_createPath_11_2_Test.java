package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NullPropertyPointer_createPath_11_2_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer parentMock;

    private JXPathContext contextMock;

    @BeforeEach
    void setUp() {
        parentMock = mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(parentMock);
        contextMock = mock(JXPathContext.class);
    }

    @Test
    void testCreatePath_Attribute() throws Exception {
        // Setup for attribute case
        nullPropertyPointer.setNameAttributeValue("attributeName");
        when(parentMock.createPath(any(JXPathContext.class))).thenReturn(parentMock);
        when(parentMock.createAttribute(any(JXPathContext.class), any(QName.class))).thenReturn(parentMock);
        NodePointer result = nullPropertyPointer.createPath(contextMock);
        assertNotNull(result);
        verify(parentMock).createPath(contextMock);
        verify(parentMock).createAttribute(contextMock, new QName("attributeName"));
    }

    @Test
    void testCreatePath_NullPointer() throws Exception {
        // Setup for NullPointer case
        NodePointer nullPointerMock = mock(NodePointer.class);
        when(parentMock.createPath(any(JXPathContext.class))).thenReturn(nullPointerMock);
        when(nullPointerMock instanceof PropertyOwnerPointer).thenReturn(false);
        NodePointer result = nullPropertyPointer.createPath(contextMock);
        assertNotNull(result);
        verify(parentMock).createPath(contextMock);
        verify(nullPointerMock).createChild(contextMock, new QName(nullPropertyPointer.getPropertyName()), 0);
    }

    @Test
    void testCreatePath_PropertyOwnerPointer() throws Exception {
        // Setup for PropertyOwnerPointer case
        PropertyOwnerPointer propertyOwnerMock = mock(PropertyOwnerPointer.class);
        when(parentMock.createPath(any(JXPathContext.class))).thenReturn(propertyOwnerMock);
        when(propertyOwnerMock.getPropertyPointer()).thenReturn(mock(PropertyPointer.class));
        when(propertyOwnerMock.createChild(any(JXPathContext.class), any(QName.class), anyInt())).thenReturn(propertyOwnerMock);
        NodePointer result = nullPropertyPointer.createPath(contextMock);
        assertNotNull(result);
        verify(parentMock).createPath(contextMock);
        verify(propertyOwnerMock).getPropertyPointer();
        verify(propertyOwnerMock).createChild(contextMock, new QName(nullPropertyPointer.getPropertyName()), 0);
    }

    @Test
    void testCreatePath_BadFactoryException() throws Exception {
        // Setup to trigger createBadFactoryException
        NodePointer newParentMock = mock(NodePointer.class);
        when(parentMock.createPath(any(JXPathContext.class))).thenReturn(newParentMock);
        when(newParentMock instanceof PropertyOwnerPointer).thenReturn(false);
        when(newParentMock.equals(newParentMock)).thenReturn(true);
        Exception exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            nullPropertyPointer.createPath(contextMock);
        });
        assertNotNull(exception);
    }
}

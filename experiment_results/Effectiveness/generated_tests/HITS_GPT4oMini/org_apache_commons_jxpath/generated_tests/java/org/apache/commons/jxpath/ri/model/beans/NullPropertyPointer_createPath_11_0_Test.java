package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.QName;

public class NullPropertyPointer_createPath_11_0_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer parentPointer;

    private JXPathContext context;

    @BeforeEach
    public void setUp() {
        parentPointer = mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(parentPointer);
        context = mock(JXPathContext.class);
    }

    @Test
    public void testCreatePath_WhenParentIsPropertyOwnerPointer() {
        PropertyOwnerPointer propertyOwnerPointer = mock(PropertyOwnerPointer.class);
        when(parentPointer.createPath(context)).thenReturn(propertyOwnerPointer);
        PropertyPointer propertyPointer = mock(PropertyPointer.class);
        when(propertyOwnerPointer.getPropertyPointer()).thenReturn(propertyPointer);
        when(propertyPointer.createChild(context, nullPropertyPointer.getName(), 0)).thenReturn(mock(NodePointer.class));
        NodePointer result = nullPropertyPointer.createPath(context);
        assertNotNull(result);
        verify(parentPointer).createPath(context);
        verify(propertyOwnerPointer).getPropertyPointer();
        verify(propertyPointer).createChild(context, nullPropertyPointer.getName(), 0);
    }

    @Test
    public void testCreatePath_WhenParentIsNullPointer() {
        when(parentPointer.createPath(context)).thenReturn(mock(NullPointer.class));
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            nullPropertyPointer.createPath(context);
        });
    }

    @Test
    public void testCreatePath_WhenNewParentIsNull() {
        when(parentPointer.createPath(context)).thenReturn(null);
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            nullPropertyPointer.createPath(context);
        });
        assertEquals("Factory null reported success creating object for path: null but object was null.  Terminating to avoid stack recursion.", exception.getMessage());
    }

    @Test
    public void testCreatePath_WhenNewParentIsNotPropertyOwnerPointer() {
        when(parentPointer.createPath(context)).thenReturn(mock(NodePointer.class));
        NodePointer result = nullPropertyPointer.createPath(context);
        assertNotNull(result);
        verify(parentPointer).createPath(context);
    }
}

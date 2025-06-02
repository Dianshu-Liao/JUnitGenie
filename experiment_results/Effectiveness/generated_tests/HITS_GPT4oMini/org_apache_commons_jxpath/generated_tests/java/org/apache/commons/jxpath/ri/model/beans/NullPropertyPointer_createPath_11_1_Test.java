package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPropertyPointer_createPath_11_1_Test {

    private JXPathContext context;

    private NodePointer parent;

    private NullPropertyPointer nullPropertyPointer;

    @BeforeEach
    public void setUp() {
        // Mocking the parent NodePointer
        parent = mock(NodePointer.class);
        context = mock(JXPathContext.class);
        nullPropertyPointer = new NullPropertyPointer(parent);
    }

    @Test
    public void testCreatePath_WithValidParent() {
        // Arrange
        NodePointer newParent = mock(NodePointer.class);
        when(parent.createPath(context)).thenReturn(newParent);
        // Act
        NodePointer result = nullPropertyPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(newParent, result);
        verify(parent).createPath(context);
    }

    @Test
    public void testCreatePath_WhenParentIsNullPointer() {
        // Arrange
        when(parent.createPath(context)).thenReturn(null);
        when(parent.equals(null)).thenReturn(true);
        // Act & Assert
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            nullPropertyPointer.createPath(context);
        });
        verify(parent).createPath(context);
    }

    @Test
    public void testCreatePath_WithPropertyOwnerPointer() {
        // Arrange
        PropertyOwnerPointer propertyOwnerPointer = mock(PropertyOwnerPointer.class);
        PropertyPointer propertyPointer = mock(PropertyPointer.class);
        // Changed to PropertyPointer
        NodePointer newParent = mock(PropertyPointer.class);
        when(parent.createPath(context)).thenReturn(propertyOwnerPointer);
        when(propertyOwnerPointer.getPropertyPointer()).thenReturn(propertyPointer);
        when(propertyPointer.createChild(context, nullPropertyPointer.getName(), 0)).thenReturn(newParent);
        // Act
        NodePointer result = nullPropertyPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(newParent, result);
        verify(parent).createPath(context);
        verify(propertyOwnerPointer).getPropertyPointer();
    }

    @Test
    public void testCreatePath_WhenParentIsNull() {
        // Arrange
        when(parent.createPath(context)).thenReturn(null);
        // Act
        NodePointer result = nullPropertyPointer.createPath(context);
        // Assert
        assertNull(result);
        verify(parent).createPath(context);
    }
}

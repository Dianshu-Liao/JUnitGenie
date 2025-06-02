package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPropertyPointer_setValue_10_2_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer mockParent;

    private PropertyOwnerPointer mockPropertyOwnerPointer;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(mockParent);
        mockPropertyOwnerPointer = mock(PropertyOwnerPointer.class);
    }

    @Test
    public void testSetValue_ParentIsNull_ThrowsJXPathInvalidAccessException() {
        nullPropertyPointer = new NullPropertyPointer(null);
        Exception exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue("testValue");
        });
        String expectedMessage = "Cannot set property *, the target object is null";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetValue_ParentIsContainer_ThrowsJXPathInvalidAccessException() {
        when(mockParent.isContainer()).thenReturn(true);
        Exception exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue("testValue");
        });
        String expectedMessage = "Cannot set property *, the target object is null";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testSetValue_ParentIsPropertyOwnerPointer_SupportsDynamicPropertyDeclaration() {
        when(mockParent instanceof PropertyOwnerPointer).thenReturn(true);
        when(mockPropertyOwnerPointer.isDynamicPropertyDeclarationSupported()).thenReturn(true);
        when(mockParent.getValuePointer()).thenReturn(mockPropertyOwnerPointer);
        // Use reflection to set the property name
        nullPropertyPointer.setPropertyName("testProperty");
        nullPropertyPointer.setValue("testValue");
        verify(mockPropertyOwnerPointer).getPropertyPointer();
        verify(mockPropertyOwnerPointer.getPropertyPointer()).setPropertyName("testProperty");
        verify(mockPropertyOwnerPointer.getPropertyPointer()).setValue("testValue");
    }

    @Test
    public void testSetValue_ParentIsPropertyOwnerPointer_DoesNotSupportDynamicPropertyDeclaration_ThrowsJXPathInvalidAccessException() {
        when(mockParent instanceof PropertyOwnerPointer).thenReturn(true);
        when(mockPropertyOwnerPointer.isDynamicPropertyDeclarationSupported()).thenReturn(false);
        when(mockParent.getValuePointer()).thenReturn(mockPropertyOwnerPointer);
        Exception exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue("testValue");
        });
        String expectedMessage = "Cannot set property *, path does not match a changeable location";
        assertEquals(expectedMessage, exception.getMessage());
    }
}

package org.apache.commons.jxpath.ri.model.beans;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

class PropertyIterator_getLength_8_0_Test {

    private PropertyIterator propertyIterator;

    private PropertyPointer mockPropertyPointer;

    @BeforeEach
    void setUp() {
        mockPropertyPointer = mock(PropertyPointer.class);
        propertyIterator = new PropertyIterator(mock(PropertyOwnerPointer.class), "test", false, mock(NodePointer.class));
        // Use reflection to set the private propertyNodePointer field
        setPrivateField(propertyIterator, "propertyNodePointer", mockPropertyPointer);
    }

    @Test
    void testGetLengthReturnsLength() {
        // Arrange
        when(mockPropertyPointer.getLength()).thenReturn(5);
        // Act
        int length = invokePrivateGetLength(propertyIterator);
        // Assert
        assertEquals(5, length);
    }

    @Test
    void testGetLengthHandlesException() {
        // Arrange
        when(mockPropertyPointer.getLength()).thenThrow(new RuntimeException("Error"));
        // Act
        int length = invokePrivateGetLength(propertyIterator);
        // Assert
        assertEquals(0, length);
        verify(mockPropertyPointer).handle(any(Throwable.class));
    }

    private int invokePrivateGetLength(PropertyIterator iterator) {
        try {
            java.lang.reflect.Method method = PropertyIterator.class.getDeclaredMethod("getLength");
            method.setAccessible(true);
            return (int) method.invoke(iterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

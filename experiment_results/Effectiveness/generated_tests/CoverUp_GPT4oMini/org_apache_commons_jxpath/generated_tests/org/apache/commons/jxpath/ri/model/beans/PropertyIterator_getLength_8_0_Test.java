package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyIterator_getLength_8_0_Test {

    private PropertyOwnerPointer mockPropertyOwnerPointer;

    private PropertyPointer mockPropertyPointer;

    private PropertyIterator propertyIterator;

    @BeforeEach
    void setUp() {
        mockPropertyOwnerPointer = mock(PropertyOwnerPointer.class);
        mockPropertyPointer = mock(PropertyPointer.class);
        propertyIterator = new PropertyIterator(mockPropertyOwnerPointer, "testProperty", false, null);
    }

    @Test
    void testGetLengthReturnsCorrectLength() throws Exception {
        // Given
        when(mockPropertyPointer.getLength()).thenReturn(5);
        setPropertyPointer(propertyIterator, mockPropertyPointer);
        // When
        int length = invokeGetLength();
        // Then
        assertEquals(5, length);
    }

    @Test
    void testGetLengthHandlesException() throws Exception {
        // Given
        when(mockPropertyPointer.getLength()).thenThrow(new JXPathException("Error"));
        setPropertyPointer(propertyIterator, mockPropertyPointer);
        // When
        int length = invokeGetLength();
        // Then
        assertEquals(0, length);
        verify(mockPropertyPointer).handle(any(Throwable.class));
    }

    private void setPropertyPointer(PropertyIterator iterator, PropertyPointer pointer) throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("getPropertyPointer");
        method.setAccessible(true);
        method.invoke(iterator, pointer);
    }

    private int invokeGetLength() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("getLength");
        method.setAccessible(true);
        return (int) method.invoke(propertyIterator);
    }
}

package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodeIterator;

@ExtendWith(MockitoExtension.class)
class PropertyIterator_setPositionIndividualProperty_5_4_Test {

    private PropertyPointer mockPropertyPointer;

    private PropertyOwnerPointer mockOwnerPointer;

    private PropertyIterator propertyIterator;

    @BeforeEach
    void setUp() {
        mockPropertyPointer = Mockito.mock(PropertyPointer.class);
        mockOwnerPointer = Mockito.mock(PropertyOwnerPointer.class);
        when(mockOwnerPointer.getPropertyPointer()).thenReturn(mockPropertyPointer);
        propertyIterator = new PropertyIterator(mockOwnerPointer, "testProperty", false, null);
    }

    @Test
    void testSetPositionIndividualProperty_ValidPosition() {
        when(mockPropertyPointer.getLength()).thenReturn(2);
        assertTrue(propertyIterator.setPosition(1), "Expected position to be set successfully.");
    }

    @Test
    void testSetPositionIndividualProperty_PositionLessThanOne() {
        assertFalse(propertyIterator.setPosition(-1), "Expected position to be invalid.");
    }

    @Test
    void testSetPositionIndividualProperty_Empty() {
        when(mockPropertyPointer.getLength()).thenReturn(0);
        assertFalse(propertyIterator.setPosition(1), "Expected position to be invalid when empty.");
    }

    @Test
    void testSetPositionIndividualProperty_Reverse() {
        PropertyIterator reverseIterator = new PropertyIterator(mockOwnerPointer, "testProperty", true, null);
        when(mockPropertyPointer.getLength()).thenReturn(2);
        assertTrue(reverseIterator.setPosition(1), "Expected position to be set successfully in reverse.");
    }

    @Test
    void testSetPositionIndividualProperty_IndexGreaterThanLength() {
        when(mockPropertyPointer.getLength()).thenReturn(2);
        propertyIterator.setPosition(3);
        assertFalse(propertyIterator.setPosition(3), "Expected position to be invalid when index exceeds length.");
    }

    @Test
    void testSetPositionIndividualProperty_SetIndex() {
        when(mockPropertyPointer.getLength()).thenReturn(2);
        propertyIterator.setPosition(1);
        assertTrue(propertyIterator.setPosition(1), "Expected position to be set successfully.");
        verify(mockPropertyPointer).setIndex(0);
    }

    @Test
    void testSetPositionIndividualProperty_HandlesExceptions() {
        when(mockPropertyPointer.getLength()).thenThrow(new RuntimeException("Simulated exception"));
        assertThrows(JXPathException.class, () -> {
            propertyIterator.setPosition(1);
        }, "Expected exception when property pointer throws exception.");
    }
}

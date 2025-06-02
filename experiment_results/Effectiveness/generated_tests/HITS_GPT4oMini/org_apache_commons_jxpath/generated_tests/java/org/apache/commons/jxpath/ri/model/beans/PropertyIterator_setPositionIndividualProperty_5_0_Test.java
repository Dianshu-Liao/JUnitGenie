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
public class PropertyIterator_setPositionIndividualProperty_5_0_Test {

    private PropertyIterator propertyIterator;

    @Mock
    private PropertyOwnerPointer propertyOwnerPointer;

    @Mock
    private PropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        // Mock the behavior of propertyPointer to return a length
        when(propertyPointer.getLength()).thenReturn(5);
        propertyIterator = new PropertyIterator(propertyOwnerPointer, "testProperty", false, propertyPointer);
    }

    @Test
    public void testSetPositionIndividualProperty_PositionLessThanOne() {
        // Test with position = 0
        assertFalse(propertyIterator.setPosition(0), "Expected false when position is 0");
        // Test with position = -1
        assertFalse(propertyIterator.setPosition(-1), "Expected false when position is -1");
    }

    @Test
    public void testSetPositionIndividualProperty_ValidPosition() {
        assertTrue(propertyIterator.setPosition(1), "Expected true when position is 1");
        assertTrue(propertyIterator.setPosition(5), "Expected true when position is 5");
    }

    @Test
    public void testSetPositionIndividualProperty_PositionGreaterThanLength() {
        assertFalse(propertyIterator.setPosition(6), "Expected false when position is greater than length");
    }

    @Test
    public void testSetPositionIndividualProperty_EmptyProperty() {
        // Simulate the empty state
        // Simulate empty state
        when(propertyPointer.getLength()).thenReturn(0);
        assertFalse(propertyIterator.setPosition(1), "Expected false when property is empty");
    }

    @Test
    public void testSetPositionIndividualProperty_NotReady() {
        // Simulate the state where target is not ready
        // Since we can't directly manipulate targetReady, we can simulate a scenario that would lead it to be false
        // For example, by ensuring that the propertyPointer does not have the expected property
        // Simulate no properties
        when(propertyPointer.getPropertyNames()).thenReturn(new String[0]);
        assertFalse(propertyIterator.setPosition(1), "Expected false when target is not ready");
    }
}

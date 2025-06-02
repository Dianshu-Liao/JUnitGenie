package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class PropertyIterator_setPositionIndividualProperty_5_0_Test {

    private PropertyOwnerPointer mockOwnerPointer;

    private PropertyPointer mockPropertyPointer;

    private PropertyIterator propertyIterator;

    @BeforeEach
    void setUp() {
        mockOwnerPointer = mock(PropertyOwnerPointer.class);
        mockPropertyPointer = mock(PropertyPointer.class);
        when(mockOwnerPointer.getPropertyPointer()).thenReturn(mockPropertyPointer);
        propertyIterator = new PropertyIterator(mockOwnerPointer, "testProperty", false, null);
    }

    @Test
    void testSetPositionIndividualProperty_ValidPosition() throws Exception {
        when(mockPropertyPointer.getLength()).thenReturn(5);
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertTrue(result);
        assertEquals(1, propertyIterator.getPosition());
    }

    @Test
    void testSetPositionIndividualProperty_PositionLessThanOne() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 0);
        assertFalse(result);
        assertEquals(0, propertyIterator.getPosition());
    }

    @Test
    void testSetPositionIndividualProperty_Empty() throws Exception {
        when(mockPropertyPointer.getLength()).thenReturn(0);
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertFalse(result);
        assertEquals(1, propertyIterator.getPosition());
    }

    @Test
    void testSetPositionIndividualProperty_IndexGreaterThanLength() throws Exception {
        when(mockPropertyPointer.getLength()).thenReturn(3);
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 4);
        assertFalse(result);
    }

    @Test
    void testSetPositionIndividualProperty_ReverseDirection() throws Exception {
        propertyIterator = new PropertyIterator(mockOwnerPointer, "testProperty", true, null);
        when(mockPropertyPointer.getLength()).thenReturn(5);
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertTrue(result);
        assertEquals(1, propertyIterator.getPosition());
    }

    @Test
    void testSetPositionIndividualProperty_ReverseDirection_IndexLessThanOne() throws Exception {
        propertyIterator = new PropertyIterator(mockOwnerPointer, "testProperty", true, null);
        when(mockPropertyPointer.getLength()).thenReturn(5);
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 6);
        assertFalse(result);
    }
}

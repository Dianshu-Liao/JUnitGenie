package org.apache.commons.jxpath.ri.model.beans;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyIterator_setPositionIndividualProperty_5_0_Test {

    private PropertyIterator propertyIterator;

    @Mock
    private PropertyOwnerPointer mockPointer;

    @Mock
    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        propertyIterator = new PropertyIterator(mockPointer, "testName", false, mockNodePointer);
    }

    @Test
    void testSetPositionIndividualProperty_ValidPosition() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        setField(propertyIterator, "startIndex", 0);
        setField(propertyIterator, "targetReady", true);
        setField(propertyIterator, "empty", false);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertTrue(result);
    }

    @Test
    void testSetPositionIndividualProperty_NegativePosition() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, -1);
        assertFalse(result);
    }

    @Test
    void testSetPositionIndividualProperty_ZeroPosition() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(propertyIterator, 0);
        assertFalse(result);
    }

    @Test
    void testSetPositionIndividualProperty_Empty() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        setField(propertyIterator, "empty", true);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertFalse(result);
    }

    @Test
    void testSetPositionIndividualProperty_ReverseDirection() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        setField(propertyIterator, "reverse", true);
        setField(propertyIterator, "startIndex", 0);
        setField(propertyIterator, "targetReady", true);
        setField(propertyIterator, "empty", false);
        boolean result = (boolean) method.invoke(propertyIterator, 1);
        assertTrue(result);
    }

    @Test
    void testSetPositionIndividualProperty_IndexOutOfBounds() throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setPositionIndividualProperty", int.class);
        method.setAccessible(true);
        setField(propertyIterator, "startIndex", 10);
        setField(propertyIterator, "targetReady", true);
        setField(propertyIterator, "empty", false);
        boolean result = (boolean) method.invoke(propertyIterator, 5);
        assertFalse(result);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

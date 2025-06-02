package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class DynamicPropertyPointer_getImmediateNode_8_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private DynamicPropertyHandler handler;

    @BeforeEach
    public void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    public void testGetImmediateNode_WhenWholeCollection() {
        // Arrange
        Object mockBean = new Object();
        String propertyName = "testProperty";
        Object expectedValue = "Expected Value";
        when(handler.getProperty(mockBean, propertyName)).thenReturn(new Object[] { expectedValue });
        dynamicPropertyPointer.setPropertyName(propertyName);
        dynamicPropertyPointer.setPropertyIndex(DynamicPropertyPointer.WHOLE_COLLECTION);
        // Act
        Object actualValue = dynamicPropertyPointer.getImmediateNode();
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetImmediateNode_WhenIndexedProperty() {
        // Arrange
        Object mockBean = new Object();
        String propertyName = "testProperty";
        Object[] mockArray = new Object[] { "Value 0", "Value 1", "Value 2" };
        int index = 1;
        Object expectedValue = "Value 1";
        when(handler.getProperty(mockBean, propertyName)).thenReturn(mockArray);
        dynamicPropertyPointer.setPropertyName(propertyName);
        dynamicPropertyPointer.setPropertyIndex(index);
        // Act
        Object actualValue = dynamicPropertyPointer.getImmediateNode();
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetImmediateNode_WhenIndexOutOfBounds() {
        // Arrange
        Object mockBean = new Object();
        String propertyName = "testProperty";
        Object[] mockArray = new Object[] { "Value 0", "Value 1" };
        // Out of bounds
        int index = 5;
        when(handler.getProperty(mockBean, propertyName)).thenReturn(mockArray);
        dynamicPropertyPointer.setPropertyName(propertyName);
        dynamicPropertyPointer.setPropertyIndex(index);
        // Act
        Object actualValue = dynamicPropertyPointer.getImmediateNode();
        // Assert
        assertNull(actualValue);
    }

    @Test
    public void testGetImmediateNode_WhenPropertyIsNull() {
        // Arrange
        Object mockBean = new Object();
        String propertyName = "testProperty";
        when(handler.getProperty(mockBean, propertyName)).thenReturn(null);
        dynamicPropertyPointer.setPropertyName(propertyName);
        dynamicPropertyPointer.setPropertyIndex(DynamicPropertyPointer.WHOLE_COLLECTION);
        // Act
        Object actualValue = dynamicPropertyPointer.getImmediateNode();
        // Assert
        assertNull(actualValue);
    }
}

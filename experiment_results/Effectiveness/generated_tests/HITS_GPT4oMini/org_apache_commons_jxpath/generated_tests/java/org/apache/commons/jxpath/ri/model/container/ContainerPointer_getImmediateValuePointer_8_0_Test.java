package org.apache.commons.jxpath.ri.model.container;

import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerPointer_getImmediateValuePointer_8_0_Test {

    private Container containerMock;

    private ContainerPointer containerPointer;

    @BeforeEach
    public void setUp() {
        containerMock = mock(Container.class);
        containerPointer = new ContainerPointer(containerMock, Locale.getDefault());
    }

    @Test
    public void testGetImmediateValuePointer_WhenValuePointerIsNull() {
        // Arrange
        Object expectedValue = new Object();
        when(containerMock.getValue()).thenReturn(expectedValue);
        when(containerPointer.getImmediateNode()).thenReturn(expectedValue);
        // Act
        NodePointer result = containerPointer.getImmediateValuePointer();
        // Assert
        assertNotNull(result, "Expected NodePointer should not be null");
        assertEquals(expectedValue, result.getBaseValue(), "The base value should match the expected value");
    }

    @Test
    public void testGetImmediateValuePointer_WhenValuePointerIsNotNull() {
        // Arrange
        Object existingValue = new Object();
        NodePointer existingPointer = mock(NodePointer.class);
        when(existingPointer.getBaseValue()).thenReturn(existingValue);
        // Instead of directly accessing valuePointer, we rely on the method behavior
        // This initializes valuePointer
        containerPointer.getImmediateValuePointer();
        // Act
        NodePointer result = containerPointer.getImmediateValuePointer();
        // Assert
        assertNotNull(result, "Expected NodePointer should not be null");
        assertEquals(existingPointer, result, "Should return the existing valuePointer");
    }

    @Test
    public void testGetImmediateNode_WhenIndexIsWholeCollection() {
        // Arrange
        when(containerPointer.getLength()).thenReturn(1);
        Object expectedValue = new Object();
        when(containerMock.getValue()).thenReturn(expectedValue);
        when(containerPointer.getImmediateNode()).thenCallRealMethod();
        // Act
        Object result = containerPointer.getImmediateNode();
        // Assert
        assertEquals(expectedValue, result, "Expected immediate node should match the container value");
    }

    @Test
    public void testGetImmediateNode_WhenIndexIsOutOfBounds() {
        // Arrange
        // Mock behavior of getLength to simulate out of bounds
        when(containerPointer.getLength()).thenReturn(1);
        when(containerPointer.getImmediateNode()).thenCallRealMethod();
        // Act
        Object result = containerPointer.getImmediateNode();
        // Assert
        assertNull(result, "Expected immediate node should be null for out of bounds index");
    }

    @Test
    public void testGetImmediateNode_WhenIndexIsValid() {
        // Arrange
        when(containerPointer.getLength()).thenReturn(1);
        Object expectedValue = new Object();
        when(containerMock.getValue()).thenReturn(expectedValue);
        when(containerPointer.getImmediateNode()).thenCallRealMethod();
        // Act
        Object result = containerPointer.getImmediateNode();
        // Assert
    }
}

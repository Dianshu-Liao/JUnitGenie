package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.axes.PredicateContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;

public class PredicateContext_setPosition_2_0_Test {

    private PredicateContext predicateContext;

    private EvalContext parentContext;

    private Expression expression;

    private PropertyPointer propertyPointer;

    private NodePointer nodePointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(EvalContext.class);
        expression = mock(Expression.class);
        predicateContext = new PredicateContext(parentContext, expression);
        propertyPointer = mock(PropertyPointer.class);
        nodePointer = mock(NodePointer.class);
    }

    @Test
    public void testSetPositionWhenNameTestExpressionIsNull() {
        // Arrange
        when(expression instanceof NameAttributeTest).thenReturn(false);
        // Act
        boolean result = predicateContext.setPosition(1);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testSetPositionWhenDynamicPropertyPointerIsNullAndSetupFails() {
        // Arrange
        when(expression instanceof NameAttributeTest).thenReturn(true);
        when(parentContext.getCurrentNodePointer()).thenReturn(null);
        // Act
        boolean result = predicateContext.setPosition(1);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testSetPositionWhenPositionIsLessThanOne() {
        // Arrange
        when(expression instanceof NameAttributeTest).thenReturn(true);
        // Assume length is 5
        setupDynamicPropertyPointerMock(5);
        // Act
        boolean result = predicateContext.setPosition(0);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testSetPositionWhenPositionIsGreaterThanLength() {
        // Arrange
        when(expression instanceof NameAttributeTest).thenReturn(true);
        // Assume length is 5
        setupDynamicPropertyPointerMock(5);
        // Act
        boolean result = predicateContext.setPosition(6);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testSetPositionValidPosition() {
        // Arrange
        when(expression instanceof NameAttributeTest).thenReturn(true);
        // Assume length is 5
        setupDynamicPropertyPointerMock(5);
        // Act
        boolean result = predicateContext.setPosition(3);
        // Assert
        assertTrue(result);
        // Index should be position - 1
        verify(propertyPointer).setIndex(2);
    }

    private void setupDynamicPropertyPointerMock(int length) {
        when(parentContext.getCurrentNodePointer()).thenReturn(nodePointer);
        when(nodePointer.getValuePointer()).thenReturn(mock(PropertyOwnerPointer.class));
        when(((PropertyOwnerPointer) nodePointer.getValuePointer()).getPropertyPointer()).thenReturn(propertyPointer);
        when(propertyPointer.getLength()).thenReturn(length);
    }
}

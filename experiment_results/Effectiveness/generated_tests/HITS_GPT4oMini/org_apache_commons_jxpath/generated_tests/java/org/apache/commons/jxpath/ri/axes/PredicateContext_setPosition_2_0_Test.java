package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.InfoSetUtil;

@ExtendWith(MockitoExtension.class)
public class PredicateContext_setPosition_2_0_Test {

    private PredicateContext predicateContext;

    private EvalContext parentContext;

    private Expression expression;

    private PropertyPointer mockPropertyPointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(EvalContext.class);
        expression = mock(Expression.class);
        predicateContext = new PredicateContext(parentContext, expression);
        mockPropertyPointer = mock(PropertyPointer.class);
    }

    private void setDynamicPropertyPointer(PredicateContext context, PropertyPointer pointer) {
        try {
            Field field = PredicateContext.class.getDeclaredField("dynamicPropertyPointer");
            field.setAccessible(true);
            field.set(context, pointer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set dynamicPropertyPointer field: " + e.getMessage());
        }
    }

    @Test
    public void testSetPositionWithNullNameTestExpression() {
        // Simulate the absence of a name test expression
        assertFalse(predicateContext.setPosition(1));
    }

    @Test
    public void testSetPositionWithDynamicPropertyPointerNull() {
        // Simulate that expression is not a NameAttributeTest
        when(expression instanceof NameAttributeTest).thenReturn(false);
        assertFalse(predicateContext.setPosition(1));
    }

    @Test
    public void testSetPositionWithInvalidPosition() {
        // Setup mock for dynamicPropertyPointer
        when(mockPropertyPointer.getLength()).thenReturn(5);
        // Use reflection or a public method to set the dynamicPropertyPointer
        setDynamicPropertyPointer(predicateContext, mockPropertyPointer);
        // Test with invalid position less than 1
        assertFalse(predicateContext.setPosition(0));
        // Test with invalid position greater than length
        assertFalse(predicateContext.setPosition(6));
    }

    @Test
    public void testSetPositionWithValidPosition() {
        // Setup mock for dynamicPropertyPointer
        when(mockPropertyPointer.getLength()).thenReturn(5);
        setDynamicPropertyPointer(predicateContext, mockPropertyPointer);
        // Test with a valid position
        assertTrue(predicateContext.setPosition(3));
        // Index is position - 1
        verify(mockPropertyPointer).setIndex(2);
    }

    @Test
    public void testSetPositionStandardWithHigherPosition() {
        // Setup the state for testing
        setDynamicPropertyPointer(predicateContext, mockPropertyPointer);
        when(mockPropertyPointer.getLength()).thenReturn(5);
        // Test with a higher position
        assertTrue(predicateContext.setPosition(3));
        verify(mockPropertyPointer).setIndex(2);
    }
}

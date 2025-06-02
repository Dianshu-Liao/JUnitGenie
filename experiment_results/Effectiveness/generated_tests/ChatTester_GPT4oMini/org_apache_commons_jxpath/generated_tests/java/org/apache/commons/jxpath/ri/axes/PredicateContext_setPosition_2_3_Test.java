// Test method
package org.apache.commons.jxpath.ri.axes;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;

public class PredicateContext_setPosition_2_3_Test {

    private PredicateContext predicateContext;

    private EvalContext parentContext;

    private Expression expression;

    @BeforeEach
    public void setUp() {
        parentContext = mock(EvalContext.class);
        expression = mock(Expression.class);
        predicateContext = new PredicateContext(parentContext, expression);
    }

    @Test
    public void testSetPosition_NameTestExpressionNull() throws Exception {
        // Given
        int position = 1;
        // When
        boolean result = invokeSetPosition(predicateContext, position);
        // Then
        assertTrue(result);
    }

    @Test
    public void testSetPosition_DynamicPropertyPointerNullAndSetupFails() throws Exception {
        // Given
        int position = 1;
        // Mock the setupDynamicPropertyPointer method to return false
        Method setupMethod = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        setupMethod.setAccessible(true);
        // Call the method to set up the dynamic property pointer
        setupMethod.invoke(predicateContext);
        // When
        boolean result = invokeSetPosition(predicateContext, position);
        // Then
        assertTrue(result);
    }

    @Test
    public void testSetPosition_InvalidPosition_LessThanOne() throws Exception {
        // Given
        int position = 0;
        // When
        boolean result = invokeSetPosition(predicateContext, position);
        // Then
        assertFalse(result);
    }

    @Test
    public void testSetPosition_InvalidPosition_GreaterThanLength() throws Exception {
        // Given
        int position = 2;
        PropertyPointer dynamicPropertyPointer = mock(PropertyPointer.class);
        when(dynamicPropertyPointer.getLength()).thenReturn(1);
        setDynamicPropertyPointer(predicateContext, dynamicPropertyPointer);
        // When
        boolean result = invokeSetPosition(predicateContext, position);
        // Then
        assertFalse(result);
    }

    @Test
    public void testSetPosition_ValidPosition() throws Exception {
        // Given
        int position = 1;
        PropertyPointer dynamicPropertyPointer = mock(PropertyPointer.class);
        when(dynamicPropertyPointer.getLength()).thenReturn(2);
        setDynamicPropertyPointer(predicateContext, dynamicPropertyPointer);
        // When
        boolean result = invokeSetPosition(predicateContext, position);
        // Then
        assertTrue(result);
        verify(dynamicPropertyPointer).setIndex(0);
    }

    private boolean invokeSetPosition(PredicateContext context, int position) throws Exception {
        Method method = PredicateContext.class.getDeclaredMethod("setPosition", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(context, position);
    }

    private void setDynamicPropertyPointer(PredicateContext context, PropertyPointer dynamicPropertyPointer) throws Exception {
        java.lang.reflect.Field field = PredicateContext.class.getDeclaredField("dynamicPropertyPointer");
        field.setAccessible(true);
        field.set(context, dynamicPropertyPointer);
    }
}

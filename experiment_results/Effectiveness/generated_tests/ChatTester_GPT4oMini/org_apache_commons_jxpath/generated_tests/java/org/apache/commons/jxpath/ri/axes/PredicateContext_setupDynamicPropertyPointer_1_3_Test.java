// Test method
package org.apache.commons.jxpath.ri.axes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PredicateContext_setupDynamicPropertyPointer_1_3_Test {

    private PredicateContext predicateContext;

    private EvalContext parentContextMock;

    private Expression expressionMock;

    private NodePointer nodePointerMock;

    private PropertyOwnerPointer propertyOwnerPointerMock;

    private PropertyPointer propertyPointerMock;

    @BeforeEach
    public void setUp() {
        parentContextMock = mock(EvalContext.class);
        expressionMock = mock(Expression.class);
        predicateContext = new PredicateContext(parentContextMock, expressionMock);
        // Mocking the private field nameTestExpression
        try {
            Method method = PredicateContext.class.getDeclaredMethod("setNameTestExpression", Expression.class);
            method.setAccessible(true);
            method.invoke(predicateContext, mock(Expression.class));
        } catch (Exception e) {
            fail("Failed to set up test: " + e.getMessage());
        }
    }

    @Test
    public void testSetupDynamicPropertyPointer_NameTestExpressionIsNull() throws Exception {
        // Invoke the private method using reflection
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert the result
        assertFalse(result);
    }

    @Test
    public void testSetupDynamicPropertyPointer_ParentContextIsNull() throws Exception {
        when(parentContextMock.getCurrentNodePointer()).thenReturn(null);
        // Invoke the private method using reflection
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert the result
        assertFalse(result);
    }

    @Test
    public void testSetupDynamicPropertyPointer_ParentIsNotPropertyOwnerPointer() throws Exception {
        nodePointerMock = mock(NodePointer.class);
        when(parentContextMock.getCurrentNodePointer()).thenReturn(nodePointerMock);
        // Fixed the buggy line: Creating a mock for NodePointer that returns a non-PropertyOwnerPointer
        when(nodePointerMock.getValuePointer()).thenReturn(mock(NodePointer.class));
        // Invoke the private method using reflection
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert the result
        assertFalse(result);
    }

    @Test
    public void testSetupDynamicPropertyPointer_Success() throws Exception {
        propertyOwnerPointerMock = mock(PropertyOwnerPointer.class);
        propertyPointerMock = mock(PropertyPointer.class);
        nodePointerMock = mock(NodePointer.class);
        when(parentContextMock.getCurrentNodePointer()).thenReturn(nodePointerMock);
        when(nodePointerMock.getValuePointer()).thenReturn(propertyOwnerPointerMock);
        when(propertyOwnerPointerMock.getPropertyPointer()).thenReturn(propertyPointerMock);
        when(propertyPointerMock.clone()).thenReturn(propertyPointerMock);
        // Invoke the private method using reflection
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert the result
        assertTrue(result);
        // Verify that dynamicPropertyPointer was set
        Field dynamicPropertyPointerField = PredicateContext.class.getDeclaredField("dynamicPropertyPointer");
        dynamicPropertyPointerField.setAccessible(true);
        assertNotNull(dynamicPropertyPointerField.get(predicateContext));
    }
}

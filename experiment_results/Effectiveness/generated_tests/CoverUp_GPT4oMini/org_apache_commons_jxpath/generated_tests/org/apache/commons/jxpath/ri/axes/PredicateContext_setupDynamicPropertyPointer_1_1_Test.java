package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.axes.PredicateContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.ri.EvalContext;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;

@ExtendWith(MockitoExtension.class)
class PredicateContext_setupDynamicPropertyPointer_1_1_Test {

    private PredicateContext predicateContext;

    private EvalContext parentContextMock;

    private NodePointer nodePointerMock;

    private PropertyOwnerPointer propertyOwnerPointerMock;

    private PropertyPointer propertyPointerMock;

    private Expression expressionMock;

    @BeforeEach
    void setUp() {
        parentContextMock = mock(EvalContext.class);
        nodePointerMock = mock(NodePointer.class);
        propertyOwnerPointerMock = mock(PropertyOwnerPointer.class);
        propertyPointerMock = mock(PropertyPointer.class);
        expressionMock = mock(Expression.class);
        predicateContext = new PredicateContext(parentContextMock, expressionMock);
    }

    @Test
    void testSetupDynamicPropertyPointer_NameTestExpressionNull() throws Exception {
        // Setup
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        // Act
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert
        assertFalse(result);
    }

    @Test
    void testSetupDynamicPropertyPointer_ParentNodePointerNull() throws Exception {
        // Setup
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        // Mock behavior
        when(parentContextMock.getCurrentNodePointer()).thenReturn(null);
        // Act
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert
        assertFalse(result);
    }

    @Test
    void testSetupDynamicPropertyPointer_ParentNotPropertyOwnerPointer() throws Exception {
        // Setup
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        // Mock behavior
        when(parentContextMock.getCurrentNodePointer()).thenReturn(nodePointerMock);
        // Not a PropertyOwnerPointer
        when(nodePointerMock.getValuePointer()).thenReturn(nodePointerMock);
        // Act
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert
        assertFalse(result);
    }

    @Test
    void testSetupDynamicPropertyPointer_Success() throws Exception {
        // Setup
        Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        // Mock behavior
        when(parentContextMock.getCurrentNodePointer()).thenReturn(nodePointerMock);
        when(nodePointerMock.getValuePointer()).thenReturn(propertyOwnerPointerMock);
        when(propertyOwnerPointerMock.getPropertyPointer()).thenReturn(propertyPointerMock);
        when(propertyPointerMock.clone()).thenReturn(propertyPointerMock);
        // Use reflection to set the private field nameTestExpression
        Field nameTestExpressionField = PredicateContext.class.getDeclaredField("nameTestExpression");
        nameTestExpressionField.setAccessible(true);
        nameTestExpressionField.set(predicateContext, expressionMock);
        // Act
        boolean result = (boolean) method.invoke(predicateContext);
        // Assert
        assertTrue(result);
    }
}

package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PredicateContext_setupDynamicPropertyPointer_1_1_Test {

    private PredicateContext predicateContext;

    private NodePointer parentNodePointer;

    private PropertyOwnerPointer propertyOwnerPointer;

    private PropertyPointer propertyPointer;

    private EvalContext evalContext;

    @BeforeEach
    void setUp() {
        Expression nameTestExpression = mock(Expression.class);
        evalContext = mock(EvalContext.class);
        predicateContext = new PredicateContext(evalContext, nameTestExpression);
        parentNodePointer = mock(NodePointer.class);
        propertyOwnerPointer = mock(PropertyOwnerPointer.class);
        propertyPointer = mock(PropertyPointer.class);
        // Mock the parent context to return the parentNodePointer
        when(evalContext.getCurrentNodePointer()).thenReturn(parentNodePointer);
    }

    @Test
    void testSetupDynamicPropertyPointer_NameTestExpressionNull() throws Exception {
        // Given
        setPrivateField(predicateContext, "nameTestExpression", null);
        // When
        boolean result = invokeSetupDynamicPropertyPointer(predicateContext);
        // Then
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when nameTestExpression is null");
    }

    @Test
    void testSetupDynamicPropertyPointer_ParentNodePointerNull() throws Exception {
        // Given
        setPrivateField(predicateContext, "nameTestExpression", mock(Expression.class));
        when(parentNodePointer.getValuePointer()).thenReturn(null);
        // When
        boolean result = invokeSetupDynamicPropertyPointer(predicateContext);
        // Then
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when parent node pointer is null");
    }

    @Test
    void testSetupDynamicPropertyPointer_ParentNotPropertyOwnerPointer() throws Exception {
        // Given
        setPrivateField(predicateContext, "nameTestExpression", mock(Expression.class));
        when(parentNodePointer.getValuePointer()).thenReturn(mock(NodePointer.class));
        // When
        boolean result = invokeSetupDynamicPropertyPointer(predicateContext);
        // Then
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when parent is not a PropertyOwnerPointer");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokeSetupDynamicPropertyPointer(PredicateContext context) throws Exception {
        java.lang.reflect.Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
        method.setAccessible(true);
        return (Boolean) method.invoke(context);
    }
}

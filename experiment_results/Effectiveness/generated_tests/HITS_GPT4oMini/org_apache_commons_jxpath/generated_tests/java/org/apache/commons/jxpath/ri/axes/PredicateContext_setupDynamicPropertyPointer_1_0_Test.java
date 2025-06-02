package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;

public class PredicateContext_setupDynamicPropertyPointer_1_0_Test {

    private PredicateContext predicateContext;

    private ParentContext mockParentContext;

    @BeforeEach
    public void setUp() {
        EvalContext mockEvalContext = mock(EvalContext.class);
        Expression mockExpression = mock(Expression.class);
        predicateContext = new PredicateContext(mockEvalContext, mockExpression);
        mockParentContext = mock(ParentContext.class);
        setPrivateField("parentContext", mockParentContext);
    }

    private void setPrivateField(String fieldName, Object value) {
        try {
            Field field = PredicateContext.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(predicateContext, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set private field", e);
        }
    }

    private boolean invokeSetupDynamicPropertyPointer() {
        try {
            Method method = PredicateContext.class.getDeclaredMethod("setupDynamicPropertyPointer");
            method.setAccessible(true);
            return (boolean) method.invoke(predicateContext);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke setupDynamicPropertyPointer", e);
        }
    }

    @Test
    public void testSetupDynamicPropertyPointer_NameTestExpressionIsNull() {
        setPrivateField("nameTestExpression", null);
        boolean result = invokeSetupDynamicPropertyPointer();
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when nameTestExpression is null.");
    }

    @Test
    public void testSetupDynamicPropertyPointer_ParentContextIsNull() {
        setPrivateField("parentContext", null);
        boolean result = invokeSetupDynamicPropertyPointer();
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when parentContext is null.");
    }

    @Test
    public void testSetupDynamicPropertyPointer_ParentNodePointerIsNull() {
        when(mockParentContext.getCurrentNodePointer()).thenReturn(null);
        boolean result = invokeSetupDynamicPropertyPointer();
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when parent node pointer is null.");
    }

    @Test
    public void testSetupDynamicPropertyPointer_ParentIsNotPropertyOwnerPointer() {
        NodePointer mockNodePointer = mock(NodePointer.class);
        when(mockParentContext.getCurrentNodePointer()).thenReturn(mockNodePointer);
        when(mockNodePointer.getValuePointer()).thenReturn(mockNodePointer);
        boolean result = invokeSetupDynamicPropertyPointer();
        assertFalse(result, "Expected setupDynamicPropertyPointer to return false when parent is not a PropertyOwnerPointer.");
    }

    @Test
    public void testSetupDynamicPropertyPointer_SuccessfulSetup() {
        PropertyOwnerPointer mockOwnerPointer = mock(PropertyOwnerPointer.class);
        PropertyPointer mockPropertyPointer = mock(PropertyPointer.class);
        when(mockOwnerPointer.getPropertyPointer()).thenReturn(mockPropertyPointer);
        when(mockParentContext.getCurrentNodePointer()).thenReturn(mockOwnerPointer);
        when(mockOwnerPointer.getValuePointer()).thenReturn(mockOwnerPointer);
        // Now we set a valid nameTestExpression
        Expression mockNameTestExpression = mock(Expression.class);
        setPrivateField("nameTestExpression", mockNameTestExpression);
    }
}

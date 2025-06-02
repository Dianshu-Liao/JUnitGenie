package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;
import org.apache.commons.jxpath.BasicNodeSet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;

class CoreFunction_functionNot_31_0_Test {

    private CoreFunction coreFunction;

    private Expression mockExpression;

    private EvalContext mockEvalContext;

    @BeforeEach
    void setUp() {
        // Initialize mock objects and the CoreFunction instance
        mockExpression = mock(Expression.class);
        mockEvalContext = mock(EvalContext.class);
        coreFunction = new CoreFunction(Compiler.FUNCTION_NOT, new Expression[] { mockExpression });
    }

    @Test
    void testFunctionNotTrue() throws Exception {
        // Given
        when(mockExpression.computeValue(mockEvalContext)).thenReturn(true);
        // When
        Object result = invokeFunctionNot(coreFunction, mockEvalContext);
        // Then
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testFunctionNotFalse() throws Exception {
        // Given
        when(mockExpression.computeValue(mockEvalContext)).thenReturn(false);
        // When
        Object result = invokeFunctionNot(coreFunction, mockEvalContext);
        // Then
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testFunctionNotNonBoolean() throws Exception {
        // Given
        when(mockExpression.computeValue(mockEvalContext)).thenReturn(null);
        // When
        Object result = invokeFunctionNot(coreFunction, mockEvalContext);
        // Then
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testFunctionNotInvalidArgumentCount() {
        // Given
        CoreFunction invalidCoreFunction = new CoreFunction(Compiler.FUNCTION_NOT, new Expression[] {});
        // When & Then
        assertThrows(AssertionError.class, () -> invokeFunctionNot(invalidCoreFunction, mockEvalContext));
    }

    private Object invokeFunctionNot(CoreFunction coreFunction, EvalContext context) throws Exception {
        Method method = CoreFunction.class.getDeclaredMethod("functionNot", EvalContext.class);
        method.setAccessible(true);
        return method.invoke(coreFunction, context);
    }
}

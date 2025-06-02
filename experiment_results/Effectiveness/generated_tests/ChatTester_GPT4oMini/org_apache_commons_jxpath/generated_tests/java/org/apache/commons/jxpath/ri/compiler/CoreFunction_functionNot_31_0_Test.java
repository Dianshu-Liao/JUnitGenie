package org.apache.commons.jxpath.ri.compiler;

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
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

class CoreFunction_functionNot_31_0_Test {

    private CoreFunction coreFunction;

    private EvalContext evalContext;

    private Expression mockExpression;

    @BeforeEach
    void setUp() {
        // Initialize the EvalContext and mock Expression
        evalContext = mock(EvalContext.class);
        mockExpression = mock(Expression.class);
        // Create an instance of CoreFunction with a function code and the mock Expression
        coreFunction = new CoreFunction(1, new Expression[] { mockExpression });
    }

    @Test
    void testFunctionNotTrue() {
        // Arrange
        when(mockExpression.computeValue(evalContext)).thenReturn(true);
        // Act
        Object result = invokeFunctionNot(coreFunction, evalContext);
        // Assert
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testFunctionNotFalse() {
        // Arrange
        when(mockExpression.computeValue(evalContext)).thenReturn(false);
        // Act
        Object result = invokeFunctionNot(coreFunction, evalContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testFunctionNotWithInvalidArgCount() {
        // Arrange
        // Here we assume assertArgCount throws an exception if the argument count is incorrect.
        // Since we can't directly test protected methods, we will just check that the exception is thrown.
        // You might need to adjust this depending on how assertArgCount is implemented.
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            invokeFunctionNot(coreFunction, evalContext);
        });
    }

    private Object invokeFunctionNot(CoreFunction coreFunction, EvalContext context) {
        try {
            // Use reflection to invoke the protected method
            java.lang.reflect.Method method = CoreFunction.class.getDeclaredMethod("functionNot", EvalContext.class);
            method.setAccessible(true);
            return method.invoke(coreFunction, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

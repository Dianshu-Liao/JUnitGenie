package org.apache.commons.jxpath.ri.compiler;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class CoreFunction_functionConcat_20_1_Test {

    private CoreFunction coreFunction;

    private EvalContext mockContext;

    @BeforeEach
    void setUp() {
        // Assuming functionCode is 1 and args is an empty array for this test
        coreFunction = new CoreFunction(1, new Expression[0]);
        mockContext = mock(EvalContext.class);
    }

    @Test
    void testFunctionConcat_WithLessThanTwoArguments_ShouldAssertArgCount() {
        // Arrange
        // Less than 2 arguments
        Expression[] args = new Expression[1];
        coreFunction = new CoreFunction(1, args);
        // Act & Assert
        Exception exception = assertThrows(JXPathException.class, () -> {
            invokeFunctionConcat(coreFunction, mockContext);
        });
        assertEquals("Argument count must be 2", exception.getMessage());
    }

    @Test
    void testFunctionConcat_WithTwoArguments_ShouldReturnConcatenatedString() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        when(arg1.compute(mockContext)).thenReturn("Hello");
        when(arg2.compute(mockContext)).thenReturn(" World");
        Expression[] args = { arg1, arg2 };
        coreFunction = new CoreFunction(1, args);
        // Act
        Object result = invokeFunctionConcat(coreFunction, mockContext);
        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    void testFunctionConcat_WithMultipleArguments_ShouldReturnConcatenatedString() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        Expression arg3 = mock(Expression.class);
        when(arg1.compute(mockContext)).thenReturn("Hello");
        when(arg2.compute(mockContext)).thenReturn(" ");
        when(arg3.compute(mockContext)).thenReturn("World");
        Expression[] args = { arg1, arg2, arg3 };
        coreFunction = new CoreFunction(1, args);
        // Act
        Object result = invokeFunctionConcat(coreFunction, mockContext);
        // Assert
        assertEquals("Hello World", result);
    }

    private Object invokeFunctionConcat(CoreFunction coreFunction, EvalContext context) {
        try {
            java.lang.reflect.Method method = CoreFunction.class.getDeclaredMethod("functionConcat", EvalContext.class);
            method.setAccessible(true);
            return method.invoke(coreFunction, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

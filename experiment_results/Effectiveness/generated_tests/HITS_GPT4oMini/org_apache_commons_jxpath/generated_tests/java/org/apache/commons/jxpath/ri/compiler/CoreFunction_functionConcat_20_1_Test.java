package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
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
import org.apache.commons.jxpath.ri.model.NodePointer;

public class CoreFunction_functionConcat_20_1_Test {

    private CoreFunction coreFunction;

    private EvalContext evalContext;

    @BeforeEach
    public void setUp() {
        // Mock the EvalContext
        evalContext = mock(EvalContext.class);
        // Initialize CoreFunction with a function code for CONCAT
        coreFunction = new CoreFunction(Compiler.FUNCTION_CONCAT, new Expression[2]);
    }

    @Test
    public void testFunctionConcat_WithTwoStringArguments() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        when(arg1.compute(evalContext)).thenReturn("Hello");
        when(arg2.compute(evalContext)).thenReturn(" World");
        coreFunction.args = new Expression[] { arg1, arg2 };
        // Act
        String result = (String) coreFunction.functionConcat(evalContext);
        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testFunctionConcat_WithEmptyArguments() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        when(arg1.compute(evalContext)).thenReturn("");
        when(arg2.compute(evalContext)).thenReturn("");
        coreFunction.args = new Expression[] { arg1, arg2 };
        // Act
        String result = (String) coreFunction.functionConcat(evalContext);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testFunctionConcat_WithNullArguments() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        when(arg1.compute(evalContext)).thenReturn(null);
        when(arg2.compute(evalContext)).thenReturn(null);
        coreFunction.args = new Expression[] { arg1, arg2 };
        // Act
        String result = (String) coreFunction.functionConcat(evalContext);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testFunctionConcat_WithMixedArguments() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        when(arg1.compute(evalContext)).thenReturn("Hello");
        when(arg2.compute(evalContext)).thenReturn(null);
        coreFunction.args = new Expression[] { arg1, arg2 };
        // Act
        String result = (String) coreFunction.functionConcat(evalContext);
        // Assert
        assertEquals("Hello", result);
    }

    @Test
    public void testFunctionConcat_WithMultipleArguments() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        Expression arg2 = mock(Expression.class);
        Expression arg3 = mock(Expression.class);
        when(arg1.compute(evalContext)).thenReturn("Java");
        when(arg2.compute(evalContext)).thenReturn(" ");
        when(arg3.compute(evalContext)).thenReturn("Rocks");
        coreFunction.args = new Expression[] { arg1, arg2, arg3 };
        // Act
        String result = (String) coreFunction.functionConcat(evalContext);
        // Assert
        assertEquals("Java Rocks", result);
    }

    @Test
    public void testFunctionConcat_WithInsufficientArguments() {
        // Arrange
        coreFunction.args = new Expression[] { mock(Expression.class) };
        // Act & Assert
        assertThrows(AssertionError.class, () -> coreFunction.functionConcat(evalContext));
    }
}

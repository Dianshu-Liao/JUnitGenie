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

public class CoreFunction_functionNot_31_0_Test {

    private CoreFunction coreFunction;

    private EvalContext mockContext;

    @BeforeEach
    public void setUp() {
        // Initialize the CoreFunction with a function code for NOT operation
        coreFunction = new CoreFunction(Compiler.FUNCTION_NOT, new Expression[1]);
        mockContext = mock(EvalContext.class);
    }

    @Test
    public void testFunctionNotWithTrueValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        when(arg1.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testFunctionNotWithFalseValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        when(arg1.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testFunctionNotWithNonBooleanValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        // Non-boolean value
        when(arg1.computeValue(mockContext)).thenReturn(1);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        // Since 1 is treated as true
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testFunctionNotWithZeroValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        // Zero is false
        when(arg1.computeValue(mockContext)).thenReturn(0);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testFunctionNotWithNullValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        // Null should return true
        when(arg1.computeValue(mockContext)).thenReturn(null);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testFunctionNotWithNaNValue() {
        // Arrange
        Expression arg1 = mock(Expression.class);
        // NaN is treated as false
        when(arg1.computeValue(mockContext)).thenReturn(Double.NaN);
        coreFunction.args[0] = arg1;
        // Act
        Object result = coreFunction.functionNot(mockContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }
}

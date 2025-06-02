package org.apache.commons.jxpath.ri.compiler;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoreFunction_functionStringLength_27_0_Test {

    private CoreFunction coreFunction;

    private EvalContext mockContext;

    @BeforeEach
    public void setUp() {
        coreFunction = new CoreFunction(1, new Expression[] {});
        mockContext = Mockito.mock(EvalContext.class);
    }

    @Test
    public void testFunctionStringLength_NoArguments() {
        // Fixed Line: Use NodePointer instead of Pointer
        NodePointer mockPointer = Mockito.mock(NodePointer.class);
        when(mockContext.getCurrentNodePointer()).thenReturn(mockPointer);
        when(InfoSetUtil.stringValue(mockPointer)).thenReturn("test");
        // Act
        Object result = invokeFunctionStringLength(coreFunction, mockContext);
        // Assert
        assertEquals(4.0, result);
    }

    @Test
    public void testFunctionStringLength_WithArgument() {
        // Arrange
        Expression mockArg = Mockito.mock(Expression.class);
        when(mockArg.computeValue(mockContext)).thenReturn("example");
        coreFunction = new CoreFunction(1, new Expression[] { mockArg });
        // Act
        Object result = invokeFunctionStringLength(coreFunction, mockContext);
        // Assert
        assertEquals(7.0, result);
    }

    @Test
    public void testFunctionStringLength_EmptyString() {
        // Fixed Line: Use NodePointer instead of Pointer
        NodePointer mockPointer = Mockito.mock(NodePointer.class);
        when(mockContext.getCurrentNodePointer()).thenReturn(mockPointer);
        when(InfoSetUtil.stringValue(mockPointer)).thenReturn("");
        // Act
        Object result = invokeFunctionStringLength(coreFunction, mockContext);
        // Assert
        assertEquals(0.0, result);
    }

    @Test
    public void testFunctionStringLength_NullPointer() {
        // Arrange
        when(mockContext.getCurrentNodePointer()).thenReturn(null);
        when(InfoSetUtil.stringValue(null)).thenReturn(null);
        // Act
        Object result = invokeFunctionStringLength(coreFunction, mockContext);
        // Assert
        assertEquals(0.0, result);
    }

    private Object invokeFunctionStringLength(CoreFunction coreFunction, EvalContext context) {
        try {
            java.lang.reflect.Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
            method.setAccessible(true);
            return method.invoke(coreFunction, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import java.lang.reflect.Method;
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
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class CoreFunction_functionConcat_20_4_Test {

    private CoreFunction coreFunction;

    private Expression[] mockExpressions;

    private EvalContext mockEvalContext;

    @BeforeEach
    public void setUp() {
        mockExpressions = new Expression[3];
        mockEvalContext = mock(EvalContext.class);
        coreFunction = new CoreFunction(Compiler.FUNCTION_CONCAT, mockExpressions);
    }

    @Test
    public void testFunctionConcatWithTwoArguments() throws Exception {
        // Arrange
        when(mockExpressions[0].compute(mockEvalContext)).thenReturn("Hello");
        when(mockExpressions[1].compute(mockEvalContext)).thenReturn(" World");
        // Act
        String result = invokeFunctionConcat(coreFunction, mockEvalContext);
        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testFunctionConcatWithThreeArguments() throws Exception {
        // Arrange
        when(mockExpressions[0].compute(mockEvalContext)).thenReturn("Hello");
        when(mockExpressions[1].compute(mockEvalContext)).thenReturn(" ");
        when(mockExpressions[2].compute(mockEvalContext)).thenReturn("World");
        // Act
        String result = invokeFunctionConcat(coreFunction, mockEvalContext);
        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testFunctionConcatWithEmptyArguments() throws Exception {
        // Arrange
        when(mockExpressions[0].compute(mockEvalContext)).thenReturn("");
        when(mockExpressions[1].compute(mockEvalContext)).thenReturn("");
        // Act
        String result = invokeFunctionConcat(coreFunction, mockEvalContext);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testFunctionConcatWithNullArguments() throws Exception {
        // Arrange
        when(mockExpressions[0].compute(mockEvalContext)).thenReturn(null);
        when(mockExpressions[1].compute(mockEvalContext)).thenReturn(null);
        // Act
        String result = invokeFunctionConcat(coreFunction, mockEvalContext);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testFunctionConcatWithInsufficientArguments() {
        // Arrange
        CoreFunction insufficientArgsFunction = new CoreFunction(Compiler.FUNCTION_CONCAT, new Expression[1]);
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeFunctionConcat(insufficientArgsFunction, mockEvalContext);
        });
        assertTrue(exception.getMessage().contains("Argument count mismatch"));
    }

    private String invokeFunctionConcat(CoreFunction coreFunction, EvalContext context) throws Exception {
        Method method = CoreFunction.class.getDeclaredMethod("functionConcat", EvalContext.class);
        method.setAccessible(true);
        return (String) method.invoke(coreFunction, context);
    }
}

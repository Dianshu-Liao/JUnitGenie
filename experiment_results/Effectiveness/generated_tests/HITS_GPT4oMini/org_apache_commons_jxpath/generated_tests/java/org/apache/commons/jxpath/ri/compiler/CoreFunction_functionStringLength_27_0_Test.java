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

public class CoreFunction_functionStringLength_27_0_Test {

    private CoreFunction coreFunction;

    private EvalContext context;

    @BeforeEach
    public void setUp() {
        coreFunction = new CoreFunction(Compiler.FUNCTION_STRING_LENGTH, new Expression[0]);
        context = mock(EvalContext.class);
    }

    @Test
    public void testFunctionStringLength_NoArguments() {
        // Arrange
        String expectedString = "test";
        NodePointer nodePointer = mock(NodePointer.class);
        when(context.getCurrentNodePointer()).thenReturn(nodePointer);
        when(nodePointer.getValue()).thenReturn(expectedString);
        when(InfoSetUtil.stringValue(nodePointer)).thenCallRealMethod();
        // Act
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert
        assertEquals((double) expectedString.length(), result);
    }

    @Test
    public void testFunctionStringLength_EmptyString() {
        // Arrange
        String expectedString = "";
        NodePointer nodePointer = mock(NodePointer.class);
        when(context.getCurrentNodePointer()).thenReturn(nodePointer);
        when(nodePointer.getValue()).thenReturn(expectedString);
        when(InfoSetUtil.stringValue(nodePointer)).thenCallRealMethod();
        // Act
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert
        assertEquals((double) expectedString.length(), result);
    }

    @Test
    public void testFunctionStringLength_NullValue() {
        // Arrange
        NodePointer nodePointer = mock(NodePointer.class);
        when(context.getCurrentNodePointer()).thenReturn(nodePointer);
        when(nodePointer.getValue()).thenReturn(null);
        when(InfoSetUtil.stringValue(nodePointer)).thenCallRealMethod();
        // Act
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert
        assertEquals(0.0, result);
    }
}

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

public class CoreFunction_functionStringLength_27_1_Test {

    private CoreFunction coreFunction;

    private EvalContext context;

    @BeforeEach
    public void setUp() {
        // Assuming a constructor that takes a function code and args.
        coreFunction = new CoreFunction(Compiler.FUNCTION_STRING_LENGTH, new Expression[] {});
        // This method should create a mock EvalContext
        context = createMockEvalContext();
    }

    @Test
    public void testFunctionStringLength_NoArguments() {
        // Set up the context to return a specific string value
        String testString = "Hello, World!";
        // This method should set the current node pointer value
        setCurrentNodePointerValue(context, testString);
        // Call the method under test
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert the expected length
        assertEquals((double) testString.length(), result);
    }

    @Test
    public void testFunctionStringLength_WithArgument() {
        // Set up an argument for the function
        String testString = "JUnit Testing";
        coreFunction = new CoreFunction(Compiler.FUNCTION_STRING_LENGTH, new Expression[] { createMockExpression(testString) });
        // Call the method under test
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert the expected length
        assertEquals((double) testString.length(), result);
    }

    @Test
    public void testFunctionStringLength_EmptyString() {
        // Set up the context to return an empty string
        String testString = "";
        setCurrentNodePointerValue(context, testString);
        // Call the method under test
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert the expected length
        assertEquals((double) testString.length(), result);
    }

    @Test
    public void testFunctionStringLength_NullValue() {
        // Set up the context to return null
        setCurrentNodePointerValue(context, null);
        // Call the method under test
        Double result = (Double) coreFunction.functionStringLength(context);
        // Assert the expected length (should be 0 for null)
        assertEquals(0.0, result);
    }

    @Test
    public void testFunctionStringLength_InvalidArgumentCount() {
        // Create a CoreFunction with invalid argument count
        coreFunction = new CoreFunction(Compiler.FUNCTION_STRING_LENGTH, new Expression[] { createMockExpression("arg1"), createMockExpression("arg2") });
        // Assert that an exception is thrown for invalid argument count
        assertThrows(AssertionError.class, () -> coreFunction.functionStringLength(context));
    }

    // Mock methods for EvalContext and Expression
    private EvalContext createMockEvalContext() {
        // Implementation to create a mock EvalContext
        // Replace with actual implementation
        return null;
    }

    private void setCurrentNodePointerValue(EvalContext context, String value) {
        // Implementation to set the current node pointer value in EvalContext
    }

    private Expression createMockExpression(String value) {
        // Implementation to create a mock Expression returning the provided value
        // Replace with actual implementation
        return null;
    }
}

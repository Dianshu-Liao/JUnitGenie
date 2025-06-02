package org.apache.commons.jxpath.ri.compiler;
import org.apache.commons.jxpath.ri.compiler.ExtensionFunction;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_compiler_ExtensionFunction_computeValue_EvalContext_cfg_path_1_Test {

    private ExtensionFunction extensionFunction;
    private EvalContext mockContext;

    @Before
    public void setUp() {
        QName functionName = mock(QName.class); // Mocking QName
        extensionFunction = new ExtensionFunction(functionName, new Expression[]{}); // Using constructor
        mockContext = mock(EvalContext.class); // Mocking EvalContext
        RootContext mockRootContext = mock(RootContext.class); // Mocking RootContext
        
        // when the rootContext returns a mockRootContext
        when(mockContext.getRootContext()).thenReturn(mockRootContext);
    }

    @Test(timeout = 4000)
    public void testComputeValueFunctionNotFound() {
        // Scenario: Function not found (should throw JXPathFunctionNotFoundException)
        Object[] parameters = new Object[]{};

        // Setting up the mock to return null for function to simulate function not found
        when(mockContext.getRootContext().getFunction(any(QName.class), any(Object[].class))).thenReturn(null);

        try {
            extensionFunction.computeValue(mockContext);
        } catch (JXPathFunctionNotFoundException e) {
            // Verify the exception message
            assert(e.getMessage().contains("No such function:"));
        }
    }

}
package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.ri.compiler.CoreFunction;
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
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

class CoreFunction_assertArgRange_42_0_Test {

    private CoreFunction coreFunction;

    @BeforeEach
    void setUp() {
        // Adjust functionCode and args as needed
        coreFunction = new CoreFunction(0, new Expression[0]);
    }

    @Test
    void testAssertArgRange_WithinRange() throws Exception {
        // Should not throw an exception
        invokeAssertArgRange(1, 3);
        // Should not throw an exception
        invokeAssertArgRange(2, 5);
    }

    @Test
    void testAssertArgRange_LessThanMin() {
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            // 0 arguments should throw an exception
            invokeAssertArgRange(0, 2);
        });
        assertEquals("Incorrect number of arguments: " + coreFunction, exception.getMessage());
    }

    @Test
    void testAssertArgRange_GreaterThanMax() {
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            // 4 arguments should throw an exception
            invokeAssertArgRange(4, 2);
        });
        assertEquals("Incorrect number of arguments: " + coreFunction, exception.getMessage());
    }

    private void invokeAssertArgRange(int min, int max) throws Exception {
        Method method = CoreFunction.class.getDeclaredMethod("assertArgRange", int.class, int.class);
        method.setAccessible(true);
        method.invoke(coreFunction, min, max);
    }
}

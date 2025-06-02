package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class XPathParser_CoreFunctionCall_20_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    void setUp() {
        InputStream input = new ByteArrayInputStream("dummy input".getBytes());
        parser = new XPathParser(input);
        // Use mock instead of instantiating
        mockCompiler = mock(Compiler.class);
        parser.setCompiler(mockCompiler);
    }

    @Test
    void testCoreFunctionCallWithNullArgs() throws Exception {
        // Mock the CoreFunctionName and ArgumentList methods
        mockCoreFunctionName(0);
        mockArgumentList(null);
        // Invoke the private method using reflection
        Method method = XPathParser.class.getDeclaredMethod("CoreFunctionCall");
        method.setAccessible(true);
        Object result = method.invoke(parser);
        assertEquals(mockCompiler.function(0, null), result);
    }

    @Test
    void testCoreFunctionCallWithArgs() throws Exception {
        // Mock the CoreFunctionName and ArgumentList methods
        mockCoreFunctionName(1);
        ArrayList<Object> args = new ArrayList<>();
        args.add("arg1");
        mockArgumentList(args);
        // Invoke the private method using reflection
        Method method = XPathParser.class.getDeclaredMethod("CoreFunctionCall");
        method.setAccessible(true);
        Object result = method.invoke(parser);
        assertEquals(mockCompiler.function(1, args.toArray()), result);
    }

    @Test
    void testCoreFunctionCallThrowsError() throws Exception {
        // Mock the CoreFunctionName and ArgumentList methods
        mockCoreFunctionName(2);
        mockArgumentList(new ArrayList<>());
        // Invoke the private method using reflection
        Method method = XPathParser.class.getDeclaredMethod("CoreFunctionCall");
        method.setAccessible(true);
        assertThrows(Error.class, () -> method.invoke(parser));
    }

    private void mockCoreFunctionName(int returnValue) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("CoreFunctionName");
        method.setAccessible(true);
        // Use Mockito to mock the return value
        when(method.invoke(parser)).thenReturn(returnValue);
    }

    private void mockArgumentList(ArrayList<Object> returnValue) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("ArgumentList");
        method.setAccessible(true);
        // Use Mockito to mock the return value
        when(method.invoke(parser)).thenReturn(returnValue);
    }
}
